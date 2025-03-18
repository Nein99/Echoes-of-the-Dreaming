package net.aaronkersh.echoesofthedreaming.entity.custom;

import net.aaronkersh.echoesofthedreaming.animation.MourningOrewalkerAnimations;
import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MourningOrewalkerEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;
    private int attackTicksLeft;
    private boolean attackAnimation;

    public MourningOrewalkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        // Idle animation handler
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        // Walking animation handler
        if (this.isWalking()) {
            this.walkAnimationState.startIfNotRunning(this.age);
        } else {
            this.walkAnimationState.stop();
        }

        // Attack animation handler
        if (this.attackTicksLeft > 0) {
            this.attackAnimationState.startIfNotRunning(this.age);
        } else {
            this.attackAnimationState.stop();
        }
    }

    private boolean isWalking() {
        return this.isNavigating();
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }

        // Handle attack animation
        if (this.attackTicksLeft > 0) {
            --this.attackTicksLeft;
        }

        // Clear Malignant Aura if somehow applied
        if (this.hasStatusEffect(ModEffects.MALIGNANT_AURA)) {
            this.removeStatusEffect(ModEffects.MALIGNANT_AURA);
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.9D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createMourningOrewalkerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 8.0D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5D);
    }

    @Override
    public boolean tryAttack(Entity target) {
        this.attackTicksLeft = 25; // Set to match the ATTACK animation length (1.25s at 20 ticks per second)
        this.getWorld().sendEntityStatus(this, (byte)4);

        float damage = (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float knockback = (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_KNOCKBACK);

        boolean attacked = target.damage(getDamageSources().mobAttack(this), damage);

        if (attacked) {
            if (target instanceof LivingEntity living) {
                // Apply Malignant Aura on hit
                living.addStatusEffect(new StatusEffectInstance(ModEffects.MALIGNANT_AURA, 200, 0));

                // Apply knockback
                ((LivingEntity)target).takeKnockback(knockback * 0.5F,
                        Math.sin(this.getYaw() * 0.017453292F),
                        -Math.cos(this.getYaw() * 0.017453292F));
            }

            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        }

        return attacked;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 4) {
            this.attackAnimation = true;
            this.attackTicksLeft = 25; // Match with the attack animation duration
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatus(status);
        }
    }

    // Method for the model to check if entity is currently attacking
    public boolean isAttacking() {
        return this.attackTicksLeft > 0;
    }

    @Override
    public boolean isImmuneToExplosion() {
        return true;
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);

        // Drop Cursed Soulstone guaranteed
        this.dropItem(ModItems.CURSED_SOULSTONE);

        // Drop 0-3 Mourncryst
        Random random = this.getRandom();
        int mourncrystAmount = random.nextInt(4); // 0-3
        for (int i = 0; i < mourncrystAmount; i++) {
            this.dropItem(ModItems.MOURNCRYST);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }
}
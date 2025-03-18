// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.aaronkersh.echoesofthedreaming.entity.client;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.animation.MourningOrewalkerAnimations;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class MourningOrewalkerModel<T extends MourningOrewalkerEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer MOURNING_OREWALKER = new EntityModelLayer(Identifier.of(EchoesOfTheDreaming.MOD_ID, "mourning_orewalker"), "main");
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	public MourningOrewalkerModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(0, 32).cuboid(-10.0F, 1.0F, 16.0F, 15.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -5.0F, -13.0F));

		ModelPartData cube_r1 = Body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -5.0F, -19.0F, 4.0F, 4.0F, 4.0F, new Dilation(1.0F)), ModelTransform.of(-19.0F, -6.0F, 34.0F, -0.3054F, 0.3491F, 1.0472F));

		ModelPartData cube_r2 = Body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -5.0F, -19.0F, 4.0F, 4.0F, 4.0F, new Dilation(1.0F)), ModelTransform.of(-10.0F, -3.0F, 22.0F, -0.3054F, 0.3491F, 0.829F));

		ModelPartData cube_r3 = Body.addChild("cube_r3", ModelPartBuilder.create().uv(64, 0).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-12.0F, 4.0F, 30.0F, -0.5236F, -0.3491F, 0.7854F));

		ModelPartData cube_r4 = Body.addChild("cube_r4", ModelPartBuilder.create().uv(64, 16).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-19.0F, -4.0F, 28.0F, -0.5236F, -0.3491F, 0.7854F));

		ModelPartData cube_r5 = Body.addChild("cube_r5", ModelPartBuilder.create().uv(64, 16).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-10.0F, 3.0F, 21.0F, -0.5236F, 0.5236F, 0.7854F));

		ModelPartData cube_r6 = Body.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -17.0F, -19.0F, 16.0F, 16.0F, 16.0F, new Dilation(1.0F)), ModelTransform.of(-11.0F, 9.0F, 19.0F, -0.5236F, 0.5236F, 0.7854F));

		ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(51, 32).cuboid(-9.0F, -10.0F, -1.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -5.0F, -13.0F));

		ModelPartData LeftArm = modelPartData.addChild("LeftArm", ModelPartBuilder.create(), ModelTransform.pivot(-13.0F, 14.0F, -11.0F));

		ModelPartData cube_r7 = LeftArm.addChild("cube_r7", ModelPartBuilder.create().uv(0, 89).cuboid(0.0F, -14.0F, -4.0F, 7.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(18.0F, -8.0F, 3.0F, -0.3491F, 0.0F, -0.1745F));

		ModelPartData cube_r8 = LeftArm.addChild("cube_r8", ModelPartBuilder.create().uv(88, 84).cuboid(-3.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(20.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData cube_r9 = LeftArm.addChild("cube_r9", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(21.0F, -5.0F, -1.0F, -0.5236F, 0.0F, 0.0873F));

		ModelPartData RightArm = modelPartData.addChild("RightArm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r10 = RightArm.addChild("cube_r10", ModelPartBuilder.create().uv(41, 76).cuboid(-3.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -10.0F, -11.0F, 0.0F, -0.3491F, 0.0F));

		ModelPartData cube_r11 = RightArm.addChild("cube_r11", ModelPartBuilder.create().uv(62, 52).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -15.0F, -11.0F, -0.48F, 0.0436F, -0.0873F));

		ModelPartData cube_r12 = RightArm.addChild("cube_r12", ModelPartBuilder.create().uv(33, 53).cuboid(-3.0F, -14.0F, -4.0F, 7.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -18.0F, -8.0F, -0.3491F, 0.0F, 0.1745F));

		ModelPartData LeftLeg = modelPartData.addChild("LeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r13 = LeftLeg.addChild("cube_r13", ModelPartBuilder.create().uv(50, 106).cuboid(-2.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.0F, 11.0F, 0.0F, -0.0873F, 0.0F));

		ModelPartData cube_r14 = LeftLeg.addChild("cube_r14", ModelPartBuilder.create().uv(96, 25).cuboid(-3.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -15.0F, 8.0F, 0.0F, 0.0873F, 0.0F));

		ModelPartData cube_r15 = LeftLeg.addChild("cube_r15", ModelPartBuilder.create().uv(23, 108).cuboid(0.0F, -14.0F, -5.0F, 7.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -14.0F, 9.0F, -0.1745F, 0.0F, -0.1309F));

		ModelPartData RightLeg = modelPartData.addChild("RightLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r16 = RightLeg.addChild("cube_r16", ModelPartBuilder.create().uv(0, 67).cuboid(-4.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -10.0F, 11.0F, 0.0F, 0.0873F, 0.0F));

		ModelPartData cube_r17 = RightLeg.addChild("cube_r17", ModelPartBuilder.create().uv(96, 65).cuboid(-5.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -15.0F, 8.0F, 0.0F, -0.0873F, 0.0F));

		ModelPartData cube_r18 = RightLeg.addChild("cube_r18", ModelPartBuilder.create().uv(102, 44).cuboid(-3.0F, -14.0F, -5.0F, 7.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -14.0F, 9.0F, -0.1745F, 0.0F, 0.1309F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(MourningOrewalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(MourningOrewalkerAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, MourningOrewalkerAnimations.IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		LeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		RightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		LeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		RightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Body;
	}
}
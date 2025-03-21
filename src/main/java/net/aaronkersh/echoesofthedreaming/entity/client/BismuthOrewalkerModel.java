// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.aaronkersh.echoesofthedreaming.entity.client;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.entity.animation.BismuthOrewalkerAnimations;
import net.aaronkersh.echoesofthedreaming.entity.custom.BismuthOrewalkerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BismuthOrewalkerModel<T extends BismuthOrewalkerEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer BISMUTH_OREWALKER = new EntityModelLayer(Identifier.of(EchoesOfTheDreaming.MOD_ID, "bismuth_orewalker"), "main");
	private ModelPart root;
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	public BismuthOrewalkerModel(ModelPart root) {
		this.root = root;
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
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(0, 32).cuboid(-6.1013F, 4.9094F, 0.4258F, 15.0F, 6.0F, 10.0F, new Dilation(0.0F))
				.uv(81, 39).cuboid(-10.2207F, -5.4857F, 3.9503F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F))
				.uv(42, 46).cuboid(7.7793F, 0.5143F, -0.0497F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F))
				.uv(-8, -4).cuboid(-1.2207F, -9.4857F, 2.9503F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F))
				.uv(13, 6).cuboid(9.7793F, -2.4857F, -12.0497F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F))
				.uv(4, 5).cuboid(-12.2207F, -7.4857F, -10.0497F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.8987F, -8.9094F, 2.5742F));

		ModelPartData cube_r1 = Body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -5.0F, -19.0F, 4.0F, 4.0F, 4.0F, new Dilation(1.0F)), ModelTransform.of(-15.1013F, -2.0906F, 18.4258F, -0.3054F, 0.3491F, 1.0472F));

		ModelPartData cube_r2 = Body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -5.0F, -19.0F, 4.0F, 4.0F, 4.0F, new Dilation(1.0F)), ModelTransform.of(-6.1013F, 0.9094F, 6.4258F, -0.3054F, 0.3491F, 0.829F));

		ModelPartData cube_r3 = Body.addChild("cube_r3", ModelPartBuilder.create().uv(64, 0).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-8.1013F, 7.9094F, 14.4258F, -0.5236F, -0.3491F, 0.7854F));

		ModelPartData cube_r4 = Body.addChild("cube_r4", ModelPartBuilder.create().uv(64, 16).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-15.1013F, -0.0906F, 12.4258F, -0.5236F, -0.3491F, 0.7854F));

		ModelPartData cube_r5 = Body.addChild("cube_r5", ModelPartBuilder.create().uv(64, 16).cuboid(0.0F, -9.0F, -19.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(-6.1013F, 6.9094F, 5.4258F, -0.5236F, 0.5236F, 0.7854F));

		ModelPartData cube_r6 = Body.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -17.0F, -19.0F, 16.0F, 16.0F, 16.0F, new Dilation(1.0F)), ModelTransform.of(-7.1013F, 12.9094F, 3.4258F, -0.5236F, 0.5236F, 0.7854F));

		ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(57, 25).cuboid(-4.3324F, -3.4401F, -9.7033F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F))
				.uv(12, 74).cuboid(-7.0F, -4.0F, -12.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F))
				.uv(90, 87).cuboid(2.0F, -4.0F, -12.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.1194F, -14.395F, -6.4755F));

		ModelPartData LeftArm = modelPartData.addChild("LeftArm", ModelPartBuilder.create().uv(37, 28).cuboid(-5.97F, 23.8688F, -16.8721F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(3, 49).cuboid(-2.97F, 7.8688F, -8.8721F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(54, 76).cuboid(2.03F, 11.8688F, -5.8721F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(5.8506F, -8.2638F, -2.6034F));

		ModelPartData cube_r7 = LeftArm.addChild("cube_r7", ModelPartBuilder.create().uv(0, 89).cuboid(0.0F, -14.0F, -4.0F, 7.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.8506F, 14.2638F, -5.3966F, -0.3491F, 0.0F, -0.1745F));

		ModelPartData cube_r8 = LeftArm.addChild("cube_r8", ModelPartBuilder.create().uv(88, 84).cuboid(-3.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(1.1494F, 22.2638F, -8.3966F, 0.0F, 0.3491F, 0.0F));

		ModelPartData cube_r9 = LeftArm.addChild("cube_r9", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.1494F, 17.2638F, -9.3966F, -0.5236F, 0.0F, 0.0873F));

		ModelPartData RightArm = modelPartData.addChild("RightArm", ModelPartBuilder.create().uv(64, 89).cuboid(-10.5014F, 23.6372F, -9.6615F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(31, 39).cuboid(-2.5014F, 12.6372F, -13.6615F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(18, 87).cuboid(-5.5014F, 4.6372F, -3.6615F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.6179F, -8.0323F, -2.814F));

		ModelPartData cube_r10 = RightArm.addChild("cube_r10", ModelPartBuilder.create().uv(41, 76).cuboid(-3.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-5.3821F, 22.0323F, -8.186F, 0.0F, -0.3491F, 0.0F));

		ModelPartData cube_r11 = RightArm.addChild("cube_r11", ModelPartBuilder.create().uv(62, 52).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.3821F, 17.0323F, -8.186F, -0.48F, 0.0436F, -0.0873F));

		ModelPartData cube_r12 = RightArm.addChild("cube_r12", ModelPartBuilder.create().uv(33, 53).cuboid(-3.0F, -14.0F, -4.0F, 7.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.3821F, 14.0323F, -5.186F, -0.3491F, 0.0F, 0.1745F));

		ModelPartData LeftLeg = modelPartData.addChild("LeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r13 = LeftLeg.addChild("cube_r13", ModelPartBuilder.create().uv(50, 106).cuboid(-2.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.0F, 11.0F, 0.0F, -0.0873F, 0.0F));

		ModelPartData cube_r14 = LeftLeg.addChild("cube_r14", ModelPartBuilder.create().uv(96, 25).cuboid(-3.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -15.0F, 8.0F, 0.0F, 0.0873F, 0.0F));

		ModelPartData cube_r15 = LeftLeg.addChild("cube_r15", ModelPartBuilder.create().uv(23, 108).cuboid(0.0F, -14.0F, -5.0F, 7.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -14.0F, 9.0F, -0.1745F, 0.0F, -0.1309F));

		ModelPartData RightLeg = modelPartData.addChild("RightLeg", ModelPartBuilder.create(), ModelTransform.pivot(-5.5778F, 9.9621F, 8.3597F));

		ModelPartData cube_r16 = RightLeg.addChild("cube_r16", ModelPartBuilder.create().uv(0, 67).cuboid(-4.0F, -2.0F, -7.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-2.4222F, 4.0379F, 2.6403F, 0.0F, 0.0873F, 0.0F));

		ModelPartData cube_r17 = RightLeg.addChild("cube_r17", ModelPartBuilder.create().uv(96, 65).cuboid(-5.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.5778F, -0.9621F, -0.3597F, 0.0F, -0.0873F, 0.0F));

		ModelPartData cube_r18 = RightLeg.addChild("cube_r18", ModelPartBuilder.create().uv(102, 44).cuboid(-3.0F, -14.0F, -5.0F, 7.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.4222F, 0.0379F, 0.6403F, -0.1745F, 0.0F, 0.1309F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(BismuthOrewalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(BismuthOrewalkerAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, BismuthOrewalkerAnimations.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, BismuthOrewalkerAnimations.ATTACK, ageInTicks, 1f);
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
		return this.root;
	}
}
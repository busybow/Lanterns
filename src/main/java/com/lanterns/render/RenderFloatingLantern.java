package com.lanterns.render;

import com.lanterns.LanternsMod;
import com.lanterns.models.ModelFloating;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFloatingLantern extends RenderLiving {

	private static final ResourceLocation textureLocation = new ResourceLocation(LanternsMod.MODID + ":" + "textures/models/FloatingLantern.png");

	public RenderFloatingLantern(ModelFloating model, float shadowSize) {
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return textureLocation;
	}
}
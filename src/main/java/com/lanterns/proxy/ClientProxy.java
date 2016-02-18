package com.lanterns.proxy;

import com.lanterns.entities.FloatingLanternEntity;
import com.lanterns.entities.SpiderLanternEntity;
import com.lanterns.models.ModelFloating;
import com.lanterns.models.ModelSpider;
import com.lanterns.render.RenderFloatingLantern;
import com.lanterns.render.RenderSpiderLantern;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(SpiderLanternEntity.class, new RenderSpiderLantern(new ModelSpider(), 0.1F));
		RenderingRegistry.registerEntityRenderingHandler(FloatingLanternEntity.class, new RenderFloatingLantern(new ModelFloating(), 0.1F));
	}
}

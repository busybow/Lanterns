package com.lanterns.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class SpiderLanternEntity extends EntityCreature{

	public SpiderLanternEntity(World p_i1582_1_) {
		super(p_i1582_1_);
	}
	
	/**
	 * used to catch update tick server event
	 */
	public void onLivingUpdate()
    {
		addLight();
		super.onLivingUpdate();
    }
	
	/**
	 * used to add light around the lantern entity
	 */
	private void addLight() {
		this.worldObj.setLightValue(EnumSkyBlock.Block, (int) this.posX, (int) this.posY, (int) this.posZ, 9);
		this.worldObj.markBlockRangeForRenderUpdate((int) this.posX, (int) this.posY, (int) this.posX, 12, 12, 12);
		this.worldObj.markBlockForUpdate((int) this.posX, (int) this.posY, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX, (int) this.posY + 1, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX, (int) this.posY - 1, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block,	(int) this.posX + 1, (int) this.posY, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block,	(int) this.posX - 1, (int) this.posY, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX, (int) this.posY, (int) this.posZ + 1);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX, (int) this.posY, (int) this.posZ - 1);
	}
}
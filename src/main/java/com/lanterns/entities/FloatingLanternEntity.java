package com.lanterns.entities;

import com.lanterns.entities.ai.FloatingEntityAi;

import net.minecraft.entity.EntityFlying;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class FloatingLanternEntity extends EntityFlying{

	Float moveSpeed = 0.25F;
	float f2 = 0.91F;
	
	public FloatingLanternEntity(World p_i1582_1_) {
		super(p_i1582_1_);
		this.moveFlying(this.moveForward, this.moveStrafing, moveSpeed);
		
		//custom ai task
		this.tasks.addTask(1, new FloatingEntityAi(this));
	}
	
	/**
	 * Used to work with a custom AI
	 */
	@Override
	protected boolean isAIEnabled()
	{
	   return true;
	}
	
	/**
	 * used to catch update tick server event
	 */
	public void onLivingUpdate()
    {
		//kill the entity if too high
		if (this.posY > Double.parseDouble("250")) {
			this.setDead();
			System.out.println("lantern's dead");
		}
			
		addLight();
		super.onLivingUpdate();
    }
	
	/**
	 * used to add light around the lantern entity
	 */
	private void addLight() {
		this.worldObj.setLightValue(EnumSkyBlock.Block, (int) this.posX, (int) this.posY, (int) this.posZ, 12);
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
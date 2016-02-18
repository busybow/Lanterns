package com.lanterns.entities;

import net.minecraft.entity.EntityFlying;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class FloatingLanternEntity extends EntityFlying{

	Float moveSpeed = 0.25F;
	float f2 = 0.91F;
	
	public FloatingLanternEntity(World p_i1582_1_) {
		super(p_i1582_1_);
		this.moveFlying(this.moveForward, this.moveStrafing, moveSpeed);
		
		//movement test
		PathEntity pathentity = this.getNavigator().getPathToXYZ(this.posX, (double) 255, this.posZ);
		System.out.println(pathentity);
		if (pathentity != null && !pathentity.isFinished())
        {
            for (int i = 0; i < Math.min(pathentity.getCurrentPathIndex() + 2, pathentity.getCurrentPathLength()); ++i)
            {
                PathPoint pathpoint = pathentity.getPathPointFromIndex(i);
                this.posX = pathpoint.xCoord;
                this.posY = pathpoint.yCoord + 1;
                this.posZ = pathpoint.zCoord;            }
        }
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
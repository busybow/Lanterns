package com.lanterns.entities.ai;

import com.lanterns.entities.FloatingLanternEntity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;

public class FloatingEntityAi extends EntityAIBase {
	
	private final FloatingLanternEntity theEntity;

	public FloatingEntityAi(FloatingLanternEntity par1Entity)
	{
	   theEntity = par1Entity;
	   //Mutex Bit to prevent ai conflicts
	   setMutexBits(1);

	}

	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		if (theEntity.worldObj.getBlock((int)theEntity.posX, (int)theEntity.posY + 1, (int)theEntity.posZ).getMaterial() == Material.air)
			return true;
		return false;
	}
	
	@Override
	public void startExecuting()
	{
	   // DEBUG
	   System.out.println("CustomAI startExecute()");
	}
	
	@Override
	public boolean continueExecuting()
	{
		return false;
	}
}

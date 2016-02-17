package com.lanterns;

import java.util.Random;

import com.lanterns.entities.SpiderLanternEntity;
import com.lanterns.proxy.CommonProxy;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = LanternsMod.MODID, version = LanternsMod.VERSION)
public class LanternsMod {

    public static final String MODID = "lanternsmod";
    public static final String VERSION = "1.0";
    
	@Instance(MODID)
	public static LanternsMod instance;
	
	@SidedProxy(clientSide="com.lanterns.proxy.ClientProxy", serverSide="com.lanterns.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		registerEntity(SpiderLanternEntity.class, "spiderLanternEntity");
		proxy.registerRenderers();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void registerEntity(Class entityClass, String name)
    {
	    int entityID = EntityRegistry.findGlobalUniqueEntityId();
	    long seed = name.hashCode();
	    Random rand = new Random(seed);
	    int primaryColor = rand.nextInt() * 16777215;
	    int secondaryColor = rand.nextInt() * 16777215;

	    EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
	    EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
	    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}


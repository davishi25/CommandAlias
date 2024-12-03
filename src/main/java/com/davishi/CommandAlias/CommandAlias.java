package com.davishi.CommandAlias;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = CommandAlias.MODID, version = CommandAlias.VERSION, name = CommandAlias.MODNAME, clientSideOnly = true)
public class CommandAlias
{

    public static final String MODNAME = "Copy-Chat";
    public static final String MODID = "commandalias";
    public static final String VERSION = "0.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);}

}

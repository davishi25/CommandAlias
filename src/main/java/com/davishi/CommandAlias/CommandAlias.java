package com.davishi.CommandAlias;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CommandAlias.MODID, version = CommandAlias.VERSION, name = CommandAlias.MODNAME, clientSideOnly = true)
public class CommandAlias
{

    public static final String MODNAME = "Copy-Chat";
    public static final String MODID = "commandalias";
    public static final String VERSION = "0.0";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new TextMenu());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);}

}

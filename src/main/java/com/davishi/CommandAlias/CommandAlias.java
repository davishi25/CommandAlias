package com.davishi.CommandAlias;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@Mod(modid = CommandAlias.MODID, version = CommandAlias.VERSION, name = CommandAlias.MODNAME, clientSideOnly = true)
public class CommandAlias
{

    public static final String MODNAME = "Copy-Chat";
    public static final String MODID = "commandalias";
    public static final String VERSION = "0.0";
    protected static Map<String, String> aliases = new HashMap<String, String>();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new TextMenu());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        try {
            registerAliases();
        } catch(Exception e){}
    }

    @SubscribeEvent
    public void interceptChat(ClientChatReceivedEvent e){
        try {
            Minecraft.getMinecraft().thePlayer.sendChatMessage(aliases.get(e.message));
        } catch(Exception er){}
    }

    public static void registerAliases() throws IOException{

        BufferedReader sourceReader = new BufferedReader(new FileReader(new File("aliases.txt")));
        String sourceLine = null;
        while ((sourceLine = sourceReader.readLine()) != null) {
            String[] line = sourceLine.split("/");

            aliases.put("/" + line[0], "/" + line[1]);
        }
        sourceReader.close();

    }
}

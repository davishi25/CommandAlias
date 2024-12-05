package com.davishi.CommandAlias;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;

import java.util.Map;

public class TextMenu extends CommandBase {
    @Override
    public String getCommandName(){return "ca";}

    @Override
    public String getCommandUsage(ICommandSender sender){return "";}

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {

        if(args.length == 1 && args[0].equals("list")){
            addMessage(EnumChatFormatting.DARK_AQUA + "---------------");
            addMessage(EnumChatFormatting.AQUA + "Command Aliases");
            addMessage(EnumChatFormatting.DARK_AQUA + "---------------");
            System.out.println(CommandAlias.aliases.entrySet());
            for(Map.Entry<String,String> entry : CommandAlias.aliases.entrySet()){
                addMessage(entry.getKey() + " -> " + entry.getValue());
            }
            //print out the array
        } else if (args.length == 3 && args[0].equals("register")){
            //register the command into text file
            if(args[1].charAt(0) != '/' && args[1].length() > 1){
                addMessage(EnumChatFormatting.RED + "Error: alias must start with /");
            } else {
                addMessage(EnumChatFormatting.GREEN + "Successfully registered " + args[1]);

            }
        } else{
            addMessage(EnumChatFormatting.RED + "Wrong Usage");
            addMessage(EnumChatFormatting.RED + "/ca register <alias> <command>");
            addMessage(EnumChatFormatting.RED + "/ca list");
        }
    }
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return true; }

    private void addMessage(String s){Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(s));}
}

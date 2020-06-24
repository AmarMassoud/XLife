package me.amar.xlife.xlife.commands;

import org.bukkit.command.CommandSender;

import java.io.IOException;

public abstract class SubCommand {


    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void perform(CommandSender sender, String args[]);

}
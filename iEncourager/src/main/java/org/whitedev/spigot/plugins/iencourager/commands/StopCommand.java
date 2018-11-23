package org.whitedev.spigot.plugins.iencourager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.whitedev.spigot.plugins.iencourager.model.RunToSpawn;

public class StopCommand implements CommandExecutor {

    private JavaPlugin plugin;

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private StopCommand() {
    }

    private static class StopCommandHolder {

	private static final StopCommand INSTANCE = new StopCommand();
    }

    public static StopCommand getInstance() {
	return StopCommandHolder.INSTANCE;
    }
    //</editor-fold>

    public void startExecutorPlugin(JavaPlugin plugin) {
	this.plugin = plugin;
	plugin.getCommand("stopIE").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmnd, String label, String[] args) {
	try {
	    RunToSpawn.getSingleton().stop(sender);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

}

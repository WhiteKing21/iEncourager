package org.white_sdev.spigot_plugins.iencourager;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import org.white_sdev.spigot_plugins.iencourager.commands.LaunchTestCommand;
import org.white_sdev.spigot_plugins.iencourager.commands.StartCommand;
import org.white_sdev.spigot_plugins.iencourager.commands.StopCommand;
import org.white_sdev.spigot_plugins.iencourager.model.ExhaustionModifier;
import org.white_sdev.spigot_plugins.iencourager.model.RunToSpawn;

public class IEncouragerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
	try {
	    super.onEnable();
	    IEncouragerConfigFile.getInstance(this).loadOrCreateConfigFile(this);
	    StartCommand.getInstance(this).startExecutorPlugin(this);
	    StopCommand.getInstance(this).startExecutorPlugin(this);
	    this.getCommand("launchTestIE").setExecutor(LaunchTestCommand.getInstance(this));
	    //getServer().getPluginManager().registerEvents(new VelocityChangesListener(), this);
	    RunToSpawn.getInstance(this).start(getServer().getConsoleSender());
	    ExhaustionModifier.getInstance(this).start(getServer().getConsoleSender());
	} catch (Exception e) {
	    this.getLogger().log(Level.SEVERE, e.toString());
	}
    }

}

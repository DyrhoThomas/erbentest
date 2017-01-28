package nl.DyrhoDevelopment.DyrhoNation;

import org.bukkit.plugin.java.JavaPlugin;

import nl.DyrhoDevelopment.DyrhoNation.Events.EventsClass;
import nl.DyrhoDevelopment.DyrhoNation.Events.ExplodeEvent;
import nl.DyrhoDevelopment.DyrhoNation.Events.PlayerQuitMessage;
import nl.DyrhoDevelopment.DyrhoNation.Items.CustomItems;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		getServer().getConsoleSender().sendMessage("\n\n§3[§bDyrho§3] §bDyrhoNation staat aan!\n\n");
		getServer().getPluginManager().registerEvents(new EventsClass(), this);
		getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitMessage(), this);
		loadConfig();
		
		CustomItems items= new CustomItems();
		items.customRecipe();
		items.unShaped();
	}
	
	public void onDisable(){
		getServer().getConsoleSender().sendMessage("\n\n§3[§bDyrho§3] §bDyrhoNation staat uit!\n\n");
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}

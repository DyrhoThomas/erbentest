package nl.DyrhoDevelopment.DyrhoNation.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitMessage implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		String prefix = ("§3[§b§lDYRHO§3] §r");
		
		Player p = e.getPlayer();
		
		e.setQuitMessage(prefix + "§bTot ziens " + p.getName() + "!");
	}

}

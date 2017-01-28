package nl.DyrhoDevelopment.DyrhoNation.Events;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class EventsClass implements Listener {
	public String prefix = ("§3[§b§lDYRHO§3] §r");

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ItemStack item1 = new ItemStack(Material.BOOK, 1);
		ItemMeta meta = item1.getItemMeta();

		Player p = e.getPlayer();
		if (!(p.hasPlayedBefore())) {
			e.setJoinMessage(prefix + "§aWelkom " + p.getName() + " op de server!");
			meta.setDisplayName("§bWelkom boek!");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("§fLees dit voor instructies & regels!");
			meta.setLore(lore);
			item1.setItemMeta(meta);

			p.getInventory().setItem(0, item1);
		} else {
			e.setJoinMessage(prefix + "§bWelkom terug " + p.getName() + "!");
		}

		Location spawn = new Location(p.getWorld(), -239.546, 67, 275.384);
		p.teleport(spawn);

		// ==================
		if (!(p.hasPlayedBefore())) {
			Firework fw = p.getWorld().spawn(p.getLocation(), Firework.class);
			FireworkMeta fwm = fw.getFireworkMeta();
			Builder builder = FireworkEffect.builder();

			fwm.addEffect(builder.withColor(Color.BLUE).build());
			fwm.addEffect(builder.trail(true).build());
			fwm.addEffect(builder.withFade(Color.ORANGE).build());
			fwm.addEffect(builder.with(Type.BALL_LARGE).build());
			fwm.setPower(2);
			fw.setFireworkMeta(fwm);

		}

	}
}

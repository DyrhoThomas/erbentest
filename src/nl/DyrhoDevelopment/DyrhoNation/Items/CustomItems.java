package nl.DyrhoDevelopment.DyrhoNation.Items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import nl.DyrhoDevelopment.DyrhoNation.Main;

public class CustomItems implements Listener {
	private Plugin plugin = Main.getPlugin(Main.class);

	public void customRecipe() {
		ItemStack item = new ItemStack(Material.BARRIER, 1);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName("§bBloemenban");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§fGemaakt met de hulp van DyrhoNation");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		ShapedRecipe r = new ShapedRecipe(item);

		r.shape("$#$", "$#$", " $ ");
		r.setIngredient('#', Material.BLAZE_POWDER);
		r.setIngredient('$', Material.BLAZE_ROD);

		plugin.getServer().addRecipe(r);

	}

	public void unShaped(){
		ItemStack item = new ItemStack(Material.BLAZE_POWDER,1 ) ;
			
		ShapelessRecipe slr = new ShapelessRecipe(item);
		
		slr.addIngredient(3,Material.LAVA_BUCKET);
		slr.addIngredient(3,Material.FLINT);
		plugin.getServer().addRecipe(slr);
	}
}

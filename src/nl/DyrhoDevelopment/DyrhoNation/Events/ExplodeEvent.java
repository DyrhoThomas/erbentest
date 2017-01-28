package nl.DyrhoDevelopment.DyrhoNation.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class ExplodeEvent implements Listener {
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		for(Block b : e.blockList()) {
			int Max = 1;
			int Min = -1;
			double x = Math.random() * (Max - Min) + Min;
			double y = Math.random() * (Max - Min) + Min;
			double z = Math.random() * (Max - Min) + Min;
			
			FallingBlock block = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
			block.setVelocity(new Vector(x, y, z));
			b.setType(Material.AIR);
		}
	}

}

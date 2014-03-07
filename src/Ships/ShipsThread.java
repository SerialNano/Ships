package Ships;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class ShipsThread
  extends BukkitRunnable
{
  private final JavaPlugin plugin;
  private final int PrzesuniecieX;
  private int PrzesuniecieZ;
  private World swiat;
  private Block blok;
  private Location lokacja;
  private Player player;
  private String name;
  
  public ShipsThread(JavaPlugin plugin, int PrzesuniecieX, int PrzesuniecieZ, World swiat, Block blok, Player player)
  {
    this.plugin = plugin;
    this.PrzesuniecieX = PrzesuniecieX;
    this.PrzesuniecieZ = PrzesuniecieZ;
    this.swiat = swiat;
    this.blok = blok;
    this.lokacja = this.blok.getLocation();
    this.player = player;
    this.name = this.player.getName().toString();
  }
  
  public void run()
  {
    Block blok2 = this.swiat.getBlockAt(this.lokacja);
    
    ShipsMaping Statek = new ShipsMaping(blok2);
    if (ShipsRequirements.EOTisStop(Statek.SignList)) {
      EndThread(this.name);
    }
    if (ShipsIF.ifCanMove(this.player, Statek))
    {
      if (ShipsCollisions.wykrywanieKolizji(Statek, this.PrzesuniecieX, 0, this.PrzesuniecieZ, this.swiat))
      {
        ShipsMove.move(Statek, this.PrzesuniecieX, 0, this.PrzesuniecieZ, this.swiat);
        ShipsMove.moveMobs(Statek, this.PrzesuniecieX, 0, this.PrzesuniecieZ, this.swiat);
        ShipsMove.movePlayer(Statek, this.PrzesuniecieX, 0, this.PrzesuniecieZ, this.swiat);
        this.lokacja = new Location(this.swiat, this.lokacja.getX() + this.PrzesuniecieX, this.lokacja.getY(), this.lokacja.getZ() + this.PrzesuniecieZ);
      }
      else
      {
        EndThread(this.name);
        this.player.sendMessage(ChatColor.RED + "[Ships] Obstacle on the course.");
      }
    }
    else {
      EndThread(this.name);
    }
  }
  
  static boolean EndThread(String name)
  {
    if (ShipsListener.IdWatku.containsKey(name))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)ShipsListener.IdWatku.get(name)).intValue());
      return true;
    }
    return false;
  }
}

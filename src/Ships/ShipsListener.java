package Ships;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class ShipsListener
  implements Listener
{
  @EventHandler
  public void onSignProtect(BlockBreakEvent event)
  {
    if (event.getBlock().getType().equals(Material.WALL_SIGN))
    {
        if(ShipsMain.VesselDebug == true){
        	ShipsMain.log.info("player right clicked sign");
        }
      Sign znak = (Sign)event.getBlock().getState();
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && 
        (!znak.getLine(2).equals(ChatColor.GREEN + event.getPlayer().getName())) && (!event.getPlayer().isOp()))
      {
        event.setCancelled(true);
        znak.update();
      }
    }
  }
  
  @EventHandler
  public void RightClickOnSign(PlayerInteractEvent event)
  {
    if ((event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString())) && 
      (!event.hasItem()) && (
      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || 
      (event.getClickedBlock().getType().equals(Material.WALL_SIGN))))
    {
      Block blok = event.getClickedBlock();
      Sign sign = (Sign)event.getClickedBlock().getState();
      Player player = event.getPlayer();
      World swiat = player.getWorld();
      String name = player.getName();
      if (sign.getLine(0).equals(ChatColor.YELLOW + "[Ships wheel]"))
      {
        ShipsMaping Statek = new ShipsMaping(blok);
        if (Statek.typ == null) {
          return;
        }
        if (!ShipsPermissions.isUse(player, Statek.typ))
        {
            if(ShipsMain.VesselDebug == true) {
            	ShipsMain.log.info("player does not have permission to drive - action = right on ships wheel");
            }
          event.setCancelled(true);
          return;
        }
        if (ShipsIF.ifCanMove(player, Statek)) {
          if (ShipsCollisions.SearchCollisionsTurn(Statek, "right", swiat, blok))
          {
            ShipsThread.EndThread(name);
            ShipsTurn.Right(swiat, blok, Statek);
            ShipsTurn.MobRight(swiat, blok, Statek);
          }
          else
          {
            player.sendMessage(ChatColor.RED + "Obstacle on turn right course.");
          }
        }
      }
    }
    if ((event.getAction().name().equals(Action.LEFT_CLICK_BLOCK.toString())) && 
      (!event.hasItem()) && (
      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || 
      (event.getClickedBlock().getType().equals(Material.WALL_SIGN))))
    {
      Block blok = event.getClickedBlock();
      Sign sign = (Sign)event.getClickedBlock().getState();
      Player player = event.getPlayer();
      World swiat = player.getWorld();
      String name = player.getName();
      if (sign.getLine(0).equals(ChatColor.YELLOW + "[Ships wheel]"))
      {
        ShipsMaping Statek = new ShipsMaping(blok);
        if (Statek.typ == null) {
          return;
        }
        if (!ShipsPermissions.isUse(player, Statek.typ))
        {
            if(ShipsMain.VesselDebug == true) {
            	ShipsMain.log.info("player does not have permission to drive - action = left on ship wheel");
            }
          event.setCancelled(true);
          return;
        }
        if (ShipsIF.ifCanMove(player, Statek)) {
          if (ShipsCollisions.SearchCollisionsTurn(Statek, "left", swiat, blok))
          {
            ShipsThread.EndThread(name);
            ShipsTurn.Left(swiat, blok, Statek);
            ShipsTurn.MobLeft(swiat, blok, Statek);
          }
          else
          {
            player.sendMessage(ChatColor.RED + "[Ships] Obstacle on turn right course.");
          }
        }
      }
    }
  }
  
  static HashMap<String, Integer> IdWatku = new HashMap();
  static JavaPlugin plugin;
  
  @EventHandler
  public void EOTedit(PlayerInteractEvent event)
  {
    if ((event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString())) && (
      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || (event.getClickedBlock().getType().equals(Material.WALL_SIGN))))
    {
      Block blok = event.getClickedBlock();
      Player player = event.getPlayer();
      String name = player.getName();
      Sign sign = (Sign)event.getClickedBlock().getState();
      World swiat = player.getWorld();
      if (sign.getLine(0).equals(ChatColor.YELLOW + "[E.O.T]"))
      {
        ShipsMaping Statek = new ShipsMaping(blok);
        if (Statek.typ == null) {
          return;
        }
        if (!ShipsPermissions.isUse(player, Statek.typ))
        {
            if(ShipsMain.VesselDebug == true) {
            	ShipsMain.log.info("player does not have permission to drive - action = change EOT settings");
            }
          event.setCancelled(true);
          return;
        }
        if (sign.getLine(2).equals("-[" + ChatColor.WHITE + "STOP" + ChatColor.BLACK + "]-"))
        {
          sign.setLine(2, ChatColor.WHITE + "STOP");
          sign.setLine(1, "-[" + ChatColor.GREEN + "AHEAD" + ChatColor.BLACK + "]-");
          sign.update();
          

          ShipsThread.EndThread(name);
          


          int predkosc = 0;
          if (Statek.typ.equals("airship")) {
            predkosc = ShipsMain.AirShipSpeed;
          } else if (Statek.typ.equals("ship")) {
            predkosc = ShipsMain.ShipSpeed;
          } else if (Statek.typ.equals("marsship")) {
            predkosc = ShipsMain.MarsShipSpeed;
          } else if (Statek.typ.equals("airship2")) {
            predkosc = ShipsMain.AirShip2Speed;
          } else if (Statek.typ.equals("plane")) {
            predkosc = ShipsMain.PlaneSpeed;
          }
          int przesuniecieX = 0;
          int przesuniecieZ = 0;
          if (blok.getData() == 0) {
            przesuniecieZ = predkosc * -1;
          } else if (blok.getData() == 8) {
            przesuniecieZ = predkosc;
          } else if (blok.getData() == 4) {
            przesuniecieX = predkosc;
          } else if (blok.getData() == 12) {
            przesuniecieX = predkosc * -1;
          } else if (blok.getData() == 2) {
            przesuniecieZ = predkosc;
          } else if (blok.getData() == 3) {
            przesuniecieZ = predkosc * -1;
          } else if (blok.getData() == 4) {
            przesuniecieX = predkosc;
          } else if (blok.getData() == 5) {
            przesuniecieX = predkosc * -1;
          }
          int PrzesuniecieX = przesuniecieX;
          int PrzesuniecieZ = przesuniecieZ;
          
          Plugin plugin2 = Bukkit.getPluginManager().getPlugin("Ships");
          BukkitTask task = new ShipsThread(plugin, PrzesuniecieX, PrzesuniecieZ, swiat, blok, player).runTaskTimer(plugin2, 0L, 100L);
          int id = task.getTaskId();
          IdWatku.put(player.getName(), Integer.valueOf(id));
        }
        else
        {
          sign.setLine(1, ChatColor.GREEN + "AHEAD");
          sign.setLine(2, "-[" + ChatColor.WHITE + "STOP" + ChatColor.BLACK + "]-");
          sign.update();
          ShipsThread.EndThread(name);
        }
      }
    }
  }
  
  @EventHandler
  public boolean setSign(SignChangeEvent event)
  {
    String name = event.getPlayer().getName().toString();
    Player player = event.getPlayer();
    if (event.getLine(0).equals("[EOT]"))
    {
      event.setLine(0, ChatColor.YELLOW + "[E.O.T]");
      event.setLine(1, ChatColor.GREEN + "AHEAD");
      event.setLine(2, "-[" + ChatColor.WHITE + "STOP" + ChatColor.BLACK + "]-");
      return true;
    }
    if (event.getLine(0).equals("[wheel]"))
    {
      event.setLine(0, ChatColor.YELLOW + "[Ships wheel]");
      event.setLine(1, ChatColor.DARK_RED + "\\ || /");
      event.setLine(2, ChatColor.DARK_RED + "==  ==");
      event.setLine(3, ChatColor.DARK_RED + "/ || \\");
      return true;
    }
    if (event.getLine(0).equals("[engine]"))
    {
      event.setLine(0, ChatColor.YELLOW + "[Maneuvering ");
      event.setLine(1, ChatColor.YELLOW + "engine]");
      return true;
    }
    if (event.getLine(0).equals("[altitude]"))
    {
      event.setLine(0, ChatColor.YELLOW + "[Altitude]");
      event.setLine(2, "[right] up");
      event.setLine(3, "[left] down");
      return true;
    }
    if (ShipsMain.AllowBoost){
      if (event.getLine(0).equals("[boost]")) {
        event.setLine(0, ChatColor.YELLOW + "[Boost]");
        return true;
      }
    }
  if (event.getLine(0).equals("[ships]")){
      if (((event.getLine(1).equals("airship")) && (player.hasPermission("ships.airship.make"))) || 
        ((event.getLine(1).equals("ship")) && (player.hasPermission("ships.ship.make"))) || (
        (event.getLine(1).equals("marsship")) && (player.hasPermission("ships.marsship.make"))) || (
        (event.getLine(1).equals("airship2")) && (player.hasPermission("ships.airship2.make"))) || (
        (event.getLine(1).equals("plane")) && (player.hasPermission("ships.plane.make")))) {
        event.setLine(0, ChatColor.YELLOW + "[Ships]");
        event.setLine(1, ChatColor.BLUE + event.getLine(1));
        if (event.getLine(2).equals("")) {
          event.setLine(2, ChatColor.GREEN + name);
        } else {
          event.setLine(2, ChatColor.GREEN + event.getLine(2));
        }
        event.setLine(3, ChatColor.GREEN + event.getLine(3));
        return true;
      }
      player.sendMessage("permission miss match to make this vessel");
    }
    return false;
  }
  
  @EventHandler
  public void engineManeuvering(PlayerInteractEvent event)
  {
    if ((event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString())) && (
      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || (event.getClickedBlock().getType().equals(Material.WALL_SIGN))))
    {
      Block blok = event.getClickedBlock();
      Sign sign = (Sign)blok.getState();
      Player player = event.getPlayer();
      String name = player.getName();
      World swiat = player.getWorld();
      if ((sign.getLine(0).equals(ChatColor.YELLOW + "[Maneuvering ")) && (sign.getLine(1).equals(ChatColor.YELLOW + "engine]")))
      {
       ShipsMaping Statek = new ShipsMaping(blok);
       if (Statek.typ == null) {
          return;
       }
          int predkosc = 0;
          if (Statek.typ.equals("airship")) {
            predkosc = ShipsMain.AirShipEngineSpeed;
          } else if (Statek.typ.equals("ship")) {
            predkosc = ShipsMain.ShipEngineSpeed;
          } else if (Statek.typ.equals("marsship")) {
            predkosc = ShipsMain.MarsShipEngineSpeed;
          } else if (Statek.typ.equals("airship2")) {
            predkosc = ShipsMain.Airship2EngineSpeed;
          } else if (Statek.typ.equals("plane")) {
            predkosc = ShipsMain.PlaneEngineSpeed;
          }
    	  
    	  
          int przesuniecieX = 0;
          int przesuniecieZ = 0;
          if (blok.getData() == 0) {
            przesuniecieZ = predkosc * -1;
          } else if (blok.getData() == 8) {
            przesuniecieZ = predkosc;
          } else if (blok.getData() == 4) {
            przesuniecieX = predkosc;
          } else if (blok.getData() == 12) {
            przesuniecieX = predkosc * -1;
          } else if (blok.getData() == 2) {
            przesuniecieZ = predkosc;
          } else if (blok.getData() == 3) {
            przesuniecieZ = predkosc * -1;
          } else if (blok.getData() == 4) {
            przesuniecieX = predkosc;
          } else if (blok.getData() == 5) {
            przesuniecieX = predkosc * -1;
          }
          int PrzesuniecieX = przesuniecieX;
          int PrzesuniecieZ = przesuniecieZ;
        if (!ShipsPermissions.isUse(player, Statek.typ))
        {
          event.setCancelled(true);
          return;
        }
        if (ShipsIF.ifCanMove(player, Statek)) {
          if (ShipsCollisions.wykrywanieKolizji(Statek, przesuniecieX, 0, przesuniecieZ, swiat))
          {
            ShipsThread.EndThread(name);
            ShipsMove.move(Statek, przesuniecieX, 0, przesuniecieZ, swiat);
            ShipsMove.moveMobs(Statek, przesuniecieX, 0, przesuniecieZ, swiat);
          }
          else
          {
            player.sendMessage(ChatColor.RED + "[Ships] Obstacle on the engine course.");
          }
        }
      }
    }
  }
  
  @EventHandler
  public void BoostEngineManeuvering(PlayerInteractEvent event){
	  if (ShipsMain.AllowBoost){
		    if (((event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString())) || (event.getAction().name().equals(Action.LEFT_CLICK_BLOCK.toString()))) && (
		    	      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || (event.getClickedBlock().getType().equals(Material.WALL_SIGN)))) {
              if (ShipsMain.BlockDebug){
            	  ShipsMain.log.info("Boost sign");
              }
        	  Block blok = event.getClickedBlock();
              Sign sign = (Sign)blok.getState();
              Player player = event.getPlayer();
              String name = player.getName();
              World swiat = player.getWorld();
              ShipsMaping Statek = new ShipsMaping(blok);
              if (sign.getLine(0).equals(ChatColor.YELLOW + "[Boost]")) {
                  if (Statek.typ == null) {
                	  if (ShipsMain.BlockDebug){
                		  ShipsMain.log.info("Boost sign used");
                	  }
                      return;
                  }
                  int predkosc = 0;
                  if (Statek.typ.equals("airship")) {
                      predkosc = ShipsMain.AirShipBoostSpeed;
                  } else if (Statek.typ.equals("ship")) {
                      predkosc = ShipsMain.ShipBoostSpeed;
                  } else if (Statek.typ.equals("marsship")) {
                      predkosc = ShipsMain.MarsShipBoostSpeed;
                  } else if (Statek.typ.equals("airship2")) {
                      predkosc = ShipsMain.AirShip2BoostSpeed;
                  } else if (Statek.typ.equals("plane")) {
                      predkosc = ShipsMain.PlaneBoostSpeed;
                  }
                  int przesuniecieX = 0;
                  int przesuniecieZ = 0;
                  if (blok.getData() == 0) {
                      przesuniecieZ = predkosc * -1;
                  } else if (blok.getData() == 8) {
                      przesuniecieZ = predkosc;
                  } else if (blok.getData() == 4) {
                      przesuniecieX = predkosc;
                  } else if (blok.getData() == 12) {
                      przesuniecieX = predkosc * -1;
                  } else if (blok.getData() == 2) {
                      przesuniecieZ = predkosc;
                  } else if (blok.getData() == 3) {
                      przesuniecieZ = predkosc * -1;
                  } else if (blok.getData() == 4) {
                      przesuniecieX = predkosc;
                  } else if (blok.getData() == 5) {
                      przesuniecieX = predkosc * -1;
                  }
                  int PrzesuniecieX = przesuniecieX;
                  int PrzesuniecieZ = przesuniecieZ;
                  if (!ShipsPermissions.isUse(player, Statek.typ)){
                      event.setCancelled(true);
                      return;
                  }
                  if (ShipsIF.ifCanMove(player, Statek)) {
                	  if (ShipsMain.BlockDebug){
                		  ShipsMain.log.info("IfCanMove true");
                	  }
                      if (ShipsCollisions.wykrywanieKolizji(Statek, przesuniecieX, 0, przesuniecieZ, swiat)){
                          ShipsThread.EndThread(name);
                          ShipsMove.move(Statek, przesuniecieX, 0, przesuniecieZ, swiat);
                          ShipsMove.moveMobs(Statek, przesuniecieX, 0, przesuniecieZ, swiat);
                      }else{
                          player.sendMessage(ChatColor.RED + "[Ships] Obstacle on the boost course.");
                      }
                  }
              }
          }
      }
  }  
  @EventHandler
  public void Burner(PlayerInteractEvent event)
  {
    if (((event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString())) || (event.getAction().name().equals(Action.LEFT_CLICK_BLOCK.toString()))) && (
      (event.getClickedBlock().getType().equals(Material.SIGN_POST)) || (event.getClickedBlock().getType().equals(Material.WALL_SIGN))))
    {
      Block blok = event.getClickedBlock();
      Sign sign = (Sign)blok.getState();
      Player player = event.getPlayer();
      World swiat = player.getWorld();
      String name = player.getName();
      if ((sign.getLine(0).equals(ChatColor.YELLOW + "[Altitude]")) || (sign.getLine(0).equals(ChatColor.YELLOW + "[Elevator]")))
      {
        int przesuniecieY = 0;
        if (event.getAction().name().equals(Action.RIGHT_CLICK_BLOCK.toString()))
        {
          przesuniecieY = 2;
          
          ShipsMaping Statek = new ShipsMaping(blok);
          if ((Statek.typ == null) || (Statek.typ.equals("ship"))) {
            return;
          }
          if (!ShipsPermissions.isUse(player, Statek.typ))
          {
            event.setCancelled(true);
            return;
          }
          if (ShipsIF.ifCanMove(player, Statek)) {
            if (ShipsCollisions.wykrywanieKolizji(Statek, 0, przesuniecieY, 0, swiat))
            {
              ShipsThread.EndThread(name);
              ShipsMove.move(Statek, 0, przesuniecieY, 0, swiat);
              ShipsMove.moveMobs(Statek, 0, przesuniecieY, 0, swiat);
            }
            else
            {
              player.sendMessage(ChatColor.RED + "[Ships] Obstacle on elevator course.");
            }
          }
        }
        if (event.getAction().name().equals(Action.LEFT_CLICK_BLOCK.toString()))
        {
          przesuniecieY = -2;
          
          ShipsMaping Statek = new ShipsMaping(blok);
          if ((Statek.typ == null) || (Statek.typ.equals("ship"))) {
            return;
          }
          if (!ShipsPermissions.isUse(player, Statek.typ))
          {
            event.setCancelled(true);
            return;
          }
          if (ShipsIF.ifCanMoveDown(player, Statek)) {
            if (ShipsCollisions.wykrywanieKolizji(Statek, 0, przesuniecieY, 0, swiat))
            {
              ShipsThread.EndThread(name);
              ShipsMove.move(Statek, 0, przesuniecieY, 0, swiat);
              ShipsMove.moveMobs(Statek, 0, przesuniecieY, 0, swiat);
            }
            else
            {
              player.sendMessage(ChatColor.RED + "[Ships] Obstacle on the course.");
            }
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onBlockIgnite(BlockBurnEvent event)
  {
    if (ShipsMain.ProtectFire) {
      for (int x = -1; x < 2; x++) {
        for (int y = -1; y < 2; y++) {
          for (int z = -1; z < 2; z++)
          {
            Block blok2 = event.getBlock().getRelative(x, y, z);
            int type = blok2.getTypeId();
            byte data = blok2.getData();
            if ((type == 136) || 
              (type == 85) || 
              ((type == 17) && ((data == 3) || (data == 7) || (data == 11) || (data == 15))) || 
              ((type == 5) && (data == 3)) || 
              ((type == 126) && ((data == 3) || (data == 11))) || (
              (type == 125) && (data == 3)))
            {
              for (int X = -1; X < 2; X++) {
                for (int Y = -1; Y < 2; Y++) {
                  for (int Z = -1; Z < 2; Z++)
                  {
                    blok2 = event.getBlock().getRelative(X, Y, Z);
                    type = blok2.getTypeId();
                    if (type == 51) {
                      blok2.setTypeId(0);
                    }
                  }
                }
              }
              event.setCancelled(true);
            }
          }
        }
      }
    }
  }
}


package Ships;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Furnace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;

public class ShipsMove
  extends ShipsMain
{
  static boolean move(ShipsMaping Statek, int x, int y, int z, World swiat)
  {
    ShipsDestruct.Destruct(Statek, swiat);
    

    Iterator<Map.Entry<String, ShipsMaping.mapa>> countryIterator = Statek.blokmap.entrySet().iterator();
    while (countryIterator.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)countryIterator.next();
      if (!((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        double X2 = ((ShipsMaping.mapa)entry.getValue()).x + x;
        if(EntityDebug) {
        	ShipsMain.log.info("X2 = " + X2 + " x = " + x);
        }
        double Y2 = ((ShipsMaping.mapa)entry.getValue()).y + y;
        if(EntityDebug) {
        	ShipsMain.log.info("Y2 = " + Y2 + " y = " + y);
        }
        double Z2 = ((ShipsMaping.mapa)entry.getValue()).z + z;
        if(EntityDebug) {
        	ShipsMain.log.info("Z2 = " + Z2 + " z = " + z);
        }
        

        int id = ((ShipsMaping.mapa)entry.getValue()).id;
        if(BlockDebug) {
        	ShipsMain.log.info("id value = " + id);
        }
        byte data = ((ShipsMaping.mapa)entry.getValue()).data;
        if(BlockDebug) {
        	ShipsMain.log.info("data value = " + data);
        }
        


        Location lokacja2 = new Location(swiat, X2, Y2, Z2);
        if (id == 0)
        {
          swiat.getBlockAt(lokacja2).setType(Material.AIR);
        }
        else
        {
          swiat.getBlockAt(lokacja2).setTypeId(id);
          swiat.getBlockAt(lokacja2).setData(data);
        }
      }
    }
    Iterator<Map.Entry<String, ShipsMaping.mapa>> countryIterator2 = Statek.blokmap.entrySet().iterator();
    while (countryIterator2.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)countryIterator2.next();
      if (((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        double X2 = ((ShipsMaping.mapa)entry.getValue()).x + x;
        double Y2 = ((ShipsMaping.mapa)entry.getValue()).y + y;
        double Z2 = ((ShipsMaping.mapa)entry.getValue()).z + z;
        

        int id = ((ShipsMaping.mapa)entry.getValue()).id;
        byte data = ((ShipsMaping.mapa)entry.getValue()).data;
        



        Location lokacja2 = new Location(swiat, X2, Y2, Z2);
        swiat.getBlockAt(lokacja2).setTypeId(id);
        swiat.getBlockAt(lokacja2).setData(data);
        if ((id == Material.SIGN_POST.getId()) || (id == Material.WALL_SIGN.getId()))
        {
          Sign znak2 = (Sign)swiat.getBlockAt(lokacja2).getState();
          znak2.setLine(0, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(0));
          znak2.setLine(1, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(1));
          znak2.setLine(2, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(2));
          znak2.setLine(3, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(3));
          znak2.update();
        }
        if ((id == Material.FURNACE.getId()) || (id == Material.BURNING_FURNACE.getId()))
        {
          Furnace piec = (Furnace)swiat.getBlockAt(lokacja2).getState();
          if (((ShipsMaping.mapa)entry.getValue()).furnace.smelting != null) {
            piec.getInventory().setSmelting(((ShipsMaping.mapa)entry.getValue()).furnace.smelting);
          }
          if (((ShipsMaping.mapa)entry.getValue()).furnace.fuel != null) {
            piec.getInventory().setFuel(((ShipsMaping.mapa)entry.getValue()).furnace.fuel);
          }
          if (((ShipsMaping.mapa)entry.getValue()).furnace.fuel2 != null) {
            piec.getInventory().setFuel(((ShipsMaping.mapa)entry.getValue()).furnace.fuel2);
          }
          if (((ShipsMaping.mapa)entry.getValue()).furnace.fuel3 != null) {
            piec.getInventory().setFuel(((ShipsMaping.mapa)entry.getValue()).furnace.fuel3);
          }
          if (((ShipsMaping.mapa)entry.getValue()).furnace.result != null) {
            piec.getInventory().setResult(((ShipsMaping.mapa)entry.getValue()).furnace.result);
          }
        }
        if (id == Material.CHEST.getId())
        {
          Chest chest = (Chest)swiat.getBlockAt(lokacja2).getState();
          if (chest.getInventory().getSize() == ((ShipsMaping.mapa)entry.getValue()).chest.items.length) {
            chest.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).chest.items);
          }
        }
        if ((id == Material.DISPENSER.getId()))
        {
          Dispenser disp = (Dispenser)swiat.getBlockAt(lokacja2).getState();
          if(ItemDebug){
        	  ShipsMain.log.info("setting inventory of dispenser");
          }
          if (((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems != null) {
            disp.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems);
          }
        }
        if ((id == Material.HOPPER.getId()))
        {
          Hopper hopr = (Hopper)swiat.getBlockAt(lokacja2).getState();
          if(ItemDebug){
        	  ShipsMain.log.info("setting inventory of hopper");
          }
          if (((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems != null) {
            hopr.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems);
          }
        }
      }
    }
    return true;
  }
  
  static void movePlayer(ShipsMaping Statek, int x, int y, int z, World swiat)
  {
    List<Player> gracze = swiat.getPlayers();
    for (int a = 0; gracze.size() > a; a++)
    {
      Player player = (Player)gracze.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      if(EntityDebug) {
      	ShipsMain.log.info("Player X = " + X);
      }
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      if(EntityDebug) {
       	ShipsMain.log.info("Player Y = " + Y);
      }
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if(EntityDebug) {
      	ShipsMain.log.info("Player Z = " + Z);
      }
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        Location nowaLokacja = player.getLocation();
        nowaLokacja.setX(nowaLokacja.getX() + x);
        if(EntityDebug) {
          ShipsMain.log.info("Player New x = " + x);
        }
        nowaLokacja.setY(nowaLokacja.getY() + y);
        if(EntityDebug) {
          ShipsMain.log.info("Player New y = " + y);
        }
        nowaLokacja.setZ(nowaLokacja.getZ() + z);
        if(EntityDebug) {
          ShipsMain.log.info("Player New Z = " + z);
        }
        player.teleport(nowaLokacja);
        if(EntityDebug) {
          ShipsMain.log.info("player teleported to new location");
        }
      }
    }
  }
  
  static void moveMobs(ShipsMaping Statek, int x, int y, int z, World swiat)
  {
    List<Entity> animals = swiat.getEntities();
    for (int a = 0; animals.size() > a; a++)
    {
      Entity player = (Entity)animals.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        Location nowaLokacja = player.getLocation();
        nowaLokacja.setX(nowaLokacja.getX() + x);
        nowaLokacja.setY(nowaLokacja.getY() + y);
        nowaLokacja.setZ(nowaLokacja.getZ() + z);
        player.teleport(nowaLokacja);
      }
    }
  }
}

package Ships;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Hopper;
import org.bukkit.block.Furnace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;

public class ShipsTurn
  extends ShipsMain
{
  static void Right(World swiat, Block Blok, ShipsMaping Statek)
  {
    ShipsDestruct.Destruct(Statek, swiat);
    

    Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator = Statek.blokmap.entrySet().iterator();
    
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    double symetriaZ = Blok.getLocation().getBlockZ();
    while (mapIterator.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator.next();
      
      double X = ((ShipsMaping.mapa)entry.getValue()).x - przesuniecie;
      if(EntityDebug) {
        ShipsMain.log.info("value of X = " + X);
      }
      double Z = ((ShipsMaping.mapa)entry.getValue()).z - (((ShipsMaping.mapa)entry.getValue()).z - symetriaZ) * 2.0D + przesuniecie;
      if(EntityDebug) {
        ShipsMain.log.info("value of Z = " + Z);
      }
      double Y = ((ShipsMaping.mapa)entry.getValue()).y;
      if(EntityDebug) {
        ShipsMain.log.info("value of Y = " + Y);
      }
      
      Location lokacja = new Location(swiat, Z, Y, X);
      
      Block blok = swiat.getBlockAt(lokacja);
      if (!((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        blok.setTypeId(((ShipsMaping.mapa)entry.getValue()).id);
        
        int id = ((ShipsMaping.mapa)entry.getValue()).id;
        if(BlockDebug) {
          ShipsMain.log.info("value of id = " + id);
        }
        byte data = ((ShipsMaping.mapa)entry.getValue()).data;
        if(BlockDebug) {
          ShipsMain.log.info("value of data = " + data);
        }
        
        data = ShipsFixBlock.blockFix(id, data, "right");
        
        blok.setData(data);
      }
    }
    Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator2 = Statek.blokmap.entrySet().iterator();
    
    przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    symetriaZ = Blok.getLocation().getBlockZ();
    while (mapIterator2.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator2.next();
      
      double X = ((ShipsMaping.mapa)entry.getValue()).x - przesuniecie;
      if(EntityDebug) {
        ShipsMain.log.info("new value of X = " + X);
      }
      double Z = ((ShipsMaping.mapa)entry.getValue()).z - (((ShipsMaping.mapa)entry.getValue()).z - symetriaZ) * 2.0D + przesuniecie;
      if(EntityDebug) {
        ShipsMain.log.info("new value of Z = " + Z);
      }
      double Y = ((ShipsMaping.mapa)entry.getValue()).y;
      if(EntityDebug) {
        ShipsMain.log.info("new value of Y = " + Y);
      }
      
      Location lokacja = new Location(swiat, Z, Y, X);
      
      Block blok = swiat.getBlockAt(lokacja);
      
      int id = ((ShipsMaping.mapa)entry.getValue()).id;
      if(BlockDebug) {
        ShipsMain.log.info("new value of id = " + id);
      }
      byte data = ((ShipsMaping.mapa)entry.getValue()).data;
      if(BlockDebug) {
        ShipsMain.log.info("new value of data = " + data);
      }
      if (((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        data = ShipsFixBlock.blockFix(id, data, "right");
        blok.setTypeIdAndData(id, data, true);
        blok.setData(data);
        if ((id == Material.SIGN_POST.getId()) || (id == Material.WALL_SIGN.getId()))
        {
          Sign znak2 = (Sign)swiat.getBlockAt(lokacja).getState();
          znak2.setLine(0, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(0));
          znak2.setLine(1, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(1));
          znak2.setLine(2, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(2));
          znak2.setLine(3, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(3));
          znak2.update();
        }
        if ((id == Material.FURNACE.getId()) || (id == Material.BURNING_FURNACE.getId()))
        {
          Furnace piec = (Furnace)swiat.getBlockAt(lokacja).getState();
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
          Chest chest = (Chest)swiat.getBlockAt(lokacja).getState();
          if (chest.getInventory().getSize() == ((ShipsMaping.mapa)entry.getValue()).chest.items.length) {
            chest.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).chest.items);
          }
        }
        if ((id == Material.DISPENSER.getId()))
        {
          Dispenser disp = (Dispenser)swiat.getBlockAt(lokacja).getState();
          if (((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems != null) {
        	  if(ItemDebug){
        		  ShipsMain.log.info("setting contents of dispenser");
        	  }
            disp.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems);
          }
        }
        if ((id == Material.HOPPER.getId()))
        {
          Hopper hopr = (Hopper)swiat.getBlockAt(lokacja).getState();
          if (((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems != null) {
            hopr.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems);
          }
        }
      }
    }
  }
  
  static void PlayerRight(World swiat, Block Blok, ShipsMaping Statek)
  {
    List<Player> gracze = swiat.getPlayers();
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    double symetriaZ = Blok.getLocation().getBlockZ();
    for (int a = 0; gracze.size() > a; a++)
    {
      Player player = (Player)gracze.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        double x = player.getLocation().getX() - przesuniecie;
        double z = player.getLocation().getZ() - (player.getLocation().getZ() - symetriaZ) * 2.0D + przesuniecie;
        double y = player.getLocation().getY();
        
        Location lokacja = new Location(swiat, z, y, x);
        
        player.teleport(lokacja);
      }
    }
  }
  
  static void MobRight(World swiat, Block Blok, ShipsMaping Statek)
  {
    List<Entity> gracze = swiat.getEntities();
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    double symetriaZ = Blok.getLocation().getBlockZ();
    for (int a = 0; gracze.size() > a; a++)
    {
      Entity player = (Entity)gracze.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        double x = player.getLocation().getX() - przesuniecie;
        double z = player.getLocation().getZ() - (player.getLocation().getZ() - symetriaZ) * 2.0D + przesuniecie;
        double y = player.getLocation().getY();
        
        Location lokacja = new Location(swiat, z, y, x);
        
        player.teleport(lokacja);
      }
    }
  }
  
  static void Left(World swiat, Block Blok, ShipsMaping Statek)
  {
    ShipsDestruct.Destruct(Statek, swiat);
    



    Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator = Statek.blokmap.entrySet().iterator();
    
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    
    double symetriaX = Blok.getLocation().getBlockX();
    while (mapIterator.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator.next();
      
      double X = ((ShipsMaping.mapa)entry.getValue()).x - (((ShipsMaping.mapa)entry.getValue()).x - symetriaX) * 2.0D - przesuniecie;
      double Z = ((ShipsMaping.mapa)entry.getValue()).z + przesuniecie;
      double Y = ((ShipsMaping.mapa)entry.getValue()).y;
      
      Location lokacja = new Location(swiat, Z, Y, X);
      
      Block blok = swiat.getBlockAt(lokacja);
      if (!((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        blok.setTypeId(((ShipsMaping.mapa)entry.getValue()).id);
        
        int id = ((ShipsMaping.mapa)entry.getValue()).id;
        byte data = ((ShipsMaping.mapa)entry.getValue()).data;
        
        data = ShipsFixBlock.blockFix(id, data, "left");
        blok.setData(data);
      }
    }
    Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator2 = Statek.blokmap.entrySet().iterator();
    
    przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    
    symetriaX = Blok.getLocation().getBlockX();
    while (mapIterator2.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator2.next();
      
      double X = ((ShipsMaping.mapa)entry.getValue()).x - (((ShipsMaping.mapa)entry.getValue()).x - symetriaX) * 2.0D - przesuniecie;
      double Z = ((ShipsMaping.mapa)entry.getValue()).z + przesuniecie;
      double Y = ((ShipsMaping.mapa)entry.getValue()).y;
      
      Location lokacja = new Location(swiat, Z, Y, X);
      
      Block blok = swiat.getBlockAt(lokacja);
      if (((ShipsMaping.mapa)entry.getValue()).specjal)
      {
        int id = ((ShipsMaping.mapa)entry.getValue()).id;
        byte data = ((ShipsMaping.mapa)entry.getValue()).data;
        

        data = ShipsFixBlock.blockFix(id, data, "left");
        blok.setTypeIdAndData(id, data, true);
        blok.setData(data);
        if ((id == Material.SIGN_POST.getId()) || (id == Material.WALL_SIGN.getId()))
        {
          Sign znak2 = (Sign)swiat.getBlockAt(lokacja).getState();
          znak2.setLine(0, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(0));
          znak2.setLine(1, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(1));
          znak2.setLine(2, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(2));
          znak2.setLine(3, ((ShipsMaping.mapa)entry.getValue()).sign.getLine(3));
          znak2.update();
        }
        if ((id == Material.FURNACE.getId()) || (id == Material.BURNING_FURNACE.getId()))
        {
          Furnace piec = (Furnace)swiat.getBlockAt(lokacja).getState();
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
          Chest chest = (Chest)swiat.getBlockAt(lokacja).getState();
          if (chest.getInventory().getSize() == ((ShipsMaping.mapa)entry.getValue()).chest.items.length) {
            chest.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).chest.items);
          }
        }
        if ((id == Material.DISPENSER.getId()))
        {
          Dispenser disp = (Dispenser)swiat.getBlockAt(lokacja).getState();
          if (((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems != null) {
            disp.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vdispenser.dispenseritems);
          }
        }
        if ((id == Material.HOPPER.getId()))
        {
          Hopper hopr = (Hopper)swiat.getBlockAt(lokacja).getState();
          if (((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems != null) {
            hopr.getInventory().setContents(((ShipsMaping.mapa)entry.getValue()).vhopper.hopperitems);
          }
        }
      }
    }
  }
  
  static void PlayerLeft(World swiat, Block Blok, ShipsMaping Statek)
  {
    List<Player> gracze = swiat.getPlayers();
    
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    double symetriaX = Blok.getLocation().getBlockX();
    for (int a = 0; gracze.size() > a; a++)
    {
      Player player = (Player)gracze.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        double x = player.getLocation().getX() - (player.getLocation().getX() - symetriaX) * 2.0D - przesuniecie;
        double z = player.getLocation().getZ() + przesuniecie;
        double y = player.getLocation().getY();
        
        Location lokacja = new Location(swiat, z, y, x);
        
        player.teleport(lokacja);
      }
    }
  }
  
  static void MobLeft(World swiat, Block Blok, ShipsMaping Statek)
  {
    List<Entity> gracze = swiat.getEntities();
    
    int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
    double symetriaX = Blok.getLocation().getBlockX();
    for (int a = 0; gracze.size() > a; a++)
    {
      Entity player = (Entity)gracze.get(a);
      int X = player.getLocation().getBlock().getRelative(0, 0, 0).getX();
      int Y = player.getLocation().getBlock().getRelative(0, -1, 0).getY();
      int Z = player.getLocation().getBlock().getRelative(0, 0, 0).getZ();
      if (Statek.blokmap.containsKey("X" + X + "Y" + Y + "Z" + Z))
      {
        double x = player.getLocation().getX() - (player.getLocation().getX() - symetriaX) * 2.0D - przesuniecie;
        double z = player.getLocation().getZ() + przesuniecie;
        double y = player.getLocation().getY();
        
        Location lokacja = new Location(swiat, z, y, x);
        
        player.teleport(lokacja);
      }
    }
  }
}

package Ships;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Hopper;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Chest;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;

public class ShipsDestruct
  extends ShipsMain
{
  static void Destruct(ShipsMaping Statek, World swiat)
  {
    if ((Statek.typ.equals("airship")) || (Statek.typ.equals("marsship")) || (Statek.typ.equals("airship2")) || Statek.typ.equals("plane"))
    {
      Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator = Statek.blokmap.entrySet().iterator();
      while (mapIterator.hasNext())
      {
        Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator.next();
        double X2 = ((ShipsMaping.mapa)entry.getValue()).x;
        if(EntityDebug ==  true) {
        	ShipsMain.log.info("value of X2 = " + X2);
        }
        double Y2 = ((ShipsMaping.mapa)entry.getValue()).y;
        if(EntityDebug ==  true) {
        	ShipsMain.log.info("value of Y2 = " + Y2);
        }
        double Z2 = ((ShipsMaping.mapa)entry.getValue()).z;
        if(EntityDebug ==  true) {
        	ShipsMain.log.info("value of Z2 = " + Z2);
        }
        
        Location lokacja = new Location(swiat, X2, Y2, Z2);
        if (((ShipsMaping.mapa)entry.getValue()).specjal)
        {
          if ((((ShipsMaping.mapa)entry.getValue()).id == Material.FURNACE.getId()) || (((ShipsMaping.mapa)entry.getValue()).id == Material.BURNING_FURNACE.getId()))
          {
            if(ItemDebug){
              ShipsMain.log.info("Checking if furnace is on vessel");
            }
            BlockState piec = swiat.getBlockAt(lokacja).getState();
            if ((piec instanceof Furnace))
            {
              if(ItemDebug){
            	  ShipsMain.log.info("clearing inventory of furnace");
              }
              Furnace myFurnace = (Furnace)piec;
              myFurnace.getInventory().clear();
            }
          }
          if (((ShipsMaping.mapa)entry.getValue()).id == Material.CHEST.getId())
          {
              if(ItemDebug){
              	ShipsMain.log.info("Checking if chest on vessel");
              }
            BlockState piec = swiat.getBlockAt(lokacja).getState();
            if ((piec instanceof Chest))
            {
              if(ItemDebug){
                  ShipsMain.log.info("clearing inventory of chest");
              }
              Chest myChest = (Chest)piec;
              myChest.getInventory().clear();
            }
          }
          if(ItemDebug){
        	  ShipsMain.log.info("this is where dispenser should clear inventory");
          }
          if(((ShipsMaping.mapa)entry.getValue()).id == Material.DISPENSER.getId())
          {
              if(ItemDebug){
              	ShipsMain.log.info("Found dispenser on vessel");
              }
            BlockState disp = swiat.getBlockAt(lokacja).getState();
            if ((disp instanceof Dispenser))
            {
              if(ItemDebug){
                ShipsMain.log.info("Disp = " + disp);
              }
              Dispenser myDispenser = (Dispenser)disp;
              myDispenser.getInventory().clear();
              if(ItemDebug){
            	  ShipsMain.log.info("cleared inventory of dispenser");
            	  ShipsMain.log.info("myDispenser = " + myDispenser);
              }
            }
          }
          if (((ShipsMaping.mapa)entry.getValue()).id == Material.HOPPER.getId())
          {
              if(ItemDebug){
              	ShipsMain.log.info("Checking if hopper on vessel");
              }
            BlockState hopr = swiat.getBlockAt(lokacja).getState();
            if ((hopr instanceof Hopper))
            {
              if(ItemDebug){
                ShipsMain.log.info("clearing inventory of hopper");
                ShipsMain.log.info("value of hopr = " + hopr);
              }
              Hopper myHopper = (Hopper)hopr;
              myHopper.getInventory().clear();
            }
          }
          swiat.getBlockAt(((ShipsMaping.mapa)entry.getValue()).lok).setType(Material.AIR);
        }
      }
      Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator2 = Statek.blokmap.entrySet().iterator();
      while (mapIterator2.hasNext())
      {
        Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator2.next();
        if (!((ShipsMaping.mapa)entry.getValue()).specjal) {
          swiat.getBlockAt(((ShipsMaping.mapa)entry.getValue()).lok).setType(Material.AIR);
        }
      }
    }
    if (Statek.typ.equals("ship"))
    {
      Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator = Statek.blokmap.entrySet().iterator();
      while (mapIterator.hasNext())
      {
        Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator.next();
        
        double X2 = ((ShipsMaping.mapa)entry.getValue()).x;
        double Y2 = ((ShipsMaping.mapa)entry.getValue()).y;
        double Z2 = ((ShipsMaping.mapa)entry.getValue()).z;
        
        Location lokacja = new Location(swiat, X2, Y2, Z2);
        
        World swiat2 = Bukkit.getServer().getWorld(swiat.getName());
        if (((ShipsMaping.mapa)entry.getValue()).specjal)
        {
          if ((((ShipsMaping.mapa)entry.getValue()).id == Material.FURNACE.getId()) || (((ShipsMaping.mapa)entry.getValue()).id == Material.BURNING_FURNACE.getId()))
          {
            BlockState piec = swiat.getBlockAt(lokacja).getState();
            if ((piec instanceof Furnace))
            {
              Furnace myFurnace = (Furnace)piec;
              myFurnace.getInventory().clear();
            }
          }
          if (((ShipsMaping.mapa)entry.getValue()).id == Material.CHEST.getId())
          {
            BlockState piec = swiat.getBlockAt(lokacja).getState();
            if ((piec instanceof Chest))
            {
              Chest myChest = (Chest)piec;
              myChest.getInventory().clear();
            }
          }
          if(ItemDebug){
        	  ShipsMain.log.info("this part should be where it clears dispenser inventory");
          }
          if (((ShipsMaping.mapa)entry.getValue()).id == Material.DISPENSER.getId())
          {
        	  if(ItemDebug = true){
        		  ShipsMain.log.info("Checking if DISPENSER is on board");
        	  }
            BlockState disp = swiat.getBlockAt(lokacja).getState();
            if ((disp instanceof Dispenser))
            {
            	if(ItemDebug) {
            		ShipsMain.log.info("clearing inventory of dispenser ..");
            	}
              Dispenser myDispenser = (Dispenser)disp;
              myDispenser.getInventory().clear();
            }
          }
          if (((ShipsMaping.mapa)entry.getValue()).id == Material.HOPPER.getId())
          {
            BlockState hopr = swiat.getBlockAt(lokacja).getState();
            if ((hopr instanceof Hopper))
            {
              Hopper myHopper = (Hopper)hopr;
              myHopper.getInventory().clear();
            }
          }
          if (((ShipsMaping.mapa)entry.getValue()).y < waterlevel) {
            swiat2.getBlockAt(lokacja).setType(Material.STATIONARY_WATER);
          } else {
            swiat2.getBlockAt(lokacja).setType(Material.AIR);
          }
        }
      }
      Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator2 = Statek.blokmap.entrySet().iterator();
      while (mapIterator2.hasNext())
      {
        Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator2.next();
        
        double X2 = ((ShipsMaping.mapa)entry.getValue()).x;
        double Y2 = ((ShipsMaping.mapa)entry.getValue()).y;
        double Z2 = ((ShipsMaping.mapa)entry.getValue()).z;
        
        Location lokacja = new Location(swiat, X2, Y2, Z2);
        if (!((ShipsMaping.mapa)entry.getValue()).specjal)
        {
          if (((ShipsMaping.mapa)entry.getValue()).y < waterlevel) {
            swiat.getBlockAt(lokacja).setType(Material.STATIONARY_WATER);
          }
          if(BlockDebug ==  true) {
          	ShipsMain.log.info("Value of Default water level = " + waterlevel);
          }
          if (((ShipsMaping.mapa)entry.getValue()).y >= waterlevel) {
            swiat.getBlockAt(lokacja).setType(Material.AIR);
          }
        }
      }
    }
  }
}

package Ships;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class ShipsCollisions
  extends ShipsMain{
  static boolean wykrywanieKolizji(ShipsMaping Statek, int x, int y, int z, World swiat)
  {
    int licznik = 0;
    int licznik_wody = 0;
    


    Iterator<Map.Entry<String, ShipsMaping.mapa>> countryIterator = Statek.blokmap.entrySet().iterator();
    while (countryIterator.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)countryIterator.next();
      
      int X2 = ((ShipsMaping.mapa)entry.getValue()).x + x;
      if(EntityDebug) {
      ShipsMain.log.info("value of X2 = " + X2 + " value of x = " + x);
      }
      int Y2 = ((ShipsMaping.mapa)entry.getValue()).y + y;
      if(EntityDebug) {
      ShipsMain.log.info("value of Y2 = " + Y2 + " value of y = " + y);
      }
      int Z2 = ((ShipsMaping.mapa)entry.getValue()).z + z;
      if(EntityDebug) {
      ShipsMain.log.info("value of Z2 = " + Z2 + " value of z = " + z);
      }
      
      Location lokacja = new Location(swiat, X2, Y2, Z2);
      Block blok = swiat.getBlockAt(lokacja);
      if ((Statek.typ.equals("airship")) || (Statek.typ.equals("marsship")) || (Statek.typ.equals("airship2")) || (Statek.typ.equals("plane"))) {
        if(BlockDebug) {
    	  ShipsMain.log.info("found block on air type vessel");
        }
    	if (!blok.getType().equals(Material.AIR)) {
          if (!Statek.blokmap.containsKey("X" + X2 + "Y" + Y2 + "Z" + Z2)) {
            licznik++;
          }
        }
      }
      if (Statek.typ.equals("ship")) {
    	  if(BlockDebug) {
    	     ShipsMain.log.info("found block on water type vessel");
    	  }
        if (!blok.getType().equals(Material.AIR)) {
          if ((!blok.getType().equals(Material.STATIONARY_WATER)) && 
            (!blok.getType().equals(Material.WATER)))
          {
            if (!Statek.blokmap.containsKey("X" + X2 + "Y" + Y2 + "Z" + Z2)) {
              licznik++;
            }
          }
          else {
            licznik_wody++;
          }
        }
      }
    }
    if ((licznik == 0) && (Statek.typ.equals("airship"))) {
    	if(BlockDebug) {
    	ShipsMain.log.info("setting airship to air values");
    	}
      return true;
    }
    if ((licznik == 0) && (Statek.typ.equals("airship2"))) {
    	if(BlockDebug) {
    	ShipsMain.log.info("setting airship2 to air values");
    	}
        return true;
      }
    if ((licznik == 0) && (Statek.typ.equals("marsship"))) {
      return true;
    }
    if ((licznik == 0) && (Statek.typ.equals("plane"))) {
      return true;
    }
    if ((licznik == 0) && (licznik_wody != 0) && (Statek.typ.equals("ship"))) {
      return true;
    }
    return false;
  }
  
  static boolean SearchCollisionsTurn(ShipsMaping Statek, String kierunek, World swiat, Block Blok)
  {
    int licznik = 0;
    

    Iterator<Map.Entry<String, ShipsMaping.mapa>> mapIterator = Statek.blokmap.entrySet().iterator();
    while (mapIterator.hasNext())
    {
      Map.Entry<String, ShipsMaping.mapa> entry = (Map.Entry)mapIterator.next();
      if (kierunek.equals("right"))
      {
        int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
        double symetriaZ = Blok.getLocation().getBlockZ();
        

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
        
        Block blok1 = swiat.getBlockAt(lokacja);
        if ((!blok1.getType().equals(Material.AIR)) && (Statek.typ.equals("airship")))
        {
          if (!Statek.blokmap.containsKey("X" + blok1.getLocation().getBlockX() + "Y" + blok1.getLocation().getBlockY() + "Z" + blok1.getLocation().getBlockZ())) {
            licznik++;
          }
        }
        else if ((!blok1.getType().equals(Material.AIR)) && (!blok1.getType().equals(Material.WATER)) && (!blok1.getType().equals(Material.STATIONARY_WATER)) && (Statek.typ.equals("ship"))) {
          if (!Statek.blokmap.containsKey("X" + blok1.getLocation().getBlockX() + "Y" + blok1.getLocation().getBlockY() + "Z" + blok1.getLocation().getBlockZ())) {
            licznik++;
          }
        }
      }
      else if (kierunek.equals("left"))
      {
        int przesuniecie = Blok.getLocation().getBlockX() - Blok.getLocation().getBlockZ();
        
        double symetriaX = Blok.getLocation().getBlockX();
        
        double X = ((ShipsMaping.mapa)entry.getValue()).x - (((ShipsMaping.mapa)entry.getValue()).x - symetriaX) * 2.0D - przesuniecie;
        if(EntityDebug) {
        	ShipsMain.log.info("value of X = " + X);
        }
        double Z = ((ShipsMaping.mapa)entry.getValue()).z + przesuniecie;
        if(EntityDebug) {
        	ShipsMain.log.info("value of Z = " + Z);
        }
        double Y = ((ShipsMaping.mapa)entry.getValue()).y;
        if(EntityDebug) {
        	ShipsMain.log.info("value of Y = " + Y);
        }
        
        
        Location lokacja = new Location(swiat, Z, Y, X);
        
        Block blok1 = swiat.getBlockAt(lokacja);
        if ((!blok1.getType().equals(Material.AIR)) && (Statek.typ.equals("airship")))
        {
          if (!Statek.blokmap.containsKey("X" + blok1.getLocation().getBlockX() + "Y" + blok1.getLocation().getBlockY() + "Z" + blok1.getLocation().getBlockZ())) {
            licznik++;
          }
        }
        else if ((!blok1.getType().equals(Material.AIR)) && (!blok1.getType().equals(Material.WATER)) && (!blok1.getType().equals(Material.STATIONARY_WATER)) && (Statek.typ.equals("ship"))) {
          if (!Statek.blokmap.containsKey("X" + blok1.getLocation().getBlockX() + "Y" + blok1.getLocation().getBlockY() + "Z" + blok1.getLocation().getBlockZ())) {
            licznik++;
          }
        }
      }
    }
    if(BlockDebug) {
    	ShipsMain.log.info("value of licznik = " + licznik);
    }
    if (licznik == 0) {
      return true;
    }
    return false;
  }
}

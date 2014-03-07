package Ships;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Sign;

public class ShipsRequirements
  extends ShipsMain
{
  static boolean SpecificBlock(String typ, int WymaganyBlok, int IloscBlokowStatku)
  {
    if (typ == null) {
      return false;
    }
    if (typ.equals("airship"))
    {
      if (WymaganyBlok * 100 / IloscBlokowStatku >= AirShipRequiredPercent) {
          if(VesselDebug == true){
          	ShipsMain.log.info("found airship required % of wool needed at " + AirShipRequiredPercent);
          }
        return true;
      }
      return false;
    }
    if (typ.equals("airship2"))
    {
      if (WymaganyBlok * 100 / IloscBlokowStatku >= AirShip2RequiredPercent) {
        return true;
      }
      return false;
    }
    if (typ.equals("ship"))
    {
      if (WymaganyBlok * 100 / IloscBlokowStatku >= ShipRequiredPercent) {
        return true;
      }
      return false;
    }
    if (typ.equals("marsship"))
    {
      if (WymaganyBlok * 100 / IloscBlokowStatku >= MarsShipRequiredPercent) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  static boolean fire(int IloscOgnia)
  {
    if (IloscOgnia > 0) {
      return true;
    }
    return false;
  }
  
  static boolean MinimumNumberOfBlocks(String typ, int IloscBlokowStatku)
  {
    if (typ == null) {
      return false;
    }
    if (typ.equals("airship"))
    {
      if (IloscBlokowStatku > AirShipTheMinimumNumberOfBlocks) {
          if(VesselDebug == true){
          	ShipsMain.log.info("found minimum number of blocks needed for a airship");
          }
        return true;
      }
    }
    else if (typ.equals("airship2"))
    {
      if (IloscBlokowStatku > AirShip2TheMinimumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("plane"))
    {
      if (IloscBlokowStatku > PlaneTheMinimumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("ship"))
    {
      if (IloscBlokowStatku > ShipTheMinimumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("marsship")) {
      if (IloscBlokowStatku > MarsShipTheMinimumNumberOfBlocks) {
        return true;
      }
    }
    return false;
  }
  
  static boolean MaximumNumberOfBlocks(String typ, int IloscBlokowStatku)
  {
    if (typ == null) {
      return false;
    }
    if (typ.equals("airship"))
    {
      if (IloscBlokowStatku < AirShipTheMaximumNumberOfBlocks) {
          if(VesselDebug == true){
          	ShipsMain.log.info("found airship maximum number of blocks");
          }
        return true;
      }
    }
    else if (typ.equals("airship2"))
    {
      if (IloscBlokowStatku < AirShip2TheMaximumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("plane"))
    {
      if (IloscBlokowStatku < PlaneTheMaximumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("ship"))
    {
      if (IloscBlokowStatku < ShipTheMaximumNumberOfBlocks) {
        return true;
      }
    }
    else if (typ.equals("marsship")) {
      if (IloscBlokowStatku < MarsShipTheMaximumNumberOfBlocks) {
        return true;
      }
    }
    return false;
  }
  
  static boolean Owner(String owner, ArrayList<Sign> SignList)
  {
    for (int a = 0; SignList.size() > a; a++) {
      if ((((Sign)SignList.get(a)).getLine(0) == ChatColor.YELLOW + "[Ships]") && (
        (((Sign)SignList.get(a)).getLine(2) == ChatColor.GREEN + owner) || (((Sign)SignList.get(a)).getLine(3) == ChatColor.GREEN + owner))) {
        return true;
      }
    }
    return false;
  }
  
  static boolean EOTisStop(ArrayList<Sign> SignList)
  {
    for (int a = 0; SignList.size() > a; a++) {
      if ((((Sign)SignList.get(a)).getLine(0).equals(ChatColor.YELLOW + "[E.O.T]")) && (((Sign)SignList.get(a)).getLine(2).equals("-[" + ChatColor.WHITE + "STOP" + ChatColor.BLACK + "]-"))) {
        return true;
      }
    }
    return false;
  }
  
  static boolean Fuel(ShipsMaping statek)
  {
    if (statek.isFuel) {
      return true;
    }
    return false;
  }
  
  static boolean Fuel2(ShipsMaping statek)
  {
    if (statek.isFuel2) {
      return true;
    }
    return false;
  }
  
  static boolean Fuel3(ShipsMaping statek)
  {
    if (statek.isFuel3) {
      return true;
    }
    return false;
  }
  
  static boolean Day(String swiat)
  {
    long time = Bukkit.getServer().getWorld(swiat).getTime();
    if ((time > 0L) && (time < 13000L)) {
        if(VesselDebug == true){
        	ShipsMain.log.info("found marsship time for day");
        	ShipsMain.log.info("current time = " + time);
        }
      return true;
    }
    if(VesselDebug == true) {
        ShipsMain.log.info("Time needs to be between " + 0L + " and " + 13000L);
    }
    return false;
  }
}

package Ships;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ShipsIF
  extends ShipsMain
{
  static boolean ifCanMove(Player player, ShipsMaping Statek)
  {
    String swiat = Statek.swiat;
    if (Statek.typ == null) {
      return false;
    }
    if (Statek.typ.equals("airship"))
    {
        if(VesselDebug){
        	ShipsMain.log.info("Found airship");
        }
      if (ShipsRequirements.MinimumNumberOfBlocks("airship", Statek.LiczbaBlokow))
      {
          if(VesselDebug){
          	ShipsMain.log.info("found minimumnumberofblocks at " + AirShipTheMinimumNumberOfBlocks);
          }
        if (ShipsRequirements.MaximumNumberOfBlocks("airship", Statek.LiczbaBlokow))
        {
            if(VesselDebug){
            	ShipsMain.log.info("found maximumnumberofblocks at " + AirShipTheMaximumNumberOfBlocks);
            }
          if (ShipsRequirements.SpecificBlock("airship", Statek.LiczbaWelny, Statek.LiczbaBlokow))
          {
              if(VesselDebug){
              	ShipsMain.log.info("checking if wool is on vessel");
              }
            if (ShipsRequirements.fire(Statek.isFire))
            {
                if(VesselDebug){
                	ShipsMain.log.info("checking if burner is on vessel");
                	ShipsMain.log.info("value of isFire = " + Statek.isFire);
                }
              if (ShipsRequirements.Fuel(Statek)) {
                  if(VesselDebug){
                  	ShipsMain.log.info("checking if fuel can be taken");
                  }
                return true;
              }
              player.sendMessage(ChatColor.RED + "[Ships] Out of fuel!");
              return false;
            }
            player.sendMessage(ChatColor.RED + "[Ships] Add a burner!");
            return false;
          }
          player.sendMessage(ChatColor.RED + "[Ships] Add more wool!");
          return false;
        }
        player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
        return false;
      }
      player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
      return false;
    }
    if (Statek.typ.equals("airship2"))
    {
      if (ShipsRequirements.MinimumNumberOfBlocks("airship2", Statek.LiczbaBlokow))
      {
        if (ShipsRequirements.MaximumNumberOfBlocks("airship2", Statek.LiczbaBlokow))
        {
          if (ShipsRequirements.SpecificBlock("airship2", Statek.LiczbaWelny, Statek.LiczbaBlokow))
          {
            if (ShipsRequirements.fire(Statek.isFire))
            {
              if (ShipsRequirements.Fuel2(Statek)) {
                return true;
              }
              player.sendMessage(ChatColor.RED + "[Ships] Out of fuel!");
              return false;
            }
            player.sendMessage(ChatColor.RED + "[Ships] Add a burner!");
            return false;
          }
          player.sendMessage(ChatColor.RED + "[Ships] Add more wool!");
          return false;
        }
        player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
        return false;
      }
      player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
      return false;
    }
    if (Statek.typ.equals("ship"))
    {
      if (ShipsRequirements.MinimumNumberOfBlocks("ship", Statek.LiczbaBlokow))
      {
        if (ShipsRequirements.MaximumNumberOfBlocks("ship", Statek.LiczbaBlokow))
        {
          if (ShipsRequirements.SpecificBlock("ship", Statek.LiczbaWelny, Statek.LiczbaBlokow)) {
            return true;
          }
          player.sendMessage(ChatColor.RED + "[Ships] Add wool!");
          return false;
        }
        player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
        return false;
      }
      player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
      return false;
    }
    if (Statek.typ.equals("plane"))
    {
      if (ShipsRequirements.MinimumNumberOfBlocks("plane", Statek.LiczbaBlokow))
      {
        if (ShipsRequirements.MaximumNumberOfBlocks("plane", Statek.LiczbaBlokow))
        {
          if (ShipsRequirements.Fuel3(Statek)) {
             return true;
          }
        player.sendMessage(ChatColor.RED + "[Ships] Out of fuel!");
        return false;
        }
        player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
        return false;
      }
      player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
      return false;
    }
    if (Statek.typ.equals("marsship")) {
      if (ShipsRequirements.MinimumNumberOfBlocks("marsship", Statek.LiczbaBlokow))
      {
        if (ShipsRequirements.MaximumNumberOfBlocks("marsship", Statek.LiczbaBlokow))
        {
          if (ShipsRequirements.SpecificBlock("marsship", Statek.LiczbaPaneliS, Statek.LiczbaBlokow))
          {
            if (ShipsRequirements.Day(swiat)) {
              return true;
            }
            player.sendMessage(ChatColor.RED + "[Ships] No light!");
          }
          else
          {
            player.sendMessage(ChatColor.RED + "[Ships] The airship has no power. Add more Daylight Sensor!");
            return false;
          }
        }
        else
        {
          player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
          return false;
        }
      }
      else
      {
        player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
        return false;
      }
    }
    return false;
  }
  
  static boolean ifCanMoveDown(Player player, ShipsMaping Statek)
  {
    if (ShipsRequirements.MinimumNumberOfBlocks(Statek.typ, Statek.LiczbaBlokow))
    {
      if (ShipsRequirements.MaximumNumberOfBlocks(Statek.typ, Statek.LiczbaBlokow)) {
        return true;
      }
      player.sendMessage(ChatColor.RED + "[Ships] The ship is too big!");
      return false;
    }
    player.sendMessage(ChatColor.RED + "[Ships] The ship is too small. you need to add more blocks!");
    return false;
  }
}

package Ships;

import org.bukkit.entity.Player;

public class ShipsPermissions
  extends ShipsMain
{
  static boolean isUse(Player player, String typ)
  {
    if (((typ.equals("ship")) && (player.hasPermission("ships.ship.use"))) || 
      ((typ.equals("airship")) && (player.hasPermission("ships.airship.use"))) || (
      (typ.equals("marsship")) && (player.hasPermission("ships.marsship.use"))) || (
      (typ.equals("airship2")) && (player.hasPermission("ships.airship2.use"))) || (
      (typ.equals("plane")) && (player.hasPermission("ships.plane.use")))) {
        if(VesselDebug){
        	ShipsMain.log.info("found player has permission to use vessel");
        }
      return true;
    }
    player.sendMessage("Do not have permission to drive this vessel");
    return false;
  }
  
  static boolean isMake(Player player, String typ)
  {
    if (((typ.equals("ship")) && (player.hasPermission("ships.ship.make"))) || ((typ.equals("airship")) && (player.hasPermission("ships.airship.make")))) {
      return true;
    }
    player.sendMessage("Do not have permission to make this vessel type");
    return false;
  }
}

package Ships;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ShipsMain
  extends JavaPlugin
{
  static boolean SuportKingdoms;
  static String activateText;
  static String alternativText;
  static int AirShipRequiredBlock;
  static int AirShipEngineSpeed;
  static int AirShipRequiredPercent;
  static int AirShipTheMinimumNumberOfBlocks;
  static int AirShipTheMaximumNumberOfBlocks;
  static int AirShipBoostSpeed;
  static int AirShip2RequiredBlock;
  static int AirShip2RequiredPercent;
  static int AirShip2TheMinimumNumberOfBlocks;
  static int AirShip2TheMaximumNumberOfBlocks;
  static int AirShip2FuelId;
  static int AirShip2FuelIdAlt;
  static int AirShip2FuelConsumption;
  static int AirShip2Speed;
  static int Airship2EngineSpeed;
  static int AirShip2BoostSpeed;
  static int PlaneTheMinimumNumberOfBlocks;
  static int PlaneTheMaximumNumberOfBlocks;
  static int PlaneFuelId;
  static int PlaneFuelIdAlt;
  static int PlaneSpeed;
  static int PlaneBoostSpeed;
  static int PlaneEngineSpeed;
  static int PlaneFuelConsumption;
  static int ShipRequiredBlock;
  static int ShipRequiredPercent;
  static int ShipTheMinimumNumberOfBlocks;
  static int ShipTheMaximumNumberOfBlocks;
  static int ShipBoostSpeed;
  static int AirShipFuelId;
  static int AirShipFuelIdAlt;
  static int ShipSpeed;
  static int ShipEngineSpeed;
  static int AirShipSpeed;
  static int MarsShipRequiredBlock;
  static int MarsShipRequiredPercent;
  static int MarsShipTheMinimumNumberOfBlocks;
  static int MarsShipTheMaximumNumberOfBlocks;
  static int MarsShipSpeed;
  static int MarsShipEngineSpeed;
  static int MarsShipBoostSpeed;
  static int waterlevel;
  static int EngineSpeed;
  static int ConfigVersion;
  static boolean AllowBoost;
  static boolean CreateConfig;
  static boolean ProtectFire;
  static boolean BootUpDebug;
  static boolean BlockDebug;
  static boolean EntityDebug;
  static boolean ItemDebug;
  static boolean VesselDebug;
  static boolean RotateDebug;
  static boolean ReturnDebug;
  static boolean Acacia_Leaves;
  static boolean Wooden_Planks;
  static boolean Stone;
  static boolean Dirt;
  static boolean Grass;
  static boolean Cobblestone;
  static boolean Sand;
  static boolean Gravel;
  static boolean Gold_Ore;
  static boolean Iron_Ore;
  static boolean Coal_Ore;
  static boolean Wood_Log;
  static boolean Leaves;
  static boolean Sponge;
  static boolean Glass_Block;
  static boolean Lapis_Ore;
  static boolean Lapis_Block;
  static boolean Dispenser;
  static boolean SandStone;
  static boolean Note_Block;
  static boolean Piston_Sticky;
  static boolean Web_Block;
  static boolean Piston_Normal;
  static boolean Piston_Head;
  static boolean Gold_Block;
  static boolean Iron_Block;
  static boolean Bricks;
  static boolean TNT;
  static boolean Bookshelf;
  static boolean Cobblestone_Mossy;
  static boolean Obsidian;
  static boolean Spawner;
  static boolean Wooden_Stairs;
  static boolean Diamond_Ore;
  static boolean Diamond_Block;
  static boolean Crafting_Table;
  static boolean Redstone_Ore;
  static boolean Snow;
  static boolean Snow_Block;
  static boolean Clay;
  static boolean JukeBox;
  static boolean Fence;
  static boolean Pumpkin;
  static boolean Soul_Sand;
  static boolean Glowstone;
  static boolean Cake;
  static boolean Jack_O_Lantern;
  static boolean Redstone_Repeater;
  static boolean Silverfish_Blocks;
  static boolean Stone_Brick;
  static boolean Iron_Bars;
  static boolean Glass_Pane;
  static boolean Melon_Block;
  static boolean Fence_Gate;
  static boolean Brick_Stairs;
  static boolean Stone_Brick_Stairs;
  static boolean Nether_Brick;
  static boolean Nether_Brick_Fence;
  static boolean Nether_Brick_Stairs;
  static boolean Enchantment_Table;
  static boolean Brewing_Stand;
  static boolean Cauldron;
  static boolean Redstone_Lamp;
  static boolean Double_Wood_Slab;
  static boolean Wood_Slab;
  static boolean Sandstone_Stairs;
  static boolean Emerald_Ore;
  static boolean Ender_Chest;
  static boolean Emerald_Block;
  static boolean Command_Block;
  static boolean Beacon;
  static boolean Cobblestone_Wall;
  static boolean Head;
  static boolean Redstone_Block;
  static boolean Quartz_Ore;
  static boolean Quartz_Block;
  static boolean Quartz_Stairs;
  static boolean Clay_Stained;
  static boolean Hay_Bale;
  static boolean Carpet;
  static boolean Hardened_Clay;
  static boolean Coal_Block;
  static boolean Glass_Stained;
  static boolean Glass_Pane_Stained;
  static boolean Daylight;
  static boolean Netherrack;
  static boolean Iron_Door;
  static boolean Wool;
  static boolean Dropper;
  static boolean Rail_Activtor;
  static boolean Hopper;
  static boolean Redstone_Comparator;
  static boolean PressurePlate_Weighted_Heavy;
  static boolean PressurePlate_Weighted_Light;
  static boolean Chest_Trapped;
  static boolean Anvil;
  static boolean Button_Wooden;
  static boolean Tripwire_Hook;
  static boolean Flower_Pot;
  static boolean String;
  static boolean Button_Stone;
  static boolean Door_Trap;
  static boolean Redstone_Torch;
  static boolean PresurePlate_Wooden;
  static boolean Stone_PressurePlate;
  static boolean Lever;
  static boolean Ladder;
  static boolean Door_Wooden;
  static boolean Furnace;
  static boolean Redstone;
  static boolean Chest;
  static boolean Torch;
  static boolean Fire;
  static boolean Bed;
  static boolean Wooden_Acacia;
  static boolean Wooden_Acacia_Stairs;
  
  static Logger log = Logger.getLogger("Minecraft");
  ShipsMaping mys;
  static String swiat;
  static Bloki ShipsBlock = new Bloki();
  
  @Override
  public void onDisable()
  {
    Bukkit.getServer().getScheduler().cancelAllTasks();
    PluginDescriptionFile p = this.getDescription();
    this.log.info("[" + p.getName() + "] Thank you for using Ships");
  }
  
  @Override
  public void onEnable()
  {
    Object blok = null;
    
    this.log.info(ChatColor.GREEN + "--------[Ships]-------");
    
    PluginManager PM = getServer().getPluginManager();
    PM.registerEvents(new ShipsListener(), this);
    
    PluginDescriptionFile p = this.getDescription();
    this.log.info("Booting up Ships" + p.getVersion());
    this.log.info("If any errors are found, please contact mose from the dev.bukkit page");
    
    ShipsSettings.LoadSettings();
    Bloki.LoadSettings();
            
    getLogger().info("----recommended errors----");
    
    if(BootUpDebug) {
	  ShipsMain.log.info("---- Debug BootUp - Config ----");
  	  ShipsMain.log.info("--Checking airship values--");
  	  ShipsMain.log.info("The Required % = " + AirShipRequiredPercent);
  	  ShipsMain.log.info("The Minimum number of blocks needed = " + AirShipTheMinimumNumberOfBlocks);
  	  ShipsMain.log.info("The Miximum number of blocks needed = " + AirShipTheMaximumNumberOfBlocks);
  	  ShipsMain.log.info("The fuel id = " + AirShipFuelId);
  	  ShipsMain.log.info("The Alt fuel id = " + AirShipFuelIdAlt);
  	  ShipsMain.log.info("The EOT speed = " + AirShipSpeed);
  	  ShipsMain.log.info("--------");
  	  ShipsMain.log.info("--Checking Other values--");
  	  ShipsMain.log.info("Protect againced fire = " + ProtectFire);
  	  ShipsMain.log.info("the default water level = " + waterlevel);
  	  ShipsMain.log.info("CreateConfig = " + CreateConfig);
  	  ShipsMain.log.info("Boost = " + AllowBoost);
  	  ShipsMain.log.info("--------");
  	  ShipsMain.log.info("--Checking Debug Values--");
  	  ShipsMain.log.info("BootupDebug = " + BootUpDebug);
  	  ShipsMain.log.info("VesselDebug = " + VesselDebug);
  	  ShipsMain.log.info("EntityDebug = " + EntityDebug);
  	  ShipsMain.log.info("ItemDebug = " + ItemDebug);
  	  ShipsMain.log.info("BlockDebug = " + BlockDebug);
  	  ShipsMain.log.info("RotateDebug = "+ RotateDebug);
  	  ShipsMain.log.info("--------");
  	  ShipsMain.log.info("--Materials--");
  	  ShipsMain.log.info("Beacon = " + Beacon);
  	  ShipsMain.log.info("Bookshelf = " + Bookshelf);
  	  ShipsMain.log.info("Brewing_Stand = " + Brewing_Stand);
  	  ShipsMain.log.info("Quartz_Block = " + Quartz_Block);
  	  ShipsMain.log.info("--------");
  	  ShipsMain.log.info("--Testers Materials--");
  	  ShipsMain.log.info("Bed = " + Bed);
    }
    
	if(ItemDebug) {
		ShipsMain.log.warning("Debug WILL spam the console of what the ships plugin is doing");
	}
	    
    if (Wooden_Planks == false) {
    	this.log.warning(" Wooden Planks has been disabled in config, this is not recommended");
    }
    
    if (Silverfish_Blocks == false) {
    	if(Stone) {
    		this.log.warning("Stone has been enabled on your server but Silverfish_Blocks have not, this may make vessels break");
    	}
    	if(Cobblestone) {
    		this.log.warning("Cobblestone has been enabled on your server but Silverfish_Blocks have not, this may make vessels break");
    	}
    	if(Stone_Brick) {
    		this.log.warning("Stone_Brick has been enabled on your server but Silverfish_Blocks have not, this may make your vessels break");
    	}
    }
    
    if (Netherrack == false) {
    	this.log.warning("Netherrack are disabled in config, turn them on to use Airships");
    }
    
    if (Daylight == false) {
    	this.log.warning("Daylight sensors are disabled in config, turn them on to use MarsShips");
    }
    
    if (Furnace == false) {
    	this.log.warning("Furnaces are disabled in config, turn them on to use Airships");
    }
    
    if (Fire == false) {
    	this.log.warning("Fire is disabled in config, turn it on to use Airships");
    }
    
    getLogger().info("  --------[Ships]-------");
    	
    Plugin plugin = Bukkit.getPluginManager().getPlugin("Ships");
  }
}

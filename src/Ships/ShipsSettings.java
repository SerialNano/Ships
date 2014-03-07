package Ships;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ShipsSettings
  extends ShipsMain
{
  static void LoadSettings()
  {
    ConfigurationSection airshipConf = null;
    ConfigurationSection airship2Conf = null;
    ConfigurationSection shipConf = null;
    ConfigurationSection marsshipConf = null;
    ConfigurationSection planeConf = null;
    ConfigurationSection other = null;
    ConfigurationSection DebugConf = null;
    ConfigurationSection MaterialsConf = null;
    ConfigurationSection EMaterialsConf = null;
    
    String plik = "config.yml";
    File ConfigFIle = new File("plugins/Ships/" + plik);
    
    FileConfiguration conf = YamlConfiguration.loadConfiguration(ConfigFIle);
    if (!conf.isConfigurationSection("airship")) {
      airshipConf = conf.createSection("airship");
    }
    if (!conf.isConfigurationSection("airship2")) {
      airship2Conf = conf.createSection("airship2");
    }
    if (!conf.isConfigurationSection("ship")) {
      shipConf = conf.createSection("ship");
    }
    if (!conf.isConfigurationSection("marsship")) {
      marsshipConf = conf.createSection("marsship");
    }
    if (!conf.isConfigurationSection("plane")) {
      planeConf = conf.createSection("plane");
    }
    if (!conf.isConfigurationSection("Other")) {
      other = conf.createSection("Other");
    }
    if (!conf.isConfigurationSection("Debug")) {
      DebugConf = conf.createSection("Debug");
    }
    if (!conf.isConfigurationSection("Materials")) {
      MaterialsConf = conf.createSection("Materials");
    }
    if (!conf.isConfigurationSection("Dont_Touch_Unless_Tester")) {
      EMaterialsConf = conf.createSection("Dont_Touch_Unless_Tester");
    }
    airshipConf = conf.getConfigurationSection("airship");
    airship2Conf = conf.getConfigurationSection("airship2");
    shipConf = conf.getConfigurationSection("ship");
    marsshipConf = conf.getConfigurationSection("marsship");
    planeConf = conf.getConfigurationSection("plane");
    other = conf.getConfigurationSection("Other");
    DebugConf = conf.getConfigurationSection("Debug");
    MaterialsConf = conf.getConfigurationSection("Materials");
    EMaterialsConf = conf.getConfigurationSection("Dont_Touch_Unless_Tester");
    
    AirShipRequiredBlock = airshipConf.getInt("RequiredBlock");
    AirShipRequiredPercent = airshipConf.getInt("RequiredPercent");
    AirShipTheMinimumNumberOfBlocks = airshipConf.getInt("TheMinimumNumberOfBlocks");
    AirShipTheMaximumNumberOfBlocks = airshipConf.getInt("TheMaximumNumberOfBlocks");
    AirShipFuelId = airshipConf.getInt("FuelId");
    AirShipFuelIdAlt = airshipConf.getInt("FuelIdAlt");
    AirShipSpeed = airshipConf.getInt("Speed");
    AirShipEngineSpeed = airshipConf.getInt("EngineSpeed");
    AirShipBoostSpeed = airshipConf.getInt("BoostSpeed");
    
    AirShip2RequiredBlock = airship2Conf.getInt("RequiredBlock");
    AirShip2RequiredPercent = airship2Conf.getInt("RequiredPercent");
    AirShip2TheMinimumNumberOfBlocks = airship2Conf.getInt("TheMinimumNumberOfBlocks");
    AirShip2TheMaximumNumberOfBlocks = airship2Conf.getInt("TheMaximumNumberOfBlocks");
    AirShip2FuelId = airship2Conf.getInt("FuelId");
    AirShip2FuelIdAlt = airship2Conf.getInt("FuelIdAlt");
    AirShip2FuelConsumption = airship2Conf.getInt("FuelConsumption");
    AirShip2Speed = airship2Conf.getInt("Speed");
    Airship2EngineSpeed = airship2Conf.getInt("EngineSpeed");
    AirShip2BoostSpeed = airship2Conf.getInt("BoostSpeed");
   
    ShipRequiredBlock = shipConf.getInt("RequiredBlock");
    ShipRequiredPercent = shipConf.getInt("RequiredPercent");
    ShipTheMinimumNumberOfBlocks = shipConf.getInt("TheMinimumNumberOfBlocks");
    ShipTheMaximumNumberOfBlocks = shipConf.getInt("TheMaximumNumberOfBlocks");
    ShipSpeed = shipConf.getInt("Speed");
    ShipEngineSpeed = shipConf.getInt("EngineSpeed");
    ShipBoostSpeed = shipConf.getInt("BoostSpeed");
    
    MarsShipRequiredBlock = marsshipConf.getInt("RequiredBlock");
    MarsShipRequiredPercent = marsshipConf.getInt("RequiredPercent");
    MarsShipTheMinimumNumberOfBlocks = marsshipConf.getInt("TheMinimumNumberOfBlocks");
    MarsShipTheMaximumNumberOfBlocks = marsshipConf.getInt("TheMaximumNumberOfBlocks");
    MarsShipSpeed = marsshipConf.getInt("Speed");
    MarsShipEngineSpeed = marsshipConf.getInt("EngineSpeed");
    MarsShipBoostSpeed = marsshipConf.getInt("BoostSpeed");
    
    PlaneTheMinimumNumberOfBlocks = planeConf.getInt("TheMinimumNumberOfBlocks");
    PlaneTheMaximumNumberOfBlocks = planeConf.getInt("TheMaximumNumberOfBlocks");
    PlaneFuelId = planeConf.getInt("FuelId");
    PlaneFuelIdAlt = planeConf.getInt("FuelIdAlt");
    PlaneFuelConsumption = planeConf.getInt("FuelConsumption");
    PlaneSpeed = planeConf.getInt("Speed");
    PlaneEngineSpeed = planeConf.getInt("EngineSpeed");
    PlaneBoostSpeed = planeConf.getInt("BoostSpeed");
    
    ConfigVersion = other.getInt("ConfigVersion");
       
    if(!(ConfigVersion == 3)){
    	other.set("ConfigVersion", Integer.valueOf(2));
    }
    other.set("CreateConfig", Boolean.valueOf(false));
        
    waterlevel = other.getInt("DefaultWaterLevel");
    ProtectFire = other.getBoolean("ProtectFire");
    AllowBoost = other.getBoolean("AllowBoost");
    
    BootUpDebug = DebugConf.getBoolean("BootUpDebug");
    VesselDebug = DebugConf.getBoolean("VesselDebug");
    BlockDebug = DebugConf.getBoolean("BlockDebug");
    ItemDebug = DebugConf.getBoolean("ItemDebug");
    EntityDebug = DebugConf.getBoolean("EntityDebug");
    RotateDebug = DebugConf.getBoolean("RotateDebug");
 
    Acacia_Leaves = MaterialsConf.getBoolean("Acacia_Leaves");
    Beacon = MaterialsConf.getBoolean("Beacon");
    Bookshelf = MaterialsConf.getBoolean("Bookshelf");
    Brewing_Stand = MaterialsConf.getBoolean("Brewing_Stand");
    Bricks = MaterialsConf.getBoolean("Bricks");
    Wooden_Stairs = MaterialsConf.getBoolean("Wooden_Stairs");  
    Double_Wood_Slab = MaterialsConf.getBoolean("Wood_Slab_Double");
    Wood_Slab = MaterialsConf.getBoolean("Wood_Slab");
    Wooden_Planks = MaterialsConf.getBoolean("Wooden_Planks");
    Wood_Log = MaterialsConf.getBoolean("Wood_Log");
    Web_Block = MaterialsConf.getBoolean("Web_Block");
    TNT = MaterialsConf.getBoolean("TNT");
    Stone_Brick_Stairs = MaterialsConf.getBoolean("Stone_Brick_Stairs");
    Stone_Brick = MaterialsConf.getBoolean("Stone_Brick");
    Stone = MaterialsConf.getBoolean("Stone");
    Stone_PressurePlate = MaterialsConf.getBoolean("Stone_PressurePlate");
    Soul_Sand = MaterialsConf.getBoolean("Soul_Sand");
    Sponge = MaterialsConf.getBoolean("Sponge");
    Silverfish_Blocks = MaterialsConf.getBoolean("Silverfish_Blocks");
    Snow = MaterialsConf.getBoolean("Snow");
    Snow_Block = MaterialsConf.getBoolean("Snow_Block");
    Sandstone_Stairs = MaterialsConf.getBoolean("Sandstone_Stairs");
    SandStone = MaterialsConf.getBoolean("Sandstone");
    Sand = MaterialsConf.getBoolean("Sand");
    Spawner = MaterialsConf.getBoolean("Spawner");
    Redstone_Ore = MaterialsConf.getBoolean("Redstone_Ore");
    Redstone_Repeater = MaterialsConf.getBoolean("Redstone_Repeater");
    Redstone_Lamp = MaterialsConf.getBoolean("Redstone_Lamp");
    Redstone_Block = MaterialsConf.getBoolean("Redstone_Block");
    Quartz_Ore = MaterialsConf.getBoolean("Quartz_Ore");
    Quartz_Stairs = MaterialsConf.getBoolean("Quartz_Stairs");
    Quartz_Block = MaterialsConf.getBoolean("Quartz_Block");
    Pumpkin = MaterialsConf.getBoolean("Pumpkin");
    Piston_Sticky = MaterialsConf.getBoolean("Piston_Sticky");
    Piston_Normal = MaterialsConf.getBoolean("Piston_Normal");
    Piston_Head = MaterialsConf.getBoolean("Piston_Head");
    Obsidian = MaterialsConf.getBoolean("Obsidian");
    Note_Block = MaterialsConf.getBoolean("Note_Block");
    Nether_Brick_Stairs = MaterialsConf.getBoolean("Nether_Brick_Stairs");
    Nether_Brick_Fence = MaterialsConf.getBoolean("Nether_Brick_Fence");
    Nether_Brick = MaterialsConf.getBoolean("Nether_Brick");
    Melon_Block = MaterialsConf.getBoolean("Melon_Block");
    Leaves = MaterialsConf.getBoolean("Leaves");
    Lapis_Block = MaterialsConf.getBoolean("Lapis_Block");
    Lapis_Ore = MaterialsConf.getBoolean("Lapis_Ore");
    Jack_O_Lantern = MaterialsConf.getBoolean("Jack_O_Lantern");
    JukeBox = MaterialsConf.getBoolean("JukeBox");
    Iron_Block = MaterialsConf.getBoolean("Iron_Block");
    Iron_Ore = MaterialsConf.getBoolean("Iron_Ore");
    Iron_Bars = MaterialsConf.getBoolean("Iron_Bars");
    Head = MaterialsConf.getBoolean("Head");
    Hay_Bale = MaterialsConf.getBoolean("Hay_Bale");
    Gold_Ore = MaterialsConf.getBoolean("Gold_Ore");
    Gold_Block = MaterialsConf.getBoolean("Gold_Block");
    Gravel = MaterialsConf.getBoolean("Gravel");
    Grass = MaterialsConf.getBoolean("Grass_Block");
    Glowstone = MaterialsConf.getBoolean("Glowstone");
    Glass_Pane_Stained = MaterialsConf.getBoolean("Glass_Pane_Stained");
    Glass_Stained = MaterialsConf.getBoolean("Glass_Stained");
    Glass_Pane = MaterialsConf.getBoolean("Glass_Pane");
    Glass_Block = MaterialsConf.getBoolean("Glass_Block");
    Fence_Gate = MaterialsConf.getBoolean("Fence_Gate");
    Fence = MaterialsConf.getBoolean("Fence");
    Ender_Chest = MaterialsConf.getBoolean("Ender_Chest");
    Enchantment_Table = MaterialsConf.getBoolean("Enchantment_Table");
    Emerald_Ore = MaterialsConf.getBoolean("Emerald_Ore");
    Emerald_Block = MaterialsConf.getBoolean("Emerald_Block");
    Dispenser = MaterialsConf.getBoolean("Dispenser");
    Dirt = MaterialsConf.getBoolean("Dirt");
    Diamond_Block = MaterialsConf.getBoolean("Diamond_Block");
    Diamond_Ore = MaterialsConf.getBoolean("Diamond_Ore");
    Command_Block = MaterialsConf.getBoolean("Command_Block");
    Cobblestone_Wall = MaterialsConf.getBoolean("Cobblestone_Wall");
    Cobblestone_Mossy = MaterialsConf.getBoolean("Cobblestone_Mossy");
    Cobblestone = MaterialsConf.getBoolean("Cobblestone");
    Coal_Ore = MaterialsConf.getBoolean("Coal_Ore");
    Coal_Block = MaterialsConf.getBoolean("Coal_Block");
    Crafting_Table = MaterialsConf.getBoolean("Crafting_Table");
    Cauldron = MaterialsConf.getBoolean("Cauldron");  
    Clay_Stained = MaterialsConf.getBoolean("Clay_Stained");
    Hardened_Clay = MaterialsConf.getBoolean("Clay_Hardened");
    Clay = MaterialsConf.getBoolean("Clay");
    Brick_Stairs = MaterialsConf.getBoolean("Brick_Stairs");  
    Wooden_Acacia = MaterialsConf.getBoolean("Wooden_Acacia");
    Wooden_Acacia_Stairs = MaterialsConf.getBoolean("Wooden_Acacia_Stairs");
    
    //Experimental
    Fire = EMaterialsConf.getBoolean("Fire");
    Torch = EMaterialsConf.getBoolean("Torch");
    Chest = EMaterialsConf.getBoolean("Chest");
    Redstone = EMaterialsConf.getBoolean("Redstone");
    Furnace = EMaterialsConf.getBoolean("Furnace");
    Door_Wooden = EMaterialsConf.getBoolean("Door_Wooden");
    Ladder = EMaterialsConf.getBoolean("Ladder");
    Lever = EMaterialsConf.getBoolean("Lever");
    PresurePlate_Wooden = EMaterialsConf.getBoolean("PresurePlate_Wooden");
    Redstone_Torch = EMaterialsConf.getBoolean("Redstone_Torch");
    Door_Trap = EMaterialsConf.getBoolean("Door_Trap");
    Button_Stone = EMaterialsConf.getBoolean("Button_Stone");
    String = EMaterialsConf.getBoolean("String");
    Flower_Pot = EMaterialsConf.getBoolean("Flower_Pot");
    Tripwire_Hook = EMaterialsConf.getBoolean("Tripwire_Hook");
    Button_Wooden = EMaterialsConf.getBoolean("Button_Wooden");
    Anvil = EMaterialsConf.getBoolean("Anvil");
    Chest_Trapped = EMaterialsConf.getBoolean("Chest_Trapped");
    Redstone_Comparator = EMaterialsConf.getBoolean("Redstone_Comparator");
    Hopper = EMaterialsConf.getBoolean("Hopper");
    Dropper = EMaterialsConf.getBoolean("Dropper");
    Daylight = EMaterialsConf.getBoolean("Daylight_Sensor");
    Netherrack = EMaterialsConf.getBoolean("Netherrack");
    Iron_Door = EMaterialsConf.getBoolean("Iron_Door");
    Wool = EMaterialsConf.getBoolean("Wool");
    Carpet = EMaterialsConf.getBoolean("Carpet");
    Cake = MaterialsConf.getBoolean("Cake");
    Bed = MaterialsConf.getBoolean("Bed");
    try
    {
      conf.save(ConfigFIle);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}


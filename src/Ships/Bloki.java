package Ships;

import java.util.TreeMap;

public class Bloki{
	
  static TreeMap<Integer, Boolean> Ships = new TreeMap();
    
  public Bloki()
  {
    // sign
    Ships.put(Integer.valueOf(63), Boolean.valueOf(true));
    //wall sign
	Ships.put(Integer.valueOf(68), Boolean.valueOf(true));
	//locked chest
    Ships.put(Integer.valueOf(95), Boolean.valueOf(false));
    //Slabs
    Ships.put(Integer.valueOf(44), Boolean.valueOf(false));
    //double slabs
    Ships.put(Integer.valueOf(43), Boolean.valueOf(false));
    }

   public static void LoadSettings() {
	if(ShipsMain.Wooden_Planks) {
		Ships.put(Integer.valueOf(5), Boolean.valueOf(false));
	}
	if (ShipsMain.Stone) {
		Ships.put(Integer.valueOf(1), Boolean.valueOf(false));
    }
	if (ShipsMain.Dirt) {
		Ships.put(Integer.valueOf(3), Boolean.valueOf(false));
	}
	if (ShipsMain.Grass) {
		Ships.put(Integer.valueOf(2), Boolean.valueOf(false));
	}
	if (ShipsMain.Cobblestone) {
		Ships.put(Integer.valueOf(4), Boolean.valueOf(false));
	}
	if (ShipsMain.Sand) {
		Ships.put(Integer.valueOf(12), Boolean.valueOf(false));
	}
	if (ShipsMain.Gravel) {
		Ships.put(Integer.valueOf(13), Boolean.valueOf(false));
	}
	if (ShipsMain.Gold_Ore) {
		Ships.put(Integer.valueOf(14), Boolean.valueOf(false));
	}
	if (ShipsMain.Iron_Ore) {
		Ships.put(Integer.valueOf(15), Boolean.valueOf(false));
	}
	if (ShipsMain.Coal_Ore) {
		Ships.put(Integer.valueOf(16), Boolean.valueOf(false));
	}
	if (ShipsMain.Wood_Log) {
		Ships.put(Integer.valueOf(17), Boolean.valueOf(false));
	}
	if (ShipsMain.Leaves) {
		Ships.put(Integer.valueOf(18), Boolean.valueOf(false));
	}
	if (ShipsMain.Sponge) {
		Ships.put(Integer.valueOf(19), Boolean.valueOf(false));
	}
	if (ShipsMain.Glass_Block) {
		Ships.put(Integer.valueOf(20), Boolean.valueOf(false));
	}
	if (ShipsMain.Lapis_Ore) {
		Ships.put(Integer.valueOf(21), Boolean.valueOf(false));
	}
	if (ShipsMain.Lapis_Block) {
		Ships.put(Integer.valueOf(22), Boolean.valueOf(false));
	}
	if (ShipsMain.Dispenser) {
		Ships.put(Integer.valueOf(23), Boolean.valueOf(false));
	}
	if (ShipsMain.SandStone) {
		Ships.put(Integer.valueOf(24), Boolean.valueOf(false));
	}
	if (ShipsMain.Note_Block) {
		Ships.put(Integer.valueOf(25), Boolean.valueOf(false));
	}
	if (ShipsMain.Piston_Sticky) {
		Ships.put(Integer.valueOf(29), Boolean.valueOf(false));
	}
	if (ShipsMain.Web_Block) {
		Ships.put(Integer.valueOf(30), Boolean.valueOf(false));
	}
	if (ShipsMain.Piston_Normal) {
		Ships.put(Integer.valueOf(33), Boolean.valueOf(false));
	}
	if (ShipsMain.Piston_Head) {
		Ships.put(Integer.valueOf(34), Boolean.valueOf(false));
	}
	if (ShipsMain.Gold_Block) {
		Ships.put(Integer.valueOf(41), Boolean.valueOf(false));
	}
	if (ShipsMain.Iron_Block) {
		Ships.put(Integer.valueOf(42), Boolean.valueOf(false));
	}
	if (ShipsMain.Bricks) {
		Ships.put(Integer.valueOf(45), Boolean.valueOf(false));
	}
	if (ShipsMain.TNT) {
		Ships.put(Integer.valueOf(46), Boolean.valueOf(false));
	}
	if (ShipsMain.Bookshelf) {
		Ships.put(Integer.valueOf(47), Boolean.valueOf(false));
	}
	if (ShipsMain.Cobblestone_Mossy) {
		Ships.put(Integer.valueOf(48), Boolean.valueOf(false));
	}
	if (ShipsMain.Obsidian) {
		Ships.put(Integer.valueOf(49), Boolean.valueOf(false));
	}
	if (ShipsMain.Spawner) {
		Ships.put(Integer.valueOf(52), Boolean.valueOf(false));
	}
	if (ShipsMain.Diamond_Ore) {
		Ships.put(Integer.valueOf(56), Boolean.valueOf(false));
	}
	if (ShipsMain.Diamond_Block) {
		Ships.put(Integer.valueOf(57), Boolean.valueOf(false));
	}
	if (ShipsMain.Wooden_Stairs) {
		Ships.put(Integer.valueOf(53), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(134), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(135), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(136), Boolean.valueOf(false));
	}
	if (ShipsMain.Crafting_Table) {
		Ships.put(Integer.valueOf(58), Boolean.valueOf(false));
	}
	if (ShipsMain.Redstone_Ore) {
		Ships.put(Integer.valueOf(73), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(74), Boolean.valueOf(false));
	}
	if (ShipsMain.Snow) {
		Ships.put(Integer.valueOf(78), Boolean.valueOf(false));
	}
	if (ShipsMain.Snow_Block) {
		Ships.put(Integer.valueOf(80), Boolean.valueOf(false));
	}
	if (ShipsMain.Clay) {
		Ships.put(Integer.valueOf(82), Boolean.valueOf(false));
	}
	if (ShipsMain.JukeBox) {
		Ships.put(Integer.valueOf(84), Boolean.valueOf(false));
	}
	if (ShipsMain.Fence) {
		Ships.put(Integer.valueOf(85), Boolean.valueOf(false));
	}
	if (ShipsMain.Pumpkin) {
		Ships.put(Integer.valueOf(86), Boolean.valueOf(false));
	}
	if (ShipsMain.Soul_Sand) {
		Ships.put(Integer.valueOf(88), Boolean.valueOf(false));
	}
	if (ShipsMain.Glowstone) {
		Ships.put(Integer.valueOf(89), Boolean.valueOf(false));
	}
	if (ShipsMain.Cake) {
		Ships.put(Integer.valueOf(92), Boolean.valueOf(false));
	}
	if (ShipsMain.Jack_O_Lantern) {
		Ships.put(Integer.valueOf(91), Boolean.valueOf(false));
	}
	if (ShipsMain.Redstone_Repeater) {
		Ships.put(Integer.valueOf(93), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(94), Boolean.valueOf(false));
	}
	if (ShipsMain.Glass_Stained) {
		Ships.put(Integer.valueOf(95), Boolean.valueOf(false));
	}
	if (ShipsMain.Silverfish_Blocks) {
		Ships.put(Integer.valueOf(97), Boolean.valueOf(false));
	}
	if (ShipsMain.Stone_Brick) {
		Ships.put(Integer.valueOf(98), Boolean.valueOf(false));
	}
	if (ShipsMain.Iron_Bars) {
		Ships.put(Integer.valueOf(101), Boolean.valueOf(false));
	}
	if (ShipsMain.Glass_Pane) {
		Ships.put(Integer.valueOf(102), Boolean.valueOf(false));
	}
	if (ShipsMain.Melon_Block) {
		Ships.put(Integer.valueOf(103), Boolean.valueOf(false));
	}
	if (ShipsMain.Fence_Gate) {
		Ships.put(Integer.valueOf(107), Boolean.valueOf(false));
	}
	if (ShipsMain.Brick_Stairs) {
		Ships.put(Integer.valueOf(108), Boolean.valueOf(false));
	}
	if (ShipsMain.Stone_Brick_Stairs) {
		Ships.put(Integer.valueOf(109), Boolean.valueOf(false));
	}
	if (ShipsMain.Nether_Brick) {
		Ships.put(Integer.valueOf(112), Boolean.valueOf(false));
	}
	if (ShipsMain.Nether_Brick_Fence) {
		Ships.put(Integer.valueOf(113), Boolean.valueOf(false));
	}
	if (ShipsMain.Nether_Brick_Stairs) {
		Ships.put(Integer.valueOf(114), Boolean.valueOf(false));
	}
	if (ShipsMain.Enchantment_Table) {
		Ships.put(Integer.valueOf(116), Boolean.valueOf(false));
	}
	if (ShipsMain.Brewing_Stand) {
		Ships.put(Integer.valueOf(117), Boolean.valueOf(false));
	}
	if (ShipsMain.Cauldron) {
		Ships.put(Integer.valueOf(118), Boolean.valueOf(false));
	}
	if (ShipsMain.Redstone_Lamp) {
		Ships.put(Integer.valueOf(123), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(124), Boolean.valueOf(false));
	}
	if (ShipsMain.Double_Wood_Slab) {
		Ships.put(Integer.valueOf(125), Boolean.valueOf(false));
	}
	if (ShipsMain.Wood_Slab) {
		Ships.put(Integer.valueOf(126), Boolean.valueOf(false));
	}
	if (ShipsMain.Sandstone_Stairs) {
		Ships.put(Integer.valueOf(128), Boolean.valueOf(false));
	}
	if (ShipsMain.Emerald_Ore) {
		Ships.put(Integer.valueOf(129), Boolean.valueOf(false));
	}
	if (ShipsMain.Ender_Chest) {
		Ships.put(Integer.valueOf(130), Boolean.valueOf(false));
	}
	if (ShipsMain.Emerald_Block) {
		Ships.put(Integer.valueOf(133), Boolean.valueOf(false));
	}
	if (ShipsMain.Command_Block) {
		Ships.put(Integer.valueOf(137), Boolean.valueOf(false));
	}
	if (ShipsMain.Beacon) {
		Ships.put(Integer.valueOf(138), Boolean.valueOf(false));
	}
	if (ShipsMain.Cobblestone_Wall) {
		Ships.put(Integer.valueOf(139), Boolean.valueOf(false));
	}
	if (ShipsMain.Head) {
		Ships.put(Integer.valueOf(144), Boolean.valueOf(false));
	}
	if (ShipsMain.Redstone_Block) {
		Ships.put(Integer.valueOf(152), Boolean.valueOf(false));
	}
	if (ShipsMain.Quartz_Ore) {
		Ships.put(Integer.valueOf(153), Boolean.valueOf(false));
	}
	if (ShipsMain.Quartz_Block) {
		Ships.put(Integer.valueOf(155), Boolean.valueOf(false));
	}
	if (ShipsMain.Quartz_Stairs) {
		Ships.put(Integer.valueOf(156), Boolean.valueOf(false));
	}
	if (ShipsMain.Clay_Stained) {
		Ships.put(Integer.valueOf(159), Boolean.valueOf(false));
	}
	if (ShipsMain.Acacia_Leaves) {
		Ships.put(Integer.valueOf(161), Boolean.valueOf(false));
	}
	if (ShipsMain.Wooden_Acacia) {
		Ships.put(Integer.valueOf(162), Boolean.valueOf(false));
	}
	if (ShipsMain.Wooden_Acacia_Stairs) {
		Ships.put(Integer.valueOf(163), Boolean.valueOf(false));
		Ships.put(Integer.valueOf(164), Boolean.valueOf(false));
	}
	if (ShipsMain.Hay_Bale) {
		Ships.put(Integer.valueOf(170), Boolean.valueOf(false));
	}
	if (ShipsMain.Hardened_Clay) {
		Ships.put(Integer.valueOf(172), Boolean.valueOf(false));
	}
	if (ShipsMain.Coal_Block) {
		Ships.put(Integer.valueOf(173), Boolean.valueOf(false));
	}
	if (ShipsMain.Glass_Pane_Stained) {
		Ships.put(Integer.valueOf(160), Boolean.valueOf(false));
	}
	//Experimental Materials 
	if (ShipsMain.Daylight) {
		Ships.put(Integer.valueOf(151), Boolean.valueOf(false));
	}
	if (ShipsMain.Netherrack) {
		Ships.put(Integer.valueOf(87), Boolean.valueOf(false));
	}
	if (ShipsMain.Iron_Door) {
		Ships.put(Integer.valueOf(71), Boolean.valueOf(false));
	}
	if (ShipsMain.Wool) {
		Ships.put(Integer.valueOf(35), Boolean.valueOf(false));
	}
	if (ShipsMain.Carpet) {
		Ships.put(Integer.valueOf(171), Boolean.valueOf(true));
	}
	if (ShipsMain.Dropper) {
		Ships.put(Integer.valueOf(158), Boolean.valueOf(true));
	}
	if (ShipsMain.Rail_Activtor) {
		Ships.put(Integer.valueOf(157), Boolean.valueOf(true));
	}
	if (ShipsMain.Hopper) {
		Ships.put(Integer.valueOf(154), Boolean.valueOf(true));
	}
	if (ShipsMain.Redstone_Comparator) {
		Ships.put(Integer.valueOf(150), Boolean.valueOf(true));
		Ships.put(Integer.valueOf(149), Boolean.valueOf(false));
	}
	if (ShipsMain.PressurePlate_Weighted_Heavy) {
		Ships.put(Integer.valueOf(148), Boolean.valueOf(false));
	}
	if (ShipsMain.PressurePlate_Weighted_Light) {
		Ships.put(Integer.valueOf(147), Boolean.valueOf(false));
	}
	if (ShipsMain.Stone_PressurePlate) {
		Ships.put(Integer.valueOf(70), Boolean.valueOf(false));
	}
	if (ShipsMain.Chest_Trapped) {
		Ships.put(Integer.valueOf(146), Boolean.valueOf(true));
	}
	if (ShipsMain.Anvil) {
		Ships.put(Integer.valueOf(145), Boolean.valueOf(true));
	}
	if (ShipsMain.Button_Wooden) {
		Ships.put(Integer.valueOf(143), Boolean.valueOf(true));
	}
	if (ShipsMain.Tripwire_Hook) {
		Ships.put(Integer.valueOf(131), Boolean.valueOf(true));
	}
	if (ShipsMain.Flower_Pot) {
		Ships.put(Integer.valueOf(140), Boolean.valueOf(true));
	}
	if (ShipsMain.String) {
		Ships.put(Integer.valueOf(132), Boolean.valueOf(false));
	}
	if (ShipsMain.Button_Stone) {
		Ships.put(Integer.valueOf(77), Boolean.valueOf(true));
	}
	if (ShipsMain.Door_Trap) {
		Ships.put(Integer.valueOf(96), Boolean.valueOf(true));
	}
	if (ShipsMain.Redstone_Torch) {
		Ships.put(Integer.valueOf(76), Boolean.valueOf(true));
		Ships.put(Integer.valueOf(75), Boolean.valueOf(true));
	}
	if (ShipsMain.PresurePlate_Wooden) {
		Ships.put(Integer.valueOf(72), Boolean.valueOf(true));
	}
	if (ShipsMain.Lever) {
		Ships.put(Integer.valueOf(69), Boolean.valueOf(true));
	}
		Ships.put(Integer.valueOf(68), Boolean.valueOf(true));
	if (ShipsMain.Ladder) {
		Ships.put(Integer.valueOf(65), Boolean.valueOf(true));
	}
	if (ShipsMain.Door_Wooden) {
		Ships.put(Integer.valueOf(64), Boolean.valueOf(true));
	}
	if (ShipsMain.Furnace) {
		Ships.put(Integer.valueOf(62), Boolean.valueOf(true));
	    Ships.put(Integer.valueOf(61), Boolean.valueOf(true));
	}
	if (ShipsMain.Redstone) {
		Ships.put(Integer.valueOf(55), Boolean.valueOf(true));
	}
	if (ShipsMain.Chest) {
		Ships.put(Integer.valueOf(54), Boolean.valueOf(true));
	}
	if (ShipsMain.Torch) {
		Ships.put(Integer.valueOf(50), Boolean.valueOf(true));
	}
	if (ShipsMain.Fire) {
		Ships.put(Integer.valueOf(51), Boolean.valueOf(true));
	}
	if (ShipsMain.Bed) {
		Ships.put(Integer.valueOf(26), Boolean.valueOf(true));
	}
}
}

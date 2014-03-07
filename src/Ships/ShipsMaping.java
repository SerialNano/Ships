package Ships;

import java.util.ArrayList;
import java.util.TreeMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Chest;
import org.bukkit.block.Furnace;
import org.bukkit.block.Sign;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShipsMaping
{
  public int LiczbaPaneliS = 0;
  public int LiczbaBlokow = 0;
  public int isFire = 0;
  public int Fuel = 0;
  public int Fuel2 = 0;
  public int Fuel3 = 0;
  public int LiczbaWelny = 0;
  public boolean isFuel = false;
  public boolean isFuel2 = false;
  public boolean isFuel3 = false;
  public TreeMap<String, mapa> blokmap = new TreeMap();
  public ArrayList<Sign> SignList = new ArrayList();
  public String typ;
  public String swiat;
  
  public ShipsMaping(Block blok)
  {
    MapingBlock(blok, this.blokmap, this.LiczbaWelny, this.LiczbaBlokow, this.isFire, this.SignList);
    this.swiat = blok.getLocation().getWorld().getName().toString();
  }
  
  public class furnace
  {
    ItemStack smelting;
    ItemStack fuel;
    ItemStack fuel2;
    ItemStack fuel3;
    ItemStack result;
    
    public furnace(Furnace piecyk)
    {
      ItemStack smelting = piecyk.getInventory().getSmelting();
      ItemStack fuel = piecyk.getInventory().getFuel();
      ItemStack fuel2 = piecyk.getInventory().getFuel();
      ItemStack result = piecyk.getInventory().getResult();
      
      this.smelting = smelting;
      this.fuel = fuel;
      this.fuel2 = fuel2;
      this.result = result;
    }
  }
  
  public class skrzynia
  {
    public ItemStack[] items;
    
    public skrzynia(Chest chest)
    {
        if(ShipsMain.ItemDebug) {
        	ShipsMain.log.info("getting contents of chest");
        }
      ItemStack[] items2 = chest.getInventory().getContents();
      
      this.items = items2;
    }
  }
  
  public class dispenser
  {
    public ItemStack[] dispenseritems;
    
    public dispenser(Dispenser ddispenser)
    {
        if(ShipsMain.ItemDebug) {
        	ShipsMain.log.info("getting contents of dispenser");
        }
      ItemStack[] dispenseritems2 = ddispenser.getInventory().getContents();
      
      this.dispenseritems = dispenseritems2;
    }
  }
  
  public class hopper
  {
    public ItemStack[] hopperitems;
    
    public hopper(Hopper dhopper)
    {
        if(ShipsMain.ItemDebug) {
        	ShipsMain.log.info("getting contents of hopper");
        	ShipsMain.log.info("value of hopper = " + dhopper);
        }
      ItemStack[] hopperitems2 = dhopper.getInventory().getContents();
      
      if(ShipsMain.ItemDebug) {
      	ShipsMain.log.info("hopperitems2 = " + hopperitems2);
      }
      
      this.hopperitems = hopperitems2;
    }
  }
  
  public class mapa
  {
    int id;
    int x;
    int y;
    int z;
    byte data;
    Location lok;
    Sign sign;
    boolean specjal;
    ShipsMaping.furnace furnace;
    ShipsMaping.skrzynia chest;
    ShipsMaping.dispenser vdispenser;
    ShipsMaping.hopper vhopper;
    
    public mapa(int id, byte date, int x, int y, int z, Location lok, Sign sign, boolean specjal, ShipsMaping.furnace piec, ShipsMaping.skrzynia skrz, ShipsMaping.dispenser disp, ShipsMaping.hopper hopr)
    {
      this.data = date;
      this.id = id;
      this.x = x;
      this.y = y;
      this.z = z;
      this.lok = lok;
      this.sign = sign;
      this.specjal = specjal;
      this.furnace = piec;
      this.chest = skrz;
      this.vdispenser = disp;
      this.vhopper = hopr;
    }
  }
  
  public void MapingBlock(Block blok, TreeMap<String, mapa> blokmap, int LiczbaWelny, int LiczbaBlokow, int isFire, ArrayList<Sign> SignList)
  {
    int id = blok.getTypeId();
    byte data = blok.getData();
    int x = blok.getLocation().getBlockX();
    int y = blok.getLocation().getBlockY();
    int z = blok.getLocation().getBlockZ();
    if (blok.getType().equals(Material.WOOL)) {
      this.LiczbaWelny += 1;
    }
    if (blok.getType().equals(Material.DAYLIGHT_DETECTOR)) {
      this.LiczbaPaneliS += 1;
    }
    if (blok.getType().equals(Material.FIRE)) {
      this.isFire += 1;
    }
    if ((blok.getType().equals(Material.SIGN_POST)) || (blok.getType().equals(Material.WALL_SIGN)))
    {
      Sign znak = (Sign)blok.getState();
      this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), znak, true, null, null, null, null));
      this.SignList.add(znak);
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && (znak.getLine(1).equals(ChatColor.BLUE + "ship"))) {
        this.typ = "ship";
        if(ShipsMain.VesselDebug){
        	ShipsMain.log.info("ship master sign found");
        }
      }
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && (znak.getLine(1).equals(ChatColor.BLUE + "airship"))) {
        this.typ = "airship";
        if(ShipsMain.VesselDebug){
        	ShipsMain.log.info("airship master sign found");
        }
      }
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && (znak.getLine(1).equals(ChatColor.BLUE + "marsship"))) {
        this.typ = "marsship";
      }
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && (znak.getLine(1).equals(ChatColor.BLUE + "airship2"))) {
        this.typ = "airship2";
      }
      if ((znak.getLine(0).equals(ChatColor.YELLOW + "[Ships]")) && (znak.getLine(1).equals(ChatColor.BLUE + "plane"))) {
        this.typ = "plane";
      }
    }
    if ((blok.getType().equals(Material.FURNACE)) || (blok.getType().equals(Material.BURNING_FURNACE)))
    {
      Furnace piecyk = (Furnace)blok.getState();
      if (piecyk.getInventory().getFuel() != null) {
        if ((piecyk.getInventory().getFuel().getTypeId() == ShipsMain.AirShipFuelId) || (piecyk.getInventory().getFuel().getTypeId() == ShipsMain.AirShipFuelIdAlt))
        {
            if(ShipsMain.ItemDebug){
            	ShipsMain.log.info("found fuel id at" + ShipsMain.AirShipFuelId + "and altfuel at" + ShipsMain.AirShipFuelIdAlt);
            }
          this.Fuel += piecyk.getInventory().getFuel().getAmount();
          if (!this.isFuel)
          {
            this.isFuel = true;
            if (piecyk.getInventory().getFuel().getAmount() > 1) {
                if(ShipsMain.ItemDebug){
                	ShipsMain.log.info("checking amount of fuel in furnace");
                }
              piecyk.getInventory().setFuel(new ItemStack(piecyk.getInventory().getFuel().getType(), piecyk.getInventory().getFuel().getAmount() - 1));
            } else {
              piecyk.getInventory().setFuel(null);
            }
          }
        }
      }
      if (piecyk.getInventory().getFuel() != null) {
          if ((piecyk.getInventory().getFuel().getTypeId() == ShipsMain.PlaneFuelId) || (piecyk.getInventory().getFuel().getTypeId() == ShipsMain.PlaneFuelIdAlt))
          {
            if(ShipsMain.ItemDebug){
            	ShipsMain.log.info("found fuel id at" + ShipsMain.PlaneFuelId + "and altfuel at" + ShipsMain.PlaneFuelIdAlt);
            }
            this.Fuel3 += piecyk.getInventory().getFuel().getAmount();
            if (!this.isFuel3)
            {
              this.isFuel3 = true;
              if (piecyk.getInventory().getFuel().getAmount() > ShipsMain.PlaneFuelConsumption) {
                  if(ShipsMain.ItemDebug){
                  	ShipsMain.log.info("checking amount of fuel in furnace");
                  }
                piecyk.getInventory().setFuel(new ItemStack(piecyk.getInventory().getFuel().getType(), piecyk.getInventory().getFuel().getAmount() - ShipsMain.PlaneFuelConsumption));
              } else {
                piecyk.getInventory().setFuel(null);
              }
            }
          }
        }
        if (piecyk.getInventory().getFuel() != null) {
            if ((piecyk.getInventory().getFuel().getTypeId() == ShipsMain.AirShip2FuelId) || (piecyk.getInventory().getFuel().getTypeId() == ShipsMain.AirShip2FuelIdAlt))
            {
              this.Fuel2 += piecyk.getInventory().getFuel().getAmount();
              if (!this.isFuel2){
                this.isFuel2 = true;
                if (piecyk.getInventory().getFuel().getAmount() > ShipsMain.AirShip2FuelConsumption) {
                  piecyk.getInventory().setFuel(new ItemStack(piecyk.getInventory().getFuel().getType(), piecyk.getInventory().getFuel().getAmount() - ShipsMain.AirShip2FuelConsumption));
                } else {
                  piecyk.getInventory().setFuel(null);
                }
              }
            }
          }
      this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, true, new furnace(piecyk), null, null, null));
    }
    if (blok.getType().equals(Material.CHEST)) {
      this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, true, null, new skrzynia((Chest)blok.getState()), null, null));
    }
    if (blok.getType().equals(Material.DISPENSER)) {
    	if(ShipsMain.ItemDebug) {
    		ShipsMain.log.info("dispenser new mapa");
    	}
      this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, true, null, null, new dispenser((Dispenser)blok.getState()), null));
    }
    if (blok.getType().equals(Material.HOPPER)) {
      this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, true, null, null, null, new hopper((Hopper)blok.getState())));
    }
    if (Bloki.Ships.containsKey(Integer.valueOf(id)))
    {
      if (!((Boolean)Bloki.Ships.get(Integer.valueOf(id))).booleanValue()) {
        this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, false, null, null, null, null));
      } else if (id != Material.SIGN_POST.getId()) {
        if (id != Material.WALL_SIGN.getId()) {
          if (id != Material.FURNACE.getId()) {
            if (id != Material.BURNING_FURNACE.getId()) {
              if (id != Material.CHEST.getId()) {
            	if (id != Material.DISPENSER.getId()){
            	  if (id != Material.HOPPER.getId()) {
                this.blokmap.put("X" + x + "Y" + y + "Z" + z, new mapa(id, data, x, y, z, blok.getLocation(), null, true, null, null, null, null));
            	  }
                }
              }
            }
          }
        }
      }
      this.LiczbaBlokow += 1;
    }
    if ((blok.getLocation().getY() < 62.0D) && (blok.getRelative(0, 1, 0).getType().equals(Material.AIR)))
    {
      int b = 1;
      for (double a2 = blok.getLocation().getY(); a2 < 62.0D; a2 += 1.0D)
      {
        if (!blok.getRelative(0, b, 0).getType().equals(Material.AIR)) {
          break;
        }
        int id2 = blok.getRelative(0, b, 0).getTypeId();
        byte data2 = blok.getRelative(0, b, 0).getData();
        int y2 = blok.getRelative(0, b, 0).getLocation().getBlockY();
        
        this.blokmap.put("X" + x + "Y" + y2 + "Z" + z, new mapa(id2, data2, x, y2, z, blok.getLocation(), null, false, null, null, null, null));
        b++;
      }
    }
    for (int X = -1; X < 2; X++) {
      for (int Y = -1; Y < 2; Y++) {
        for (int Z = -1; Z < 2; Z++) {
          if (blok.getRelative(X, Y, Z).getTypeId() != Material.AIR.getId()) {
            if (!blokmap.containsKey("X" + blok.getRelative(X, Y, Z).getX() + "Y" + blok.getRelative(X, Y, Z).getY() + "Z" + blok.getRelative(X, Y, Z).getZ())) {
              if (Bloki.Ships.containsKey(Integer.valueOf(blok.getRelative(X, Y, Z).getTypeId()))) {
                MapingBlock(blok.getRelative(X, Y, Z), blokmap, LiczbaWelny, LiczbaBlokow, isFire, SignList);
              }
            }
          }
        }
      }
    }
  }
    
  static boolean searchUserInShip(ArrayList tablica, Block blok)
  {
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        for (int z = -1; z <= 1; z++) {
          for (int a = 0; tablica.size() > a; a++)
          {
            Block blok1 = (Block)tablica.get(a);
            if ((blok.getRelative(x, y, z).getLocation().getBlockX() == blok1.getLocation().getBlockX()) && 
              (blok.getRelative(x, y, z).getLocation().getBlockY() == blok1.getLocation().getBlockY()) && 
              (blok.getRelative(x, y, z).getLocation().getBlockZ() == blok1.getLocation().getBlockZ())) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}

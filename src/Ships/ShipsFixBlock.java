package Ships;

public class ShipsFixBlock
  extends ShipsMain
{
  static byte blockFix(int id, byte data, String kierunek)
  {
    if (id == 65) {
        if(RotateDebug){
        	ShipsMain.log.info("running ladder fix");
        }
      return LaddersFix(data, kierunek);
    }
    if (id == 58) {
        if(RotateDebug){
        	ShipsMain.log.info("running WorkBenchfix");
        }
      return CraftingTableFix(data, kierunek);
    }
    if (id == 63) {
        if(RotateDebug){
        	ShipsMain.log.info("running sign fix");
        }
      return SignFix(data, kierunek);
    }
    if (id == 68) {
        if(RotateDebug){
        	ShipsMain.log.info("running wallsign fix");
        }
      return WallSignFix(data, kierunek);
    }
    if ((id == 50) || (id == 76) || (id == 75)) {
        if(RotateDebug){
        	ShipsMain.log.info("running torchfix");
        }
      return TorchFix(data, kierunek);
    }
    if ((id == 53) || (id == 108) || (id == 128) || (id == 134) || (id == 135) || (id == 136) || (id == 114) || (id == 156) || (id == 163) || (id == 164)) {
        if(RotateDebug){
        	ShipsMain.log.info("running stairfix");
        }
      return StairsFix(data, kierunek);
    }
    if ((id == 17) || id == 162) {
        if(RotateDebug){
        	ShipsMain.log.info("running logfix");
        }
      return WoodFix(data);
    }
    if ((id == 154)) {
        if(RotateDebug){
        	ShipsMain.log.info("running Hopperfix");
        }
      return HopperFix(data, kierunek);
    }
    if ((id == 61) || (id == 62)) {
        if(RotateDebug){
        	ShipsMain.log.info("running furnacefix");
        }
      return FurnaceFix(data, kierunek);
    }
    if (id == 145) {
        if(RotateDebug){
        	ShipsMain.log.info("running anvilfix");
        }
      return AnvilFix(data);
    }
    if ((id == 143) || (id == 77)) {
        if(RotateDebug){
        	ShipsMain.log.info("running buttonfix");
        }
      return ButtonFix(data, kierunek);
    }
    if ((id == 33) || (id == 29)) {
        if(RotateDebug){
        	ShipsMain.log.info("running pistonfix - half");
        }
      return PistonFix(data, kierunek);
    }
    if ((id == 130)) {
        if(RotateDebug){
        	ShipsMain.log.info("running enderchestfix");
        }
     return EnderChestFix(data, kierunek);
    }
    if ((id == 93) || (id == 94) || (id == 150 || id == 149)) {
        if(RotateDebug){
        	ShipsMain.log.info("running half a redstonerepeaterfix");
        }
     return RedstoneRepeaterFix(data, kierunek);
    }
    if ((id == 107)) {
        if(RotateDebug){
        	ShipsMain.log.info("running gatefix");
        }
     return GateFix(data);
    }
    if ((id == 324) || (id == 330)) {
        if(RotateDebug){
        	ShipsMain.log.info("running doorfix");
        }
     return DoorFix(data);	
    }
    if ((id == 23)) {
        if(RotateDebug){
        	ShipsMain.log.info("running dispenserfix");
        }
      return DispenserFix(data, kierunek);	
    }
    if ((id == 96)) {
        if(RotateDebug){
        	ShipsMain.log.warning("failed running trapdoor fix");
        }
      return TrapDoorFix(data, kierunek);	
    }
    if ((id == 131)) {
        if(RotateDebug){
        	ShipsMain.log.warning("failed running TripWireHookfix");
        }
      return TripWireHookFix(data, kierunek);	
    }
  return data;
}
  
  public static byte TorchFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 3) {
        return 2;
      }
      if (data == 2) {
        return 4;
      }
      if (data == 4) {
        return 1;
      }
      if (data == 1) {
        return 3;
      }
    }
    else
    {
      if (data == 3) {
        return 1;
      }
      if (data == 1) {
        return 4;
      }
      if (data == 4) {
        return 2;
      }
      if (data == 2) {
        return 3;
      }
    }
    return data;
  }
  
  static byte StairsFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 0) {
        return 2;
      }
      if (data == 1) {
        return 3;
      }
      if (data == 2) {
        return 1;
      }
      if (data == 3) {
        return 0;
      }
      if (data == 6) {
        return 5;
      }
      if (data == 5) {
        return 7;
      }
      if (data == 7) {
        return 4;
      }
      if (data == 4) {
        return 6;
      }
    }
    else
    {
      if (data == 0) {
        return 3;
      }
      if (data == 1) {
        return 2;
      }
      if (data == 2) {
        return 0;
      }
      if (data == 3) {
        return 1;
      }
      if (data == 6) {
        return 4;
      }
      if (data == 4) {
        return 7;
      }
      if (data == 7) {
        return 5;
      }
      if (data == 5) {
        return 6;
      }
    }
    return data;
  }
  
  static byte WoodFix(byte data)
  {
    if (data == 4) {
      return 8;
    }
    if (data == 8) {
      return 4;
    }
    if (data == 5) {
      return 9;
    }
    if (data == 9) {
      return 5;
    }
    if (data == 6) {
      return 10;
    }
    if (data == 10) {
      return 6;
    }
    if (data == 7) {
      return 11;
    }
    if (data == 11) {
      return 7;
    }
    return data;
  }
  
  static byte FurnaceFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 2) {
	        return 5;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 5) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	    }
	    else
	    {
	      if (data == 5) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 3) {
	        return 5;
	      }
	      if (data == 4) {
	        return 3;
	      }
	    }
	    return data;
	  }
  
  static byte CraftingTableFix(byte data, String kierunek)
  {
	    if (kierunek.equals("left"))
	    {
	      if (data == 1) {
	        return 2;
	      }
	      if (data == 2) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	      if (data == 4) {
	        return 1;
	      }
	    }
	    else
	    {
	      if (data == 1) {
	        return 4;
	      }
	      if (data == 4) {
	        return 3;
	      }
	      if (data == 3) {
	        return 2;
	      }
	      if (data == 2) {
	        return 1;
	      }
	    }
	    return data;
	  }
  
  static byte HopperFix(byte data, String kierunek)
  {
     if (kierunek.equals("right"))
	 {
	      if (data == 2) {
	        return 5;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 5) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	    }
	    else
	    {
	      if (data == 5) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 3) {
	        return 5;
	      }
	      if (data == 4) {
	        return 3;
	      }
	    }
	    return data;
	  }


  static byte DispenserFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 2) {
	        return 5;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 5) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	    }
	    else
	    {
	      if (data == 5) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 3) {
	        return 5;
	      }
	      if (data == 4) {
	        return 3;
	      }
	    }
	    return data;
	  }

  
  static byte PistonFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 2) {
	        return 5;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 5) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	    }
	    else
	    {
	      if (data == 5) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 3) {
	        return 5;
	      }
	      if (data == 4) {
	        return 3;
	      }
	    }
	    return data;
	  }
  
  static byte SignFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 0) {
        return 4;
      }
      if (data == 4) {
        return 8;
      }
      if (data == 8) {
        return 12;
      }
      if (data == 12) {
        return 0;
      }
      if (data == 14) {
        return 2;
      }
      if (data == 10) {
        return 14;
      }
      if (data == 6) {
        return 10;
      }
      if (data == 2) {
        return 6;
      }
    }
    else
    {
      if (data == 4) {
        return 0;
      }
      if (data == 8) {
        return 4;
      }
      if (data == 12) {
        return 8;
      }
      if (data == 0) {
        return 12;
      }
      if (data == 2) {
        return 14;
      }
      if (data == 14) {
        return 10;
      }
      if (data == 10) {
        return 6;
      }
      if (data == 6) {
        return 2;
      }
    }
    return 100;
  }
  
  static byte WallSignFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 2) {
        return 5;
      }
      if (data == 4) {
        return 2;
      }
      if (data == 5) {
        return 3;
      }
      if (data == 3) {
        return 4;
      }
    }
    else
    {
      if (data == 5) {
        return 2;
      }
      if (data == 2) {
        return 4;
      }
      if (data == 3) {
        return 5;
      }
      if (data == 4) {
        return 3;
      }
    }
    return data;
  }
  
  static byte TripWireHookFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 2) {
        return 5;
      }
      if (data == 4) {
        return 2;
      }
      if (data == 5) {
        return 3;
      }
      if (data == 3) {
        return 4;
      }
    }
    else
    {
      if (data == 5) {
        return 2;
      }
      if (data == 2) {
        return 4;
      }
      if (data == 3) {
        return 5;
      }
      if (data == 4) {
        return 3;
      }
    }
    return data;
  }
  
  static byte TrapDoorFix(byte data, String kierunek)
  {
	     if (data == 5) {
	       return 8;
	     }
	     if (data == 6) {
	       return 7;
	     }
	     if (data == 7) {
	       return 6;
	     }
	     if (data == 8) {
	       return 7;
	     }
	     if (data == 1) {
	       return 4;
	     }
	     if (data == 4) {
	       return 1;
	     }
         if (data == 2) {
          return 3;
         }
         if (data == 3) {
          return 2;	 
         }
		  return data;
	    }
  
  static byte LaddersFix(byte data, String kierunek)
  {
    if (kierunek.equals("right"))
    {
      if (data == 4) {
        return 2;
      }
      if (data == 2) {
        return 5;
      }
      if (data == 5) {
        return 3;
      }
      if (data == 3) {
        return 4;
      }
    }
    else
    {
      if (data == 2) {
        return 4;
      }
      if (data == 5) {
        return 2;
      }
      if (data == 3) {
        return 5;
      }
      if (data == 4) {
        return 3;
      }
    }
    return data;
  }
  
  static byte AnvilFix(byte data)
  {
    if (data == 1) {
      return 2;
    }
    if (data == 2) {
      return 1;
    }
    if (data == 4) {
      return 7;
    }
    if (data == 7) {
      return 4;
    }
    if (data == 8) {
      return 11;
    }
    if (data == 11) {
      return 8;
    }
    return data;
  }
  
  static byte EnderChestFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 2) {
	        return 5;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 5) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	    }
	    else
	    {
	      if (data == 5) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 3) {
	        return 5;
	      }
	      if (data == 4) {
	        return 3;
	      }
	    }
	    return data;
	  }
  
  static byte RedstoneRepeaterFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 1) {
	        return 2;
	      }
	      if (data == 2) {
	        return 3;
	      }
	      if (data == 3) {
	        return 4;
	      }
	      if (data == 4) {
	        return 1;
	      }
	      if (data == 5) {
	    	return 6;
	      }
	      if (data == 6) {
	    	return 7;
	      }
	      if (data == 7) {
	    	return 8;
	      }
	      if (data == 8) {
	    	return 6;
	      }
	      if (data == 9) {
	    	return 10;
	      }
	      if (data == 10) {
	    	return 11;
	      }
	      if (data == 11) {
	    	return 12;
	      }
	      if (data == 12) {
	    	return 9;
	      }
	      if (data == 13) {
	    	return 14;
	      }
	      if (data == 14) {
	    	return 15;
	      }
	      if (data == 15) {
	    	return 16;
	      }
	      if (data == 16) {
	    	return 13;
	      }
	    }
	    else
	    {
	      if (data == 1) {
	        return 4;
	      }
	      if (data == 2) {
	        return 1;
	      }
	      if (data == 3) {
	        return 2;
	      }
	      if (data == 4) {
	        return 3;
	      }
	      if (data == 5) {
	    	return 8;
	      }
	      if (data == 6) {
	    	return 5;
	      }
	      if (data == 7) {
	    	return 6;
	      }
	      if (data == 8) {
	    	return 5;
	      }
	      if (data == 9) {
	    	return 12;
	      }
	      if (data == 10) {
	    	return 9;
	      }
	      if (data == 11) {
	    	return 10;
	      }
	      if (data == 12) {
	    	return 11;
	      }
	      if (data == 13) {
	    	return 16;
	      }
	      if (data == 14) {
	    	return 13;
	      }
	      if (data == 15) {
	    	return 14;
	      }
	      if (data == 16) {
	    	return 15;
	      }
	    }
	    return data;
	  }
    
  static byte GateFix(byte data)
  {
	     if (data == 5) {
	       return 8;
	     }
	     if (data == 6) {
	       return 7;
	     }
	     if (data == 7) {
	       return 6;
	     }
	     if (data == 8) {
	       return 7;
	     }
	     if (data == 1) {
	       return 4;
	     }
	     if (data == 4) {
	       return 1;
	     }
         if (data == 2) {
           return 3;
         }
         if (data == 3) {
           return 2;	 
         }
		return data;
	  }
    
  static byte DoorFix(byte data)
  {
	     if (data == 5) {
	       return 8;
	     }
	     if (data == 6) {
	       return 7;
	     }
	     if (data == 7) {
	       return 6;
	     }
	     if (data == 8) {
	       return 7;
	     }
	     if (data == 1) {
	       return 4;
	     }
	     if (data == 4) {
	       return 1;
	     }
         if (data == 2) {
           return 3;
         }
         if (data == 3) {
           return 2;	 
         }
		return data;
	  }
  
  static byte ButtonFix(byte data, String kierunek)
  {
	    if (kierunek.equals("right"))
	    {
	      if (data == 3) {
	        return 2;
	      }
	      if (data == 2) {
	        return 4;
	      }
	      if (data == 4) {
	        return 1;
	      }
	      if (data == 1) {
	        return 3;
	      }
	    }
	    else
	    {
	      if (data == 3) {
	        return 1;
	      }
	      if (data == 1) {
	        return 4;
	      }
	      if (data == 4) {
	        return 2;
	      }
	      if (data == 2) {
	        return 3;
	      }
	    }
	    return data;
	  }
}

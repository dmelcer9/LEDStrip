package ledstrip;

import java.util.Arrays;

public class Layer{

	protected int[] leds;			//color (indexed to ColorProfile)
	protected boolean[] ledon;		//if the led is set, or passes through
	
	public Layer(int size){
		leds = new int[size]; 
		ledon = new boolean[size];
		Arrays.fill(leds, 0);
		Arrays.fill(ledon, false);
	}
	
	public void setLedIndex(int index, int color, boolean set){
		leds[index] = color;  //Sets each led by index
		ledon[index] = set;
	}
	
	public int getColorIndex(int index){
		return leds[index];		//Gets each color by index
	}
	
	public boolean getSetIndex(int index){
		return ledon[index];	//Gets each setting by index
	}
	
	public void setLedAll(int[] colors, boolean[] set){
		leds = colors;			//Sets raw arrays
		ledon = set;
	}
	
	public int[] getColorAll(){
		return leds;			//Gets raw color array
	}
	
	public boolean[] getSetAll(){
		return ledon;			//Gets raw set array
	}
}

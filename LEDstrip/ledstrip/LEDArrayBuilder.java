package ledstrip;

import java.util.Arrays;

public class LEDArrayBuilder {
	
	//Declare vars
	int[] colorarray; //Where colors are stored
	ColorProfile cp;  //ColorProfile storage
	Layer[] layers;   //Contains 8 layers
	boolean changed = true; //Tracks changes to save cpu cycles
	

	public LEDArrayBuilder(int size, ColorProfile colorprofile){
		
		colorarray = new int[size]; //init arrays
		layers = new Layer[8];
		setColorProfile(colorprofile);
	}
	
	public void setColorProfile(ColorProfile colorprofile){
		cp = colorprofile;	//sets profile
		changed = true;		//starts tracking
	}
	
	public void execute(LayerGenerator layergenerator){
		layergenerator.setParams(cp,colorarray.length);					//provides information to LayerGenerator
		layers[layergenerator.getLayerNum()] = layergenerator.run();	//executes layergenerator using preferred layer
		changed = true;													//starts tracking
	}
	
	public int[] getHexArray(){
		if (!changed) return colorarray;	//if no change, return previous result
		
		boolean[] hascolor = new boolean[colorarray.length]; //temporary array for priority
		Arrays.fill(hascolor, false);						//no leds have been set yet
		
		for(int i = 7; i>=-1; i--){							//for each layer
			for(int j = 0; j<colorarray.length; j++){		//for each led
				if(!hascolor[j]){							//if not set yet
					if(i == -1){							
						colorarray[j] = -1;					//if on layer -1, set remaining to -1
					}
					else if(layers[i].getSetIndex(j)){		//otherwise, set to color defined in layer
						colorarray[j] = layers[i].getColorIndex(j);
						hascolor[j] = true;					//mark as set
					}
				}
			}
		}
		
		for(int i = 0; i<colorarray.length; i++){			//for each led
			if(colorarray[i] != -1)							//on most color indexes, 
															//fill led with color from the ColorProfile
				colorarray[i] = cp.getColorIndex(colorarray[i]);
			else											//if it equals -1, set the color to 0
				colorarray[i] = 0x0;
		}
		
		changed = false;									//stop tracking
		return colorarray;									//return result
	}
}

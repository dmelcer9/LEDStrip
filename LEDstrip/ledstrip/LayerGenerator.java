package ledstrip;

public abstract class LayerGenerator {
	
	protected ColorProfile cp;
	protected int lednum;

	public void setParams(ColorProfile colorprofile, int numberOfLEDs){
		cp = colorprofile;			//This information is optional, but may be 
		lednum = numberOfLEDs;		//useful depending on the type of program		
	}
	
	public abstract int getLayerNum(); //The program will call this immediately before calling run()
	
	public abstract Layer run();	   //Generates a layer for use in the rest of the program
}

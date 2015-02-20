package ledstrip;



public class ColorProfile {
	
	protected int[] colors;

	public ColorProfile(int... hexvals){
		
		colors = hexvals; //array "colors" are equal to the parameters, in order
		
	}
	
	public int getLength(){
		return colors.length; //getting length
	}
	
	public int getColorIndex(int index) throws ArrayIndexOutOfBoundsException{
		try{
			return colors[index];	//gets colors at a specific index
		} catch (ArrayIndexOutOfBoundsException ex){
			System.out.println("Error: Tried to access non-existent color");
			throw ex;	//prints error message, then throws the error
		}
	}
	
	public int[] getRawColors(){
		return colors;	//returns raw array
	}
	
}

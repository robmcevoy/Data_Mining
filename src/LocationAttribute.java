// Attribute representing location of attribute
// splits the UK into 7 parts using latitude
// when a value is being set it calculates which of the 7 parts the input(latitude) belongs to

public class LocationAttribute extends Attribute{
	
	private final static int[] locationPossibleValues = {1,2,3,4,5,6,7};	
	private double[] latitudeRange ={51.0, 52.0, 53.0, 54.0, 55.0, 56.0};
	private final int DEFAULT_VALUE= 4;
	
	public LocationAttribute(String name, int index) {
		super(name, index, locationPossibleValues);
	}

	public void setValue(String value) {
		try{
			int newValue;
			double latitude = Double.parseDouble(value);
			
			if(latitude <= latitudeRange[0]){
				newValue = locationPossibleValues[0];
			}
			else if((latitude > latitudeRange[0]) && (latitude < latitudeRange[1])){
				newValue = locationPossibleValues[1];
			}
			else if((latitude > latitudeRange[1]) && (latitude < latitudeRange[2])){
				newValue = locationPossibleValues[2];
			}
			else if((latitude > latitudeRange[2]) && (latitude < latitudeRange[3])){
				newValue = locationPossibleValues[3];
			}
			else if((latitude > latitudeRange[3]) && (latitude < latitudeRange[4])){
				newValue = locationPossibleValues[4];
			}
			else if((latitude > latitudeRange[4]) && (latitude < latitudeRange[5])){
				newValue = locationPossibleValues[5];
			}
			else{
				newValue = locationPossibleValues[6];
			}
			this.value = newValue;

		}
		catch(Exception e){
			this.value = locationPossibleValues[DEFAULT_VALUE];
		}	
	}
}
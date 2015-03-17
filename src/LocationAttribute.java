public class LocationAttribute extends Attribute{
	
	private final static int[] locationPossibleValues = {1,2,3};
	//55.528639, -3.373277
	//55.466407, -2.296617
	
	private double[] longitudeRange ={-3.373277, -2.296617};
	
	public LocationAttribute(String name, int index) {
		super(name, index, locationPossibleValues);
	}

	@Override
	public void setValue(String value) {
		try{
			int newValue;
			double longitude = Double.parseDouble(value);
			if(longitude > longitudeRange[0]){
				newValue = locationPossibleValues[0];
			}
			else if((longitude< longitudeRange[0]) && (longitude > longitudeRange[1])){
				newValue = locationPossibleValues[1];
			}
			else{
				newValue = locationPossibleValues[2];
			}
			this.value = newValue;
		}
		catch(Exception e){
			this.value = locationPossibleValues[0];
		}	
	}
}
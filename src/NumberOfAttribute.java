// Used to represent attributes 'Number of Vehicles' & 'Number of Casualties'
// Attribute has 7 possible values
// If the input is greater than 6 it is assigned into the last possible value
// the majority of the data is between 0 and 6

public class NumberOfAttribute extends Attribute{
	private final static int[] numberOfPossibleValues = {1,2,3,4,5,6,7};
	private final int[] ranges = {1,2,3,4,5,6};
	private final int DEFAULT_VALUE= 0;
	
	public NumberOfAttribute(String name, int index) {
		super(name, index, numberOfPossibleValues);
	}

	@Override
	public void setValue(String valueString) {
		int numberOf;
		int newValue = -1;
		try{
			numberOf = Integer.parseInt(valueString);
			if(numberOf <= ranges[0]){
				newValue = numberOfPossibleValues[DEFAULT_VALUE];
			}
			else{
				for(int i=0; i<ranges.length-1; i++){
					if((numberOf > ranges[i]) || (numberOf <= ranges[i+1])){
						newValue = numberOfPossibleValues[i+1];
						i = ranges.length;
					}
				}
			}
			if(newValue == -1){
				newValue = numberOfPossibleValues[numberOfPossibleValues.length-1];
			}
			this.value = newValue;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
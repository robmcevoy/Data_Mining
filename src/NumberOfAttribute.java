
public class NumberOfAttribute extends Attribute{
	private final static int[] numberOfPossibleValues = {1,2,3,4,5,6,7};
	private final int[] ranges = {1,2,3,4,5,6};
	
	public NumberOfAttribute(String name, int index) {
		super(name, index, numberOfPossibleValues);
	}

	public void setValue(String valueString) {
		int numberOf;
		int newValue = -1;
		try{
			numberOf = Integer.parseInt(valueString);
			if(numberOf <= ranges[0]){
				newValue = numberOfPossibleValues[0];
			}
			else{
				for(int i=0; i<ranges.length-1; i++){
					if((numberOf > ranges[i]) || (numberOf <= ranges[i+1])){
						newValue = numberOfPossibleValues[i+1];
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
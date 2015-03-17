
public class NumberOfAttribute extends Attribute{
	
	private final static int[] numberOfPossibleValues = {1,2,3};
	private final int[] ranges = {2,5};
	
	public NumberOfAttribute(String name, int index) {
		super(name, index, numberOfPossibleValues);
	}

	public void setValue(String valueString) {
		int numberOf;
		int newValue;
		try{
			numberOf = Integer.parseInt(valueString);
			if(numberOf <= ranges[0]){
				newValue = numberOfPossibleValues[0];
			}
			else if((numberOf > ranges[0]) || (numberOf <= ranges[1])){
				newValue = numberOfPossibleValues[1];
			}
			else{
				newValue = numberOfPossibleValues[2];
			}
			this.value = newValue;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

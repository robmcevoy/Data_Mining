// Attribute representing time
// Takes an input in the format HH:MM
// Attribute does not consider minutes
// Times are mapped into one 24 possible values which represent 24 hours a day

public class TimeAttribute extends Attribute{
	
	private final static int[] timePossibleValues = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};

	public TimeAttribute(String name, int index) {
		super(name, index, timePossibleValues);
	}

	@Override
	public void setValue(String valueString) {
		int newValue = -1;
		try{
			String hourString = valueString.substring(0,2);
			int hour = Integer.parseInt(hourString);
			
			for(int i=0; i<timePossibleValues.length; i++){
				if(hour == timePossibleValues[i]){
					newValue = timePossibleValues[i];
					i = timePossibleValues.length;
				}
			}
			if(newValue == -1){
				newValue = timePossibleValues[0];
			}
			this.value = newValue;
		}
		catch(Exception e){
			// unparseable date
			newValue = timePossibleValues[0];
			this.value = newValue;
		}	
	}	
}

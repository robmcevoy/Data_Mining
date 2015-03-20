// Attribute represents the month the accident occurred in
// Parses dates of format DD/MM/YY

public class MonthAttribute extends Attribute {
	
	private static int[] monthPossibleValues = {1,2,3,4,5,6,7,8,9,10,11,12};
	private final int STRING_START_INDEX = 3;
	private final int STRING_END_INDEX = 5;
	private final int DEFAULT_VALUE= 0;
	
	public MonthAttribute(String name, int index){
		super(name, index, monthPossibleValues);
	}

	public void setValue(String value) {
		try{
			int newValue = -1;
			String monthString = value.substring(STRING_START_INDEX, STRING_END_INDEX);
			int month = Integer.parseInt(monthString);
			for(int i=0; i<monthPossibleValues.length; i++){
				if(month == monthPossibleValues[i]){
					newValue = monthPossibleValues[i];
				}
			}
			if(newValue == -1){
				newValue = monthPossibleValues[DEFAULT_VALUE];
			}
			this.value = newValue;
		}
		catch(Exception e){
			this.value = monthPossibleValues[DEFAULT_VALUE];
		}
	}
}
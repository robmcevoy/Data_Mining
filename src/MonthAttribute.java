public class MonthAttribute extends Attribute {
	
	private static int[] monthPossibleValues = {1,2,3,4,5,6,7,8,9,10,11,12};
	
	public MonthAttribute(String name, int index){
		super(name, index, monthPossibleValues);
	}

	public void setValue(String value) {
		try{
			int newValue = -1;
			String monthString = value.substring(3, 5);
			int month = Integer.parseInt(monthString);
			for(int i=0; i<monthPossibleValues.length; i++){
				if(month == monthPossibleValues[i]){
					newValue = monthPossibleValues[i];
				}
			}
			if(newValue == -1){
				newValue = monthPossibleValues[0];
			}
			this.value = newValue;
		}
		catch(Exception e){
			this.value = monthPossibleValues[0];
		}
	}
}
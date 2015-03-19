// Represents the Day of the month the accident occurred

public class DayAttribute extends Attribute {

	private static int[] dayPossibleValues = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,
												17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	
	public DayAttribute(String name, int index){
		super(name, index, dayPossibleValues);
	}

	@Override
	public void setValue(String value) {
		try{
			int newValue = -1;
			String dayString = value.substring(0,2);
			int day = Integer.parseInt(dayString);
			for(int i=0; i<dayPossibleValues.length; i++){
				if(day == dayPossibleValues[i]){
					newValue =  dayPossibleValues[i];
					i = dayPossibleValues.length;
				}
			}
			if(newValue == -1){
				newValue = dayPossibleValues[0];
			}
			this.value = newValue;
		}
		catch(Exception e){
			this.value = dayPossibleValues[0];
		}
	}
}

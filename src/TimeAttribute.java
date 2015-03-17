import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAttribute extends Attribute{
	
	private Date[] timeRanges;
	private final SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
	private final static int[] timePossibleValues = {1,2,3};

	public TimeAttribute(String name, int index) {
		super(name, index, timePossibleValues);
		try{
			Date date1 = formatter.parse("08:00");
			Date date2 = formatter.parse("16:00");
			timeRanges = new Date[2];
			timeRanges[0] = date1;
			timeRanges[1] = date2;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void setValue(String valueString) {
		int newValue;
		try{
			Date dateValue = formatter.parse(valueString);
			if(dateValue.before(timeRanges[0])){
				newValue = timePossibleValues[0];
			}
			else if((dateValue.equals(timeRanges[0])) || (dateValue.before(timeRanges[1]))){
				newValue = timePossibleValues[1];
			}
			else{
				newValue = timePossibleValues[2];
			}
			this.value = newValue;
		}
		catch(Exception e){
			// unparseable date
			newValue = possibleValues[0];
			this.value = newValue;
		}	
	}	
}

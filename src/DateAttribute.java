import java.text.SimpleDateFormat;
import java.util.Date;


public class DateAttribute extends Attribute {
	
	private Date[] dateRanges;
	private static int[] datePossibleValues = {1,2,3};
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy");
	
	public DateAttribute(String name, int index){
		super(name, index, datePossibleValues);
		try{
			Date date = formatter.parse("01/05/05");
			Date date1 = formatter.parse("01/09/05");
			dateRanges = new Date[2];
			dateRanges[0] = date;
			dateRanges[1] = date1;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setValue(String value) {
		try{
			Date newDate = formatter.parse(value);
			int newValue;
			if((newDate.before(dateRanges[0])) || (newDate.equals(dateRanges[0]))){
				newValue = datePossibleValues[0];
			}
			else if((newDate.after(dateRanges[0])) && (newDate.before(dateRanges[1]))){
				newValue = datePossibleValues[1];
			}
			else{
				newValue = datePossibleValues[2];
			}
			this.value = newValue;
		}
		catch(Exception e){
			this.value = datePossibleValues[0];
		}
	}
}
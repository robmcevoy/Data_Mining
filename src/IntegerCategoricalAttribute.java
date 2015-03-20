// Used for all integer categorical attributes in data set

public class IntegerCategoricalAttribute extends Attribute {
		
	IntegerCategoricalAttribute(String name, int index, int[] possibleValues){
		super(name, index,possibleValues); 
	}
	
	IntegerCategoricalAttribute(String name, int index, int[] possibleValues, boolean isClassAttribute){
		super(name, index,possibleValues, isClassAttribute); 
	}

	@Override
	public void setValue(String valueString){
		try{
			int value = Integer.parseInt(valueString);
			this.value = value;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

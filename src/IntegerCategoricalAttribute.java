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
			boolean element = false;
			for(int i=0; i<possibleValues.length; i++){
				if(value == possibleValues[i]){
					element =true;
				}
			}
			if(!element){
				System.out.println("element did not match: " + value + " index" + index);
			}
			this.value = value;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

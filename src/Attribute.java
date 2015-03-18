
public abstract class Attribute {
	
	protected int[] possibleValues;
	protected String name;
	protected int value;
	protected int index;
	protected boolean hasBeenUsed;
	protected boolean isClassAttribute;
	
	public Attribute(String name, int index, int[] possibleValues){
		this.name = name;
		this.index = index;
		this.hasBeenUsed = false;
		this.possibleValues = possibleValues;
		this.isClassAttribute = false;
	}
	public Attribute(String name, int index, int[] possibleValues, boolean isClassAttribute){
		this.name = name;
		this.index = index;
		this.hasBeenUsed = false;
		this.possibleValues = possibleValues;
		this.isClassAttribute = isClassAttribute;
	}
	
	
	public abstract void setValue(String value);
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int getCurrentValueIndex() {
		for(int i=0; i<possibleValues.length; i++){
			if(value == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	
	public int getValueIndex(int testValue) {
		for(int i=0; i<possibleValues.length; i++){
			if(testValue == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(Object o){
		return false;
	}
	
	
	public boolean sameAttribute(Attribute att){
		return (index == att.getIndex() && name.equals(att.getName()));
	}
	
	public void markUsed(){
		this.hasBeenUsed = true;
	}
	
	public boolean hasBeenUsed(){
		return this.hasBeenUsed;
	}
	
	public String getTreePrintString(){
		return this.name + " = " + this.value;
	}
	
	public int getNumPossibleValues(){
		return possibleValues.length;
	}
	
	public boolean isClassAttribute(){
		return this.isClassAttribute;
	}
}

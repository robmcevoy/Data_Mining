
public class Attribute {
	
	private int[] possibleValues;
	private String name;
	private int value;
	private int index;
	private boolean hasBeenUsed;
	
	public Attribute(String name, int index,int[] possibleValues){
		this.name = name;
		this.index = index;
		this.possibleValues = possibleValues;
		this.hasBeenUsed = false;
	}
	
	public void setValue(int value){
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
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getIndex(){
		return index;
	}
	
	// get the index of the current value
	public int getCurrentValueIndex() {
		for(int i=0; i<possibleValues.length; i++){
			if(value == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	// get the index of the value passed
	public int getValueIndex(int testValue) {
		for(int i=0; i<possibleValues.length; i++){
			if(testValue == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	public int getNumPossibleValues(){
		return possibleValues.length;
	}
	
	
	public boolean equals(Object o){
		return false;
	}
	
	
	public boolean sameAttribute(Attribute att){
		return (index == att.getIndex());
	}
	
	public void markUsed(){
		this.hasBeenUsed = true;
	}
	
	public boolean hasBeenUsed(){
		return this.hasBeenUsed;
	}
}

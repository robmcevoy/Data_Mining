import java.util.ArrayList;


public class Row {
	
	private final String CSV_SPLIT=",";
	private int attributesTested;
	private Attribute classAttribute;
	private ArrayList<Attribute> nonClassAttributes;
	
	public Row(){
		attributesTested = 0;
		nonClassAttributes = new ArrayList<Attribute>();
		AttributeCreator creator= new AttributeCreator();
		classAttribute = creator.getClassAttribute();
		nonClassAttributes = creator.getNonClassAttributes(); 
	}
	
	// update attribute values
	public void fillRow(String line){
		String values[] = line.split(CSV_SPLIT);
		for(int i=0; i<values.length; i++){
			try{
				updateRow(i, Integer.parseInt(values[i]));
			}
			catch(java.lang.NumberFormatException e){}
		}
	}
	
	private void updateRow(int index, int value){
		// try class attribute first
		if(index == classAttribute.getIndex()){
			classAttribute.setValue(value);
		}
		// else try non class attributes
		else{
			for(Attribute attribute: nonClassAttributes){
				if(index == attribute.getIndex()){
					attribute.setValue(value);
				}
			}
		}
	}
	
	public Attribute getClassAttribute(){
		return classAttribute;
	}
	
	public Attribute getAttributeToTest(){
		if(attributesTested < nonClassAttributes.size()){
			return nonClassAttributes.get(attributesTested);
		}
		return null;
	}
	
	public void incAttributesTested(){
		attributesTested++;
	}
	
	public boolean equals(Object o){
		return false;
	}
}

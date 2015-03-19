import java.util.ArrayList;

// Represents a row from the dataset
// A row is made up of set of Attributes

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
	
	public void fillRow(String line){
		String values[] = line.split(CSV_SPLIT);
		for(int i=0; i<values.length; i++){
			try{
				updateRow(i, values[i]);
			}
			catch(java.lang.NumberFormatException e){}
		}
	}
	
	private void updateRow(int index, String value){
		if(index == classAttribute.getIndex()){
			classAttribute.setValue(value);
		}
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
			Attribute att = nonClassAttributes.get(attributesTested);
			if(att.hasBeenUsed()){
				incAttributesTested();
				return getAttributeToTest();
			}
			else{
				return att;
			}
		}
		return null;
	}
	
	public void incAttributesTested(){
		attributesTested++;
	}
	
	public void resetAttributesTested(){
		attributesTested=0;
	}
	
	public boolean equals(Object o){
		return false;
	}
	
	public Attribute getAttributeWithValue(Attribute att){
		for(Attribute a: nonClassAttributes){
			if(a.sameAttribute(att)){
				return a;
			}
		}
		return null;
	}
	
	public void markAttributeAsUsed(Attribute att){
		for(Attribute a: nonClassAttributes){
			if(a.sameAttribute(att)){
				a.markUsed();
			}
		}
	}
}

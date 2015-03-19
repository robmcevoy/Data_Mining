import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Splitter {
	
	private ArrayList<Row> set;
	
	public Splitter(){
		set = new ArrayList<Row>();
	}
	
	public ArrayList<Row> getCurrentSet(){
		return set;
	}
	
	public void setSet(ArrayList<Row> newSet){
		this.set = newSet;
	}
	
	public void readFile(String url){
		System.out.println("Reading Training Data Set..");
		try{
			BufferedReader reader = new BufferedReader(new FileReader(url));
			String line = reader.readLine();
			while((line = reader.readLine()) != null){
				Row row = new Row();
				row.fillRow(line);
				set.add(row);
			}
			reader.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void nextAttribute(){
		for(Row tmp: set){
			tmp.incAttributesTested();
		}
	}
	
	public Attribute getHighestInfoGainAtribute(){
		resetNextAttributeToTest();
		double highest =0.0;
		Attribute highestAttr = null;
		while(set.get(0).getAttributeToTest() != null){
			double infoGain = informationGain();
			if(infoGain > highest){
				highest = infoGain;
				highestAttr = set.get(0).getAttributeToTest();
			}
			nextAttribute();
		}
		if(highestAttr != null){
			markAttributeUsed(highestAttr);
		}
		return highestAttr;
	}
	
	public double informationGain(){
		return eStart() - eNew();
	}
	
	public double eNew(){
		ArrayList<ArrayList<Row>> subsets = getSubsets(this.set, this.set.get(0).getAttributeToTest());
		int totalSubset=0;
		double enew = 0.0;
		double entropy;
		for(ArrayList<Row> subset : subsets){
			totalSubset = totalSubset + subset.size(); 
			entropy = entropy(subset.size(), getNumClassesInstances(subset));
			enew = enew + (((double)subset.size() /set.size()) * entropy);
		}
		//System.out.println("total of subsets: "  + totalSubset);
		return enew;
	}
	
	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances(this.set);
		return entropy(set.size(), array);
	}
	
	public ArrayList<Integer> getNumClassesInstances(ArrayList<Row> set){
		int numFirstClassInstances = 0;
		int numSecondClassInstances = 0;
		int numThirdClassInstances = 0;
		Attribute attribute;
		for(Row row: set){
			attribute = row.getClassAttribute();
			int index = attribute.getCurrentValueIndex();
			if(index != -1){
				if(index == 0){
					numFirstClassInstances++;
				}
				else if(index == 1){
					numSecondClassInstances++;
				}
				else if(index == 2){
					numThirdClassInstances++;
				}
			}
		}
		ArrayList<Integer> classInstances = new ArrayList<Integer>();
		classInstances.add(numFirstClassInstances);
		classInstances.add(numSecondClassInstances);
		classInstances.add(numThirdClassInstances);
		return classInstances;
	}
	
	public int getBestClassInstance(ArrayList<Row> set){
		ArrayList<Integer> instances = getNumClassesInstances(set);
		int bestIndex=-1;
		int best=-1;
		for(int i=0; i<instances.size(); i++){
			if(instances.get(i) >= best){
				best = instances.get(i);
				bestIndex = i;
			}
		}
		if(bestIndex == 0){
			return 1;
		}
		else if(bestIndex == 1){
			return 2;
		}
		else{
			return 3;
		}
	}
	
	// takes in a set of rows
	// returns an array of subsets split on attribute values
	public ArrayList<ArrayList<Row>> getSubsets(ArrayList<Row> set, Attribute attribute){
		ArrayList<ArrayList<Row>> subsets = new ArrayList<ArrayList<Row>>();
		//create subsets
		for(int i=0; i<attribute.getNumPossibleValues(); i++){
			ArrayList<Row> subset = new ArrayList<Row>();
			subsets.add(subset);
		}
		int numSubsets = subsets.size();
		for(Row row: set){
			int index = attribute.getValueIndex(row.getAttributeWithValue(attribute).getValue());
			for(int i=0; i<numSubsets; i++){
				if(i == index){
					subsets.get(i).add(row);
				}
			}
		}
		return subsets;
	}
	
	// set an end leaf
	// ie: only one type of class attribute contained in the set
	public boolean endLeaf(ArrayList<Row> subset){
		ArrayList<Integer> classInstances = getNumClassesInstances(subset);
		int classInstancesGreaterThanZero = 0;
		for(int x: classInstances){
			if(x > 0){
				classInstancesGreaterThanZero++;
			}
		}
		if(classInstancesGreaterThanZero > 1){
			return false;
		}
		return true;
	}
	
	private double entropy( int numInstances, ArrayList<Integer> arrayClassOccurances){
		double e = 0.0;
		for(int elementInstance: arrayClassOccurances){
			if(elementInstance > 0){
				e = e -elementOfE(numInstances, elementInstance);
			}
		}
		return e;
	}

	private double elementOfE(int numInstances, int numClassInstances){
			double p = (double) numClassInstances/numInstances;
			return p * logOfBase(2, p);
	}

	private double logOfBase(int base, double num) {
		return Math.log(num) / Math.log(base);
	}
	
	private void resetNextAttributeToTest(){
		for(Row row: set){
			row.resetAttributesTested();
		}
	}
	
	private void markAttributeUsed(Attribute att){
		for(Row row: set){
			row.markAttributeAsUsed(att);
		}
	}
}

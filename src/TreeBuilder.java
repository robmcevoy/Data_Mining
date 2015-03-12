import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class TreeBuilder {
	
	private ArrayList<Row> set;
	
	public TreeBuilder(){
		set = new ArrayList<Row>();
	}
	
	public void readFile(String url){
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
	
	public void getAllInformationGains(){
		while(set.get(0).getAttributeToTest() != null){
			System.out.println("********* " + set.get(0).getAttributeToTest().getName() + " *********");
			System.out.println("Info Gain: " + informationGain());
			nextAttribute();
			System.out.println();
		}
		
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
		System.out.println("total of subsets: "  + totalSubset);
		return enew;
	}
	
	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances(this.set);
		return entropy(set.size(), array);
	}
	
	private ArrayList<Integer> getNumClassesInstances(ArrayList<Row> set){
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
			//System.out.println("number of subsets " + numSubsets);
			for(Row row: set){
				int index =row.getAttributeToTest().getValueIndex(row.getAttributeToTest().getValue());
				for(int i=0; i<numSubsets; i++){
					if(i == index){
						subsets.get(i).add(row);
					}
				}
			}
			return subsets;
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
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//Takes a Decision Tree as an input and uses its to make predictions for the 2006 dataset

public class Predictor {
	
	private DecisionTree decisionTree;
	private ArrayList<Row> set;
	private final String URL = "data/DfTRoadSafety_Accidents_2006.csv";
	private int correct;
	private int incorrect;

	Predictor(DecisionTree decisionTree){
		this.decisionTree = decisionTree;
		this.set = new ArrayList<Row>();
		this.correct = 0;
		this.incorrect = 0;
	}
	
	public void predict(){
		readFile();
		System.out.println("Predicting..");
		for(Row row: set){
			recursiveTraverse(decisionTree, row);
		}
		double percentageCorrect = 100.00 * ((double)correct) / (correct + incorrect);
		System.out.println("Percentage Correct: " + percentageCorrect + "%");
	}
	
	public void recursiveTraverse(DecisionTree node, Row row){
		try{
			Attribute toSplitOn = node.getToSplitOn();
			if(!toSplitOn.isClassAttribute()){
				Attribute attribute = row.getAttributeWithValue(toSplitOn);
				int index = attribute.getCurrentValueIndex();
				recursiveTraverse(node.getChild(index), row);
			}
			else{
				if(toSplitOn.getValue() == row.getClassAttribute().getValue()){
					correct++;
				}
				else{
					incorrect++;
				}
			}
		}catch(Exception e){
			incorrect++;
		}
	}
	
	public void readFile(){
		System.out.println("Reading 2006 Data Set..");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(URL));
			String line = reader.readLine();
			while((line = reader.readLine()) != null){
				Row row = new Row();
				row.fillRow(line);
				set.add(row);
			}
			reader.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
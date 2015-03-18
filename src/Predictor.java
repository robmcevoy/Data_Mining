import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Predictor {
	
	private Tree decisionTree;
	private ArrayList<Row> set;
	//private String url = "data/small_2006.csv";
	private String url = "data/DfTRoadSafety_Accidents_2006.csv";
	private int correct;
	private int incorrect;
	private int numWrongfromException;

	Predictor(Tree decisionTree){
		this.decisionTree = decisionTree;
		this.set = new ArrayList<Row>();
		this.correct = 0;
		this.incorrect = 0;
		this.numWrongfromException = 0;
	}
	
	public void predict(){
		readFile();
		for(Row row: set){
			recursiveTraverse(decisionTree, row);
		}
		double percentageCorrect = 100.00 * ((double)correct) / (correct + incorrect);
		System.out.println("Correct: " + correct + " Incorrect: " + incorrect );
		System.out.println("Exception Wrongs: " + numWrongfromException);
		System.out.println("Percentage Correct: " + percentageCorrect + "%");
	}
	
	public void recursiveTraverse(Tree node, Row row){
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
			numWrongfromException++;
			if(row.getClassAttribute().getValue() == 3){
				correct++;
			}
			else{
				incorrect++;
			}
		}
	}
	
	public void readFile(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(url));
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

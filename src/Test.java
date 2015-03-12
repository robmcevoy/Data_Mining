
public class Test {
	
	public static void main(String [] args){
		
		TreeBuilder builder = new TreeBuilder();
		//builder.readFile("data/small.csv");
		builder.readFile("data/DfTRoadSafety_Accidents_2005.csv");
		builder.getAllInformationGains();
	}
}

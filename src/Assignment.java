// runs application

public class Assignment {
	public static void main(String []args){
		
		long startTime = System.nanoTime();
		TreeBuilder builder = new TreeBuilder();
		DecisionTree tree = builder.buildTree();
		Predictor predictor = new Predictor(tree);
		predictor.predict();
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Time Taken: " + ((double)elapsedTime /  1000000000.0) + " seconds"); 
	}
}

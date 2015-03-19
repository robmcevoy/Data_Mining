// runs application

public class Test {
	public static void main(String []args){
		
		TreeBuilder builder = new TreeBuilder();
		DecisionTree tree = builder.buildTree();
		Predictor predictor = new Predictor(tree);
		predictor.predict();
	}
}

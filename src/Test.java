
public class Test {
	public static void main(String []args){
		
		TreeBuilder builder = new TreeBuilder();
		Tree tree = builder.buildTree();
		Predictor predictor = new Predictor(tree);
		System.out.println("******************************");
		predictor.predict();
	}
}

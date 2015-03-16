import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeBuilder extends JFrame{
	
	public void buildTree(){
		
		JTree tree;
		
		Splitter splitter = new Splitter();
		splitter.readFile("data/small.csv");
		//splitter.readFile("data/DfTRoadSafety_Accidents_2005.csv");
		Attribute toSplitOn = splitter.getHighestInfoGainAtribute();
		Tree root = new Tree(toSplitOn);
		DefaultMutableTreeNode JRoot = new DefaultMutableTreeNode(toSplitOn.getName());
		recursiveBuildTree(root, JRoot, splitter, splitter.getCurrentSet());
		
		tree = new JTree(JRoot);
        add(tree);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Decision Tree");       
        this.pack();
        this.setVisible(true);		
	}
	
	public void recursiveBuildTree(Tree node, DefaultMutableTreeNode jtree, Splitter splitter, ArrayList<Row> set){
		//System.out.println("--------entered recursive------------");
		ArrayList<ArrayList<Row>> subsets = splitter.getSubsets(set, node.getToSplitOn());
		//System.out.println("num subsets: " + subsets.size());
		Attribute newToSplitOn;
		Tree child;
		DefaultMutableTreeNode JChild;
		for(ArrayList<Row> subset: subsets){
			//System.out.println("subset size: " + subset.size());
			if(!splitter.endLeaf(subset)){
				splitter.setSet(subset);
				newToSplitOn = splitter.getHighestInfoGainAtribute();
				if(newToSplitOn != null){
					//System.out.println("splitting on " + newToSplitOn.getName());
					child = node.addChild(newToSplitOn);
					JChild = new DefaultMutableTreeNode(newToSplitOn.getName());
					jtree.add(JChild);
					recursiveBuildTree(child, JChild, splitter, subset);
				}
			}
		}
		
	}
}
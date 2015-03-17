import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeBuilder extends JFrame{
	
	AttributeCreator creator = new AttributeCreator();
	Attribute TIME = creator.getTimeAttribute();
	
	public Tree buildTree(){
		
		JTree tree;
		Splitter splitter = new Splitter();
		//splitter.readFile("data/small.csv");
		splitter.readFile("data/DfTRoadSafety_Accidents_2005.csv");
		System.out.println("Building Tree..");
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
        
        return root;
	}
	
	public void recursiveBuildTree(Tree node, DefaultMutableTreeNode jtree, Splitter splitter, ArrayList<Row> set){
		ArrayList<ArrayList<Row>> subsets = splitter.getSubsets(set, node.getToSplitOn());
		Attribute newToSplitOn;
		Tree child;
		DefaultMutableTreeNode JChild;
		for(ArrayList<Row> subset: subsets){
			if(!splitter.endLeaf(subset)){
				splitter.setSet(subset);
				newToSplitOn = splitter.getHighestInfoGainAtribute();
				if(newToSplitOn != null){
					child = node.addChild(newToSplitOn);
					JChild = new DefaultMutableTreeNode(newToSplitOn.getName());
					jtree.add(JChild);
					recursiveBuildTree(child, JChild, splitter, subset);
				}
			}
			else{
				if(subset.size()>0){
					JChild = new DefaultMutableTreeNode(subset.get(0).getClassAttribute().getTreePrintString());
					jtree.add(JChild);
					child = node.addChild(subset.get(0).getClassAttribute());
				}
			}
		}
	}
}
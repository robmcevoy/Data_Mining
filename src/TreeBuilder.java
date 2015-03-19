import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

// Class builders two trees: DecisionTree, JFrame Tree
// Predictions are made using the DecisionTree
// JFrame Tree is used to visualize the Decision Tree

public class TreeBuilder extends JFrame{
	
	private static final long serialVersionUID = -1181748977027422135L;
	private AttributeCreator creator = new AttributeCreator();
	private Attribute CLASS_ATTRIBUTE = creator.getClassAttribute();
	private final String URL = "data/DfTRoadSafety_Accidents_2005.csv";
	
	public DecisionTree buildTree(){
		
		long startTime = System.nanoTime();
		JTree tree;
		Splitter splitter = new Splitter();
		splitter.readFile(URL);
		System.out.println("Building Tree..");
		Attribute toSplitOn = splitter.getHighestInfoGainAtribute();
		DecisionTree root = new DecisionTree(toSplitOn);
		DefaultMutableTreeNode JRoot = new DefaultMutableTreeNode(toSplitOn.getName());
		int bestClass = splitter.getBestClassInstance(splitter.getCurrentSet());
		recursiveBuildTree(root, JRoot, splitter, splitter.getCurrentSet(),bestClass);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Time Taken: " + ((double)elapsedTime /  1000000000.0) + " seconds"); 
		tree = new JTree(JRoot);
		JPanel container = new JPanel();
		container.add(tree);
		JScrollPane scrPane = new JScrollPane(container);
		add(scrPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Decision Tree");       
        this.pack();
        this.setVisible(true);	
        return root;
	}
	
	// recursive function which builds the tree
	// new branches to the tree will be made as long as the Splitter class produces Attributes to split on
	public void recursiveBuildTree(DecisionTree node, DefaultMutableTreeNode jtree, Splitter splitter, ArrayList<Row> set, int bestClass){
		ArrayList<ArrayList<Row>> subsets = splitter.getSubsets(set, node.getToSplitOn());
		Attribute newToSplitOn;
		DecisionTree child;
		DefaultMutableTreeNode jChild;
		for(ArrayList<Row> subset: subsets){
			if(!splitter.endLeaf(subset)){
				splitter.setSet(subset);
				newToSplitOn = splitter.getHighestInfoGainAtribute();
				if(newToSplitOn != null){
					child = node.addChild(newToSplitOn);
					jChild = new DefaultMutableTreeNode(newToSplitOn.getName());
					jtree.add(jChild);
					int newBestClass = splitter.getBestClassInstance(subset);
					recursiveBuildTree(child, jChild, splitter, subset,newBestClass);
				}
				else{
					CLASS_ATTRIBUTE.setValue(String.valueOf(bestClass));
					jChild = new DefaultMutableTreeNode(CLASS_ATTRIBUTE.getTreePrintString());
					jtree.add(jChild);
					child = node.addChild(CLASS_ATTRIBUTE);
				}
			}
			else{
				CLASS_ATTRIBUTE.setValue(String.valueOf(bestClass));
				jChild = new DefaultMutableTreeNode(CLASS_ATTRIBUTE.getTreePrintString());
				jtree.add(jChild);
				child = node.addChild(CLASS_ATTRIBUTE);
			}
		}
	}
}
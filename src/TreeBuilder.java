import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeBuilder extends JFrame{
	
	AttributeCreator creator = new AttributeCreator();
	Attribute TIME = creator.getTimeAttribute();
	int nullCount=0;
	int numEmptySubsets=0;
	
	public Tree buildTree(){
		
		long startTime = System.nanoTime();
		JTree tree;
		Splitter splitter = new Splitter();
		//splitter.readFile("data/small_2005.csv");
		splitter.readFile("data/DfTRoadSafety_Accidents_2005.csv");
		System.out.println("Building Tree..");
		Attribute toSplitOn = splitter.getHighestInfoGainAtribute();
		Tree root = new Tree(toSplitOn);
		DefaultMutableTreeNode JRoot = new DefaultMutableTreeNode(toSplitOn.getName());
		recursiveBuildTree(root, JRoot, splitter, splitter.getCurrentSet());
		System.out.println("Null Count: " + nullCount);
		System.out.println("Num Empty Subsets: " + numEmptySubsets);
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
				else{
					nullCount++;
				}
			}
			else{
				if(subset.size()>0){
					JChild = new DefaultMutableTreeNode(subset.get(0).getClassAttribute().getTreePrintString());
					jtree.add(JChild);
					child = node.addChild(subset.get(0).getClassAttribute());
				}
				else{
					numEmptySubsets++;
				}
			}
		}
	}
}
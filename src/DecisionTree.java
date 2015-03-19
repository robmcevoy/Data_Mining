import java.util.ArrayList;

// Used to represent a decision tree
// Each node has an Attribute to split on
// and an array children nodes

public class DecisionTree{

    Attribute toSplitOn;
    ArrayList<DecisionTree> children;

    public DecisionTree(Attribute toSplitOn) {
        this.toSplitOn = toSplitOn;
        this.children = new ArrayList<DecisionTree>();
    }

    public DecisionTree addChild(Attribute child) {
        DecisionTree childNode = new DecisionTree(child);
        this.children.add(childNode);
        return childNode;
    }
    
    public ArrayList<DecisionTree> getChildren(){
    	return this.children;
    }
    
    public int getNumChildren(){
    	return children.size();
    }
    
    public boolean hasChildren(){
    	return children.size() > 0;
    }
    
    public DecisionTree getChild(int index){
    	return children.get(index);
    }
    
    public Attribute getToSplitOn(){
    	return this.toSplitOn;
    }
}
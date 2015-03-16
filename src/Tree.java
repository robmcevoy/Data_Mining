import java.util.ArrayList;

public class Tree{

    Attribute toSplitOn;
    ArrayList<Tree> children;

    public Tree(Attribute toSplitOn) {
        this.toSplitOn = toSplitOn;
        this.children = new ArrayList<Tree>();
    }

    public Tree addChild(Attribute child) {
        Tree childNode = new Tree(child);
        this.children.add(childNode);
        return childNode;
    }
    
    public ArrayList<Tree> getChildren(){
    	return this.children;
    }
    
    public int getNumChildren(){
    	return children.size();
    }
    
    public boolean hasChildren(){
    	return children.size() > 0;
    }
    
    public Attribute getToSplitOn(){
    	return this.toSplitOn;
    }


}
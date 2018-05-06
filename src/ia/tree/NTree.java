package ia.tree;

import java.util.LinkedList;


public class NTree <T>{
	
    private T root;
    private LinkedList<NTree> childs;
    
    
    public NTree(){
        this.root = null;
        this.childs = null;
    }
    
    
    public NTree(T root){
        this.root= root;
        this.childs= new LinkedList<NTree>();
    }
    
    
    public NTree(T root,LinkedList<NTree> childs){
        this.root= root;
        this.childs= childs;
    }
    
    
	public void addChild(T added) {
		childs.add(new NTree(added));
	}
	
	
	public void addChilds(LinkedList<T> added) {
		for(T node: added)
			addChild(node);
	}


    public boolean isEmpty(){
        return this.root == null;
    }
    
    
    public boolean isLeaf(){
        return !isEmpty() && this.childs.size()==0;
    }
    
    
    public int height() {
    	int count = 1;
    	for(NTree<T> child : childs)
    		count += child.height();
    	return count;
    }
    
    
    public T getRoot(){
        return this.root;
    }
    
    
    public LinkedList<NTree> getChilds(){
        return this.childs;
    }
    
    
    public String toString(int p) {

        String temp = new String();
    	
    	for(int i = 0; i < p; i++)
    		temp += "  --> ";
    	
        temp += root.toString() + "\n";
    	
    	if(!isLeaf())
            for (NTree child: this.childs)
                temp += child.toString(p+1);
    	
    	return temp;
    }
    
    
    public void width() {
    	
    }
}
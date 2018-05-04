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
    
    
    public T getRoot(){
        return this.root;
    }
    
    
    public LinkedList<NTree> getChilds(){
        return this.childs;
    }
    
    
    public String toString(){     
        String representation="[";
        representation += this.root.toString();
        representation += ",";
        representation+="[";
        for (NTree child: this.childs){
            representation+=child.toString();
            representation+=",";
        }  
        representation+="]";
        return representation;
    }
    
    
    public void out(int p) {

    	for(int i = 0; i < p; i++)
    		System.out.print("  --> ");
    	
        System.out.println(root.toString());
    	
    	if(!isLeaf())
            for (NTree child: this.childs)
                child.out(p+1); 
    }
    
}

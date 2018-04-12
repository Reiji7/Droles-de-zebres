/**
 * 
 */
package pawn;

/**
 * @author Adrien
 *
 */
public abstract class Pawn {
	private int value;
	private boolean visible = true;
	private String couleur;
	private String name;
	
	public Pawn(int v, String couleur, String name){
		value = v;
		this.couleur = couleur;
		this.name = name;
	}
	
	public void seCache(){
		this.visible = false;
		this.value = 0;
	}
	
	public void fuite(){
		
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.value + " scoring)";
	}
}
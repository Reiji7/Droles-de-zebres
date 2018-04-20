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
	private String color;
	private String name;
	
	public Pawn(int v, String color, String name){
		value = v;
		this.color = color;
		this.name = name;
	}
	
	public void hides(){
		this.visible = false;
		this.value = 0;
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.value + " scoring)";
	}
	
	public String getColor(){
		return this.color;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	
	public int getValue(){
		return this.value;
	}
}
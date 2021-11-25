package model;

public class Pions {
	
	int x;
	int y;
	boolean controledByUser;
	
	public Pions(int x, int y, boolean controledByUser, boolean equipe) {
		this.x = x;
		this.y = y;
		this.controledByUser = controledByUser;
		this.equipe = equipe;
	}
	//utilisé
	protected boolean equipe;
	
	public boolean getEquipe() {
		return equipe;
	}
	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isControledByUser() {
		return controledByUser;
	}
	public void setControledByUser(boolean controledByUser) {
		this.controledByUser = controledByUser;
	}
	
}

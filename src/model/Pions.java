package model;

public class Pions {
	
	boolean controledByUser;
	//utilisé
	int index;
	boolean equipe;
	char skin;
	
	public Pions(int index, boolean controledByUser, boolean equipe,char skin) {
		this.index=index;
		this.controledByUser = controledByUser;
		this.equipe = equipe;
		this.skin = skin;
	}
	public char getSkin() {
		return skin;
	}

	public void setSkin(char skin) {
		this.skin = skin;
	}

	
	public boolean getEquipe() {
		return equipe;
	}
	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isControledByUser() {
		return controledByUser;
	}
	public void setControledByUser(boolean controledByUser) {
		this.controledByUser = controledByUser;
	}
	
}

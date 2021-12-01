package model;

public class Pions {

	int index;
	boolean equipe;
	char skin;
	boolean dame;
	
	public Pions(int index, boolean equipe,char skin) {
		this.index=index;
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

}

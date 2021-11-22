package model;

public class Joueur {
	String Nom="";
	// blanc=true,noir=false
	boolean pions;
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public boolean isPions() {
		return pions;
	}
	public void setPions(boolean pions) {
		this.pions = pions;
	}
	
}

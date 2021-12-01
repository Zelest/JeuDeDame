package model;

public class Joueur {
	static String Nom="";
	// blanc=true,noir=false
	boolean pions;
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Joueur.Nom = nom;
	}
	public boolean isPions() {
		return pions;
	}
	public void setPions(boolean pions) {
		this.pions = pions;
	}
	
}

package game;

import model.Pions;
import model.Joueur;

import utilitaires.Utilitaires;
import utilitaires.Inputs;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	Joueur joueur1= new Joueur();
	Joueur joueur2=new Joueur();
	
	public void game() {
		usernames();
		//test
		System.out.println(joueur1.getNom());
		System.out.println(joueur2.getNom());
		
		Utilitaires.initPlateau(plateau);
		Utilitaires.printPlateau(plateau);
	}
	public void usernames() {
		Inputs input =new Inputs();
		do {
		System.out.println("nom joueur 1:");
			joueur1.setNom(input.stringInput());
		}while(joueur1.getNom()=="");
		System.out.println("nom joueur 2:");
		do {
			joueur2.setNom(input.stringInput());
		}while(joueur2.getNom()=="");
	}
	
}

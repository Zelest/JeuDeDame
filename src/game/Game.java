package game;

import model.Pions;

import utilitaires.Utilitaires;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	
	public void game() {
		Utilitaires.initPlateau(plateau);
		Utilitaires.printPlateau(plateau);
	}
	

	
	
}

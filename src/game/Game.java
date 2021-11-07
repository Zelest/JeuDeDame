package game;

import utilitaires.Utilitaires;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	char[][] plateau = new char[Largeur][Hauteur];
	
	public void game() {
		Utilitaires.initPlateau(plateau);
		Utilitaires.printArray2D(plateau);
	}
	

	
	
}

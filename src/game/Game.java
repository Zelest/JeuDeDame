package game;

import menu.Menu;
import model.Pions;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	
	public void game() {
		Menu.menuPrincipal(plateau);
	}
	

	
	
}

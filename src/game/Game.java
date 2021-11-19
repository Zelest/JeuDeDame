package game;

import java.util.ArrayList;

import menu.Menu;
import model.Pions;
import utilitaires.Utilitaires;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	static ArrayList<Pions> alPions = new ArrayList<Pions>();
	
	public void game() {
		Menu.menuPrincipal(plateau);
	}
	
	public void move() {
		//selectionner un poins (entrée String ex: A6) 
		//besoin de traduire A6 en coor du tableau pour retrouver le pions ?
		//if controledbyUser or not 
		//ControledbyUser =>	Demander vers où bouger (entreé String ex B5 ou Haut gauche, haut droite etc...)
		//Not controledByUser => 	choisir un pions random a bouger puis random mouv (creer un randomformouv et respecter les regles)
		String pionsChoisie = Utilitaires.giveString();
		//ligne 21
		if (	.isControledByUser()) {
			System.out.println("Entrer un placement" + "1 : haut gauche, 2 : haut droite, 3 : bas gauche, 4 : bas droite. ");
			manipPion(Utilitaires.readInt(), pions);
		}else {
			System.out.println("Error");
				
				//mouv ordi
				//handleMouvement(Utilitaires.randomForMouv(), perso);
		
		}
	}
	
	public void manipPion(int i, Pions p ) {
		//ici test possibilite de mouvement et mouvement si possible
	}
	
	public static void createPion(int x,int y,Boolean controledByUser, int equipe) {
		alPions.add(new Pions(x,y,controledByUser, equipe));
		
		
	}
}

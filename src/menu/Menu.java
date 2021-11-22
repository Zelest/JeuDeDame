package menu;

import model.Pions;
import utilitaires.Utilitaires;

public class Menu {

public static void menuPrincipal(Pions[][] plateau) {
		
		System.out.println("Bienvenue sur notre Jeux de Dame");
		System.out.println("1 Joueur contre Ordinateur");
		System.out.println("2 Joueur contre Joueur");
		System.out.println("3 Exit");
		System.out.println("4 test");
		
		int saisieMenu = Utilitaires.readInt();
		
		switch (saisieMenu) {
		case 1 : 
			System.out.print("Joueur contre Ordinateur");
			//entrer le nom du joueur et l'enregistrer
			break;
		case 2 :
			System.out.print("Joueur contre Joueur");
			//entrer le nom des joueurs et l'enregistrer

			break;
		case 3 :
			System.out.print("Au revoir");
			break;
			//test
		case 4 :
			System.out.println("Entrer la colonne du pions que vous voulez bouger : ");
			Utilitaires.readChar();
			break;
		}
	}
}

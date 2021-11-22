package game;


import model.Pions;
import model.Joueur;
import java.util.ArrayList;

import utilitaires.Utilitaires;
import utilitaires.Inputs;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	static Joueur joueur1= new Joueur();
	static Joueur joueur2=new Joueur();
	
	public void game() {
		menuPrincipal(plateau);
	
		Utilitaires.initPlateau(plateau);
		Utilitaires.printPlateau(plateau);
	}
	public static void initUsernames() {
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
	static ArrayList<Pions> alPions = new ArrayList<Pions>();
	
	
	public void choixPions() {
		System.out.println("Entrer la colonne du pions que vous voulez bouger : ");
		char colonne = Utilitaires.readChar();
		System.out.println("Entrer la ligne du pions que vous voulez bouger : ");
		char ligne = Utilitaires.readChar();
		Utilitaires.tradPions(colonne);
		Utilitaires.tradPions(ligne);
		//on a les coor du pions choisie
		//je sais pas comment faire pour choisir le pions mtn :(
	}
	
	
	public void move() {

		//if controledbyUser or not 
		//ControledbyUser =>	Demander vers où bouger (entreé String ex B5 ou Haut gauche, haut droite etc...)
		//Not controledByUser => 	choisir un pions random a bouger puis random mouv (creer un randomformouv et respecter les regles)
		//
		//ligne 21

//		if (	.isControledByUser()) {
//			System.out.println("Entrer un placement" + "1 : haut gauche, 2 : haut droite, 3 : bas gauche, 4 : bas droite. ");
//			manipPion(Utilitaires.readInt(), pions);
//		}else {
//			System.out.println("Error");
//				
//				//mouv ordi
//				//handleMouvement(Utilitaires.randomForMouv(), perso);
//		
//		}
	}
	
	public void manipPion(int i, Pions p ) {
		//ici test possibilite de mouvement et mouvement si possible
	}
	
	public static void createPion(int x,int y,Boolean controledByUser, int equipe) {
		alPions.add(new Pions(x,y,controledByUser, equipe));
		
		
	}
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
			initUsernames() ;

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

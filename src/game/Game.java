package game;

import model.Pions;
import model.Joueur;

import utilitaires.Utilitaires;
import utilitaires.Inputs;

public class Game {
	int Largeur = 10;
	int Hauteur = 10;
	Pions[][] plateau = new Pions[Largeur][Hauteur];
	static Joueur joueur1 = new Joueur();
	static Joueur joueur2 = new Joueur();
	
	boolean tour =true;
	static Inputs input = new Inputs();
	static char[] row = {'A','B','C','D','E','F','G','H','I','J'};
	
	public void game() {
		menuPrincipal();
		Utilitaires.initPlateau(plateau);
		do {
			clearScreen();
			Utilitaires.printPlateau(plateau);
			deplacementPion();
			nextTour();
		} while (true);
	}
		static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

	static void initUsernames() {

		do {
			System.out.println("nom joueur 1:");
			joueur1.setNom(input.stringInput());
		} while (joueur1.getNom() == "");
		System.out.println("nom joueur 2:");
		do {
			joueur2.setNom(input.stringInput());
		} while (joueur2.getNom() == "");
	}

	//static ArrayList<Pions> alPions = new ArrayList<Pions>();

	public void deplacementPion() {
		System.out.println("Entrer la position du pion que vous voulez bouger (ex: A3 : ");
		String in ="";
		do {
			in = input.stringInput();
		} while (!testInputChoixPions(in));	//verifie si les regles sont respectées
	}
	//Return true si les regles sont respectées sinon false.
	private boolean testInputChoixPions(String t) {
		char[] tArrayOfChar = t.toCharArray();
		boolean conditionLettre = false;
		boolean conditionChiffre = false;
		int indexLettre = 0 ;
		int chiffre =0;
		
		if (t.length()!=2) return false;
		
		for (int i=0;i<t.length();i++) {
			if (!conditionLettre) {
				if((int)tArrayOfChar[i]<75&&(int)tArrayOfChar[i]>64) {
					indexLettre = i;
					conditionLettre =true;
				}
			}
			if (!conditionChiffre) {
				if((int)tArrayOfChar[i]>47&&(int)tArrayOfChar[i]<58) {
					chiffre= Character.getNumericValue(tArrayOfChar[i]); 
					conditionChiffre =true;
				}
			}
		}
		if (conditionLettre&&conditionChiffre) {
			int indexXOfN=0;
			for (int i=0;i<row.length;i++) {
				if (row[i]==tArrayOfChar[indexLettre]) indexXOfN=i;
			}
			if (this.plateau[chiffre][indexXOfN]!=null) {
				System.out.println("pion existe");
				if (this.plateau[chiffre][indexXOfN].getEquipe()==this.tour) {
					System.out.println("le pion appartient a la bonne equipe");
					return true;
				}else {
					System.out.println("le pion appartient PAS a la bonne equipe");
					return false;
				}
			}else {
				System.out.println("pion existe pas");
				return false;
			}
		}
		return false;
	}

	public void move() {

	}

//	public static void createPion(int x, int y, Boolean controledByUser, boolean equipe) {
//		alPions.add(new Pions(x, y, controledByUser, equipe));
//
//	}

	public static void menuPrincipal() {

		System.out.println("Bienvenue sur notre Jeux de Dame");
		System.out.println("1 Joueur contre Ordinateur");
		System.out.println("2 Joueur contre Joueur");
		System.out.println("3 Exit");
		System.out.println("4 test");

		int saisieMenu = Utilitaires.readInt();

		switch (saisieMenu) {
		case 1:
			System.out.println("Joueur contre Ordinateur");
			// entrer le nom du joueur et l'enregistrer
			break;
		case 2:
			System.out.println("Joueur contre Joueur");
			initUsernames();

			break;
		case 3:
			System.out.println("Au revoir");
			break;
		// test
		case 4:
			System.out.println("Entrer la colonne du pions que vous voulez bouger : ");
			Utilitaires.readChar();
			break;
		}
	}
	void nextTour() {
		this.tour=!this.tour;
	}
}


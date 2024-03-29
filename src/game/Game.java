package game;

import model.Pions;

import java.io.IOException;

import model.Joueur;

import utilitaires.Utilitaires;
import utilitaires.Inputs;


public class Game {
	public static Pions[] plateau = new Pions[51];
	public static Joueur joueur1 = new Joueur();
	public static Joueur joueur2 = new Joueur();

	static boolean tour = true;
	static Inputs input = new Inputs();
	static final char[] row = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	int noir=0;
	int blanc=0;
	static String nomPartie = "";
	public static int countTour = 0;
	public static String nom1 = "";
	public static String nom2 = "";
	
	
	public void game() {
		menuPrincipal();
		Utilitaires.initPlateau(plateau);
			do {
				// clearScreen();
				Utilitaires.printPlateau(plateau);
				deplacementPion();
				nextTour();
				countTour++;
			} while (gameOver());		
	}
	boolean gameOver() {
		if (noir==20) { 
			System.out.println("Victoire des Noirs.");
			try {
				Save.saveScore(nom2, nom1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		else if (blanc==20) {
			System.out.println("Victoire des Blancs.");
			try {
				Save.saveScore(nom2, nom1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static void initUsernames(int nombreJoueur) {
		if (nombreJoueur == 1) {
			do {
				System.out.println("nom joueur 1:");
				joueur1.setNom(input.stringInput());
			} while (joueur1.getNom() == "");
		}else {
			do {
				System.out.println("nom joueur 1:");
				nom1 = input.stringInput();
				joueur1.setNom(nom1);
			} while (joueur1.getNom() == "");
			do {
				System.out.println("nom joueur 2:");
				nom2 = input.stringInput();
				joueur2.setNom(nom2);
			} while (joueur2.getNom() == "");
		}
	}

	public void deplacementPion() {
        int p1 =-1;
        int p3 =-1;
        int p31 = -1;
        System.out.println("Entrer la position du pion que vous voulez bouger (ex: A3 : ");
        String in ="";
        String in2 = "";
        do {
            in = input.stringInput();
            p1=testInputChoixPions(in,true);
        } while (p1==0);  
        System.out.println("Entrer la nouvelle position du pion selectionn�.");
        do {
            in2 = input.stringInput();
            p3 = testInputChoixPions(in2,false);
        }while (p3==0);
        // Verifie les regles et retourne des positions
        int p2 =verifCapture(p1,p3);
        p31 = verifDeplacement(p1,p3);
        if(p2 !=-1) {
        	this.plateau[p2]=null;
        	this.plateau[p3]=this.plateau[p1];
        	this.plateau[p1]=null;
        }else if (p31 != -1) {
        	this.plateau[p31]=this.plateau[p1];
        	this.plateau[p1]=null;
        	countCapture();
        }else {
        	System.out.println("Le pion s�lectionn� ne peut pas bouger.");
        	deplacementPion();
        }
        Utilitaires.write(in + " -> " + in2, nomPartie);
    }
	
	
	
	
	
	
	
	
	
	
	void countCapture() {
		if(tour) blanc+=1;
		else noir+=1;
	}
	// retourne nouvelle position de p1 (p3)
	public static int verifDeplacement(int p1, int p3) {
		int[] positionPossibleP3 = { p1-5, p1-4, p1+5, p1+6 };
		
		for (int i = 0; i < positionPossibleP3.length; i++) {
			if (positionPossibleP3[i] < 1 || positionPossibleP3[i] > 51) {
				
			} else if (p3 == positionPossibleP3[i]) { // impair
				return plateau[positionPossibleP3[i]]==null ? positionPossibleP3[i]:-1;
			}else if(p3==positionPossibleP3[i]-1){ //pair
				return plateau[positionPossibleP3[i]-1]==null ? positionPossibleP3[i]-1:-1;
			}
		}
		return -1;
	}

	// Return true si les regles sont respect�es sinon false.
	public static int testInputChoixPions(String t, boolean testP1) {
		char[] tArrayOfChar = t.toCharArray();
		boolean conditionLettre = false;
		boolean conditionChiffre = false;
		int indexLettre = 0;
		int chiffre = 0;

		if (t.length() != 2)
			return 0;

		for (int i = 0; i < t.length(); i++) {
			if (!conditionLettre) {
				if ((int) tArrayOfChar[i] < 75 && (int) tArrayOfChar[i] > 64) {
					indexLettre = i;
					conditionLettre = true;
				}
			}
			if (!conditionChiffre) {
				if ((int) tArrayOfChar[i] > 47 && (int) tArrayOfChar[i] < 58) {
					chiffre = Character.getNumericValue(tArrayOfChar[i]);
					conditionChiffre = true;
				}
			}
		}
		// PAS TOUCHER EN HAUT
		if (conditionLettre && conditionChiffre) {
			int lettre = 0; //
			for (int i = 0; i < row.length; i++) {
				if (row[i] == tArrayOfChar[indexLettre])
					lettre = i + 1;
			}
			if ((chiffre == 0 && lettre % 2 == 0) || chiffre % 2 == lettre % 2) {
				if (!testP1 && plateau[chiffre * 5 + (int) Math.ceil((double) lettre / 2)] == null) {
					return chiffre * 5 + (int) Math.ceil((double) lettre / 2);
				} else if (plateau[chiffre * 5 + (int) Math.ceil((double) lettre / 2)].getEquipe() == tour) {
					return chiffre * 5 + (int) Math.ceil((double) lettre / 2);
				} else {
					//System.out.println("Mauvaise entr�e.");
					return 0;
				}
			} else {
				//System.out.println("Le pion n'existe pas.");
				return 0;
			}
		}
		return 0;
	}

	// Verifie si la position finale (p3) est valide
	// Et retourne l'index de p2
	public static int verifCapture(int p1, int p3) {
		if ((!(p3 > 0 && p3 <= 51) && plateau[p3] == null) || p1 == p3)
			return -1; // verif p3 dans plateau
		int tmpModP1 = p1 % 10;
		// haut gauche, haut droite, bas gauche, bas droite
		int[] positionPossibleP3 = { p1 - 11, p1 - 9, p1 + 9, p1 + 11 };
		int[] positionPossibleP2 = { -5, -4, 5, 6 };

		for (int i = 0; i < positionPossibleP3.length; i++) {
			if (positionPossibleP3[i] < 1 || positionPossibleP3[i] > 51) {

			} else if (p3 == positionPossibleP3[i]) {
				if (tmpModP1 >= 1 && tmpModP1 <= 5) { // impair
					//System.out.println("test");
					if (plateau[p1 + positionPossibleP2[i]].getEquipe() != tour) {
						return p1 + positionPossibleP2[i];
					}
				} else { // pair
					if (plateau[p1 + positionPossibleP2[i] - 1].getEquipe() != tour) {
						return p1 + positionPossibleP2[i] - 1;
					}
				}
			}
		}
		return -1;
	}

	public static void menuPrincipal() {
		System.out.println("Bienvenue sur notre Jeux de Dame\n1 Joueur contre Ordinateur\n2 Joueur contre Joueur\n3 Exit");

		int saisieMenu = Utilitaires.readInt();

		switch (saisieMenu) {
		case 1:
			System.out.println("Joueur contre Ordinateur");
			// entrer le nom du joueur et l'enregistrer
			initUsernames(1);
			System.out.println("Entrer le nom de la Partie :");
			nomPartie = input.stringInput();
			Utilitaires.createFile(nomPartie);
			
			break;
		case 2:
			System.out.println("Joueur contre Joueur");
			initUsernames(2);
			System.out.println(joueur1.getNom());
			System.out.println("Entrer le nom de la Partie :");
			nomPartie = input.stringInput();
			Utilitaires.createFile(nomPartie);
			break;
		case 3:
			System.out.println("Au revoir");
			System.exit(0);
			break;
		}
	}

	void nextTour() {
		this.tour = !this.tour;
	}
}
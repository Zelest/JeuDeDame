package game;

import model.Pions;

import java.util.Iterator;

import model.Joueur;

import utilitaires.Utilitaires;
import utilitaires.Inputs;

public class Game {
	static boolean bot = false;
	Pions[] plateau = new Pions[51];
	static Joueur joueur1 = new Joueur();
	static Joueur joueur2 = new Joueur();

	boolean tour = true;
	int countTour = 0;
	static Inputs input = new Inputs();
	static final char[] row = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

	public void game() {
		menuPrincipal();
		Utilitaires.initPlateau(plateau);
		if (bot == true) {
			do {
				if (countTour % 2 == 0) {
					Utilitaires.printPlateau(plateau);
					deplacementPion();
					//botDeplacement();
					nextTour();
					System.out.println(countTour);
					countTour++;
					
				}else {
					Utilitaires.printPlateau(plateau);
					//deplacementPion();
					botDeplacement();
					nextTour();
					System.out.println(countTour);
					countTour++;
				}
			} while (true);
		}else {
			do {
				// clearScreen();
				Utilitaires.printPlateau(plateau);
				deplacementPion();
				nextTour();
			} while (true);
		}
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
				joueur1.setNom(input.stringInput());
			} while (joueur1.getNom() == "");
			
			System.out.println("nom joueur 2:");
			do {
				joueur2.setNom(input.stringInput());
			} while (joueur2.getNom() == "");
		}
	}

	public void deplacementPion() {
        int p1 =-1;
        int p3 =-1;
        int p31 = -1;
        System.out.println("Entrer la position du pion que vous voulez bouger (ex: A3 : ");
        String in ="";
        do {
            in = input.stringInput();
            p1=testInputChoixPions(in,true);
        } while (p1==0);  
        System.out.println("Entrer la nouvelle position du pion selectionné.");
        do {
            in = input.stringInput();
            p3 = testInputChoixPions(in,false);
        }while (p3==0);
        // Verifie les regles et retourne des positions
        int p2 =verifCapture(p1,p3);
        p31 = verifDeplacement(p1,p3);
        if(p2 !=-1) {
        	//System.out.println("test ligne 64");
        	this.plateau[p2]=null;
        	this.plateau[p3]=this.plateau[p1];
        	this.plateau[p1]=null;
        }else if (p31 != -1) {
        	this.plateau[p31]=this.plateau[p1];
        	this.plateau[p1]=null;
        }else {
        	System.out.println("Le pion sélectionné ne peut pas bouger.");
        	deplacementPion();
        }
    }
	
	public void botDeplacement() {
		String pions;
		int p1 =-1;
        int p3 =-1;
        int p31 = -1;
        do {
        	/*for (int i = 0; i < this.plateau.length; i++) {
				if (this.plateau[i].getEquipe() == this.tour) {
					
				}
			}*/
        	
        	
        	pions = Utilitaires.randomInt() + Utilitaires.randomChar();
        	System.out.println(pions);
            p1=testInputChoixPions(pions,true);
        } while (p1==0);  
        do {
        	pions = Utilitaires.randomInt() + Utilitaires.randomChar();
        	System.out.println("position souhaiter " + pions);
            p3 = testInputChoixPions(pions,false);
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
        }else {
        	System.out.println("Le pion sélectionné ne peut pas bouger.");
        	botDeplacement();
        }
	}
	
	// retourne nouvelle position de p1 (p3)
	public int verifDeplacement(int p1, int p3) {
		int[] positionPossibleP3 = { p1-5, p1-4, p1+5, p1+6 };
		
		for (int i = 0; i < positionPossibleP3.length; i++) {
			if (positionPossibleP3[i] < 1 || positionPossibleP3[i] > 51) {
				
			} else if (p3 == positionPossibleP3[i]) { // impair
				return this.plateau[positionPossibleP3[i]]==null ? positionPossibleP3[i]:-1;
			}else if(p3==positionPossibleP3[i]-1){ //pair
				return this.plateau[positionPossibleP3[i]-1]==null ? positionPossibleP3[i]-1:-1;
			}
		}
		//System.out.println("test ligne 89");
		return -1;
	}

	// Return true si les regles sont respectées sinon false.
	private int testInputChoixPions(String t, boolean testP1) {
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
			int lettre = 0; 
			for (int i = 0; i < row.length; i++) {
				if (row[i] == tArrayOfChar[indexLettre])
					lettre = i + 1;
			}
			//System.out.println((chiffre == 0 && lettre % 2 == 0) || chiffre % 2 == lettre % 2);
			//System.out.println(!testP1);
			//System.out.println(chiffre * 5 + (int) Math.ceil((double) lettre / 2));
			if ((chiffre == 0 && lettre % 2 == 0) || chiffre % 2 == lettre % 2) {
				if (!testP1 && this.plateau[chiffre * 5 + (int) Math.ceil((double) lettre / 2)] == null) {
					return chiffre * 5 + (int) Math.ceil((double) lettre / 2);
				} else if (this.plateau[chiffre * 5 + (int) Math.ceil((double) lettre / 2)].getEquipe() == this.tour) {
					System.out.println("le pion appartient a la bonne equipe");
					return chiffre * 5 + (int) Math.ceil((double) lettre / 2);
				} else {
					System.out.println("Mauvaise entrée.");
					return 0;
				}
			} else {
				System.out.println("Le pion n'existe pas.");
				return 0;
			}
		}
		return 0;
	}

	// Verifie si la position finale (p3) est valide
	// Et retourne l'index de p2
	int verifCapture(int p1, int p3) {
		if ((!(p3 > 0 && p3 <= 51) && this.plateau[p3] == null) || p1 == p3)
			return -1; // verif p3 dans plateau
		int tmpModP1 = p1 % 10;
		// haut gauche, haut droite, bas gauche, bas droite
		int[] positionPossibleP3 = { p1 - 11, p1 - 9, p1 + 9, p1 + 11 };
		int[] positionPossibleP2 = { -5, -4, 5, 6 };

		for (int i = 0; i < positionPossibleP3.length; i++) {
			if (positionPossibleP3[i] < 1 || positionPossibleP3[i] > 51) {

			} else if (p3 == positionPossibleP3[i]) {
				if (tmpModP1 >= 1 && tmpModP1 <= 5) { // impair
					System.out.println("test");
					if (this.plateau[p1 + positionPossibleP2[i]].getEquipe() != this.tour) {
						return p1 + positionPossibleP2[i];
					}
				} else { // pair
					if (this.plateau[p1 + positionPossibleP2[i] - 1].getEquipe() != this.tour) {
						return p1 + positionPossibleP2[i] - 1;
					}
				}
			}
		}
		return -1;
	}

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
			initUsernames(1);
			bot = true;
			break;
		case 2:
			System.out.println("Joueur contre Joueur");
			initUsernames(2);

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
		this.tour = !this.tour;
	}
}
package utilitaires;

import java.util.Scanner;

import game.Game;
import model.Pions;
import model.PionsBlanc;
import model.PionsNoir;

public class Utilitaires {
	public static void initPlateau(Pions[][] plateau) {
		//placement des pions noirs = 2
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j< 10; j++) {
				if (i%2!=0) {
					if (j%2==0) {
						plateau[i][j]= new PionsNoir(i, j, false);
						//Game.createPion(i,j, false, 2);
					}
				}else if (i%2==0) {
					if(j%2!=0) {
						plateau[i][j]= new PionsNoir(i, j, false);
						//Game.createPion(i,j, false, 2);
					}
				}
			}		
		}
		//placement des pions blancs = 1
		for (int i=6;i<10;i++) {
			for (int j=0;j<10;j++) {
				if (i%2!=0) {
					if (j%2==0) {
						plateau[i][j]= new PionsBlanc(i, j, false);
						//Game.createPion(i,j, false, true);
					}
				}else if (i%2==0) {
					if(j%2!=0) {
						plateau[i][j]= new PionsBlanc(i, j, false);
						//Game.createPion(i,j, false, 1);
					}
				}
			}
		}
	}
	
	public static void printPlateau(Pions[][] plateau) {
		System.out.println("  A B C D E F G H I J");
		for(int i = 0; i < 10; i++) {
			System.out.print(i);
			for(int j = 0; j < 10; j++) {
				System.out.print("|");
				if(plateau[i][j]==null) {
					System.out.print(" ");
				}else if (plateau[i][j].getEquipe()==true) {
					System.out.print("B");
				}else if (plateau[i][j].getEquipe()==false) {
					System.out.print("N");
				}
			}
			System.out.print("|");
			System.out.println(i);
		}
		System.out.println("  A B C D E F G H I J");
	}
	
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try{
			i = sc.nextInt();
		}
		catch(Exception e) {	
		}
		return i;
	}
	
	public static String giveString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	public static char readChar() {
		Scanner sc = new Scanner(System.in);
		char s = sc.next().charAt(0);
		return s;
	}
	
	public static char tradPions(char x) {
		if (x == 'A') {
			x = 1;
		}else if (x == 'B') {
			x = 2;
		}else if (x == 'C') {
			x = 3;
		}else if (x == 'D') {
			x = 4;
		}else if (x == 'E') {
			x = 5;
		}else if (x == 'F') {
			x = 6;
		}else if (x == 'G') {
			x = 7;
		}else if (x == 'H') {
			x = 8;
		}else if (x == 'I') {
			x = 9;
		}else {
			x = 10;
		}
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

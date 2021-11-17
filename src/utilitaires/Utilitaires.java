package utilitaires;

import model.Pions;
import model.PionsBlanc;
import model.PionsNoir;

public class Utilitaires {
	public static void initPlateau(Pions[][] plateau) {
		//placement des pions noirs
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j< 10; j++) {
				if (i%2!=0) {
					if (j%2==0) {
						plateau[i][j]= new PionsNoir();
					}
				}else if (i%2==0) {
					if(j%2!=0) {
						plateau[i][j]= new PionsNoir();
					}
				}
			}		
		}
		//placement des pions blancs
		for (int i=6;i<10;i++) {
			for (int j=0;j<10;j++) {
				if (i%2!=0) {
					if (j%2==0) {
						plateau[i][j]= new PionsBlanc();
					}
				}else if (i%2==0) {
					if(j%2!=0) {
						plateau[i][j]= new PionsBlanc();
					}
				}
			}
		}
	}
	
	public static void printPlateau(Pions[][] plateau) {
		System.out.println("  A B C D E F G H I J");
		for(int i = 0; i < 10; i++) {
			System.out.print(9-i);
			for(int j = 0; j < 10; j++) {
				System.out.print("|");
				if(plateau[i][j]==null) {
					System.out.print(" ");
				}else if (plateau[i][j].getEquipe()==1) {
					System.out.print("B");
				}else if (plateau[i][j].getEquipe()==2) {
					System.out.print("N");
				}
			}
			System.out.print("|");
			System.out.println(9-i);
		}
		System.out.println("  A B C D E F G H I J");
	}
}

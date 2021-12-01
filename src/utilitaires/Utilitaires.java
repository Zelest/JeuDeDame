package utilitaires;

import java.util.Scanner;

import game.Game;
import model.Pions;
import model.PionsBlanc;
import model.PionsNoir;

public class Utilitaires {
	public static void initPlateau(Pions[] plateau) {
		for (int i = 1; i < 21; i++) {
			plateau[i] = new PionsNoir(i);
		}
		for (int i = 31; i < 51; i++) {
			plateau[i] = new PionsBlanc(i);
		}
	}

	public static void printPlateau(Pions[] plateau) {
		int count = 0;
		System.out.println("  A B C D E F G H I J");
		for (int i = 1; i < 51; i++) {
			if (i == 1 || i % 10 == 1) {
				System.out.print(count);
				System.out.print("| |");
			} else if (i == 6 || i % 10 == 6) {
				System.out.print(count);
				System.out.print("|");
			}

			if (plateau[i] == null) {
				System.out.print(" ");
			} else {
				System.out.print(plateau[i].getSkin());
			}
			// Les cases blanches ou saut à la ligne
			if (i % 5 != 0) {
				System.out.print("| |");
			} else if (i == 5 || i % 10 == 5) {
				System.out.print("|");
				System.out.println(count);
				count++;
			} else {
				System.out.print("| |");
				System.out.println(count);
				count++;
			}
		}
		System.out.println("  A B C D E F G H I J");
	}

	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = sc.nextInt();
		} catch (Exception e) {
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

}

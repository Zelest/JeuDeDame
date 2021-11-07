package utilitaires;

public class Utilitaires {
	public static void initPlateau(char[][] plateau) {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j< plateau[i].length; j++) {
				plateau[i][j] = '0';
			}
		}
	}
	
	public static void printArray2D(char[][] array2DToPrint) {
		System.out.println("");
		for(int i = 0; i < array2DToPrint.length; i++) {
			for(int j = 0; j < array2DToPrint[i].length; j++) {
				System.out.print(" | " + array2DToPrint[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println("");
	}
}

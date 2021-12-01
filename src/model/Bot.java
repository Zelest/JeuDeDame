package model;

public class Bot {
	// les pions du bot sont noirs
	// 0 à 19
	// -1 si le pion existe plus
	int[] tableauPions = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	// 5 6
	// 9 11

	public void supprPions(int index) {
		for (int i = 0; i < tableauPions.length; i++) {
			if (tableauPions[i] == index) {
				tableauPions[i] = -1;
				break;
			}
		}
	}

	int plusGrand(int depart) {
		int resultat = -1;
		for (int i = tableauPions.length - 1; i >= 0; i--) {
			if (tableauPions[i] > resultat && i != depart)
				resultat = i;
		}
		return resultat;
	}

	public Pions[] deplacement(Pions[] plateau, int index) {
		if (index == 0) {
			index = plusGrand(0);
		} else {
			index = plusGrand(index);
		}
		System.out.println(index);
		if (index == -1)
			System.out.println("AAAAAAAAAAAA");
		int[] positionP2 = { tableauPions[index] + 5, tableauPions[index] + 6 };
		int[] positionP3 = { tableauPions[index] + 9, tableauPions[index] + 11 };

		for (int i = 0; i <= 1; i++) {
			// pion adverse a porté
			if (positionP3[i] < 1 || positionP3[i] > 51) {

			} else if (plateau[positionP2[i]] != null && plateau[positionP2[i]].getEquipe() == true) {
				if (plateau[positionP3[i]] == null) {
					plateau[positionP2[i]] = null;
					plateau[positionP3[i]] = plateau[tableauPions[index]];
					plateau[tableauPions[index]] = null;
					tableauPions[index] = positionP3[i];
					if (index >=46&&index<=50) {
						plateau[index]=new DameNoir(index);
					}
					return plateau;
				}
			} else if (plateau[positionP2[i]] == null) {
				// pas de pion donc deplacement
				plateau[positionP2[i]] = plateau[tableauPions[index]];
				plateau[tableauPions[index]] = null;
				tableauPions[index] = positionP2[i];
				return plateau;
			}
		}
		return deplacement(plateau, index);
	}
}

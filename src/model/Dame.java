package model;

public class Dame extends Pions {
	static int[][] c ={ {-6,-5,4,5}, {-5,-4,5,6}}; //pair ,impair
	public Dame(int index, boolean equipe, char skin) {
		super(index, equipe, skin);
		// TODO Auto-generated constructor stub
	}
	public static int[][] getPossibilite(int index) {
		int[][] res= new int[4][10];
		int mod =index%5;
		int calcul =0;
		int j=0;
		int k=0;
		
		if((mod>=6&&mod<=9) || mod==0) {//pair
			for (int i=0;i<c[0].length;i++) {
					do {
						res[i][j]=index+c[k][i];
						index=index+c[k][i];
						j++;
						k++;
						if (k==2) k=0;
					}
					while(!(calcul%10==6)&&!(calcul%10==5)&&!(calcul>=46&&calcul<=50)&&!(calcul>=1&&calcul<=5));

			}
		}else {
			k++;
			for (int i=0;i<c[1].length;i++) {
				do {
					res[i][j]=index+c[k][i];
					index=index+c[k][i];
					j++;
					k++;
					if (k==2) k=0;
				}
				while(!(calcul%10==6)&&!(calcul%10==5)&&!(calcul>=46&&calcul<=50)&&!(calcul>=1&&calcul<=5));
			}
		}
		return res;
	}
	public static boolean existe(int[] tableau,int p3) {
		for(int i=0;i<tableau.length;i++) {
			if (p3==tableau[i]) return true;
		}
		return false;
	}
	public static boolean capture(int[] tableau,int indexTableau1D,int p2,int p3) {
		int indexP2=0;
		int mod =p3%5;
		int res=0;
		if((mod>=6&&mod<=9) || mod==0) {//pair
			//parcour le tableau pour trouver l'index de p2
			for(int i=0;i<tableau.length;i++) {
				if (p2==tableau[i]) {
					indexP2=i;
				}
			}
			res=p3-c[0][indexTableau1D];
			if(res==tableau[indexP2]&&res==p2) {
				return true;
			}else {
				return false;
			}
		}else {
			//parcour le tableau pour trouver l'index de p2
			for(int i=0;i<tableau.length;i++) {
				if (p2==tableau[i]) {
					indexP2=i;
				}
			}
			res=p3-c[1][indexTableau1D];
			if(res==tableau[indexP2]&&res==p2) {
				return true;
			}else {
				return false;
			}
		}
	}
	public static boolean deplacement(Pions[] plateau,int[] tableau,int indexTableau1D,int p3) {
		return false;
	}
}

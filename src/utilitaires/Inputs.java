package utilitaires;

import java.util.Scanner;

public class Inputs {
	Scanner scan = new Scanner(System.in);
	public String stringInput() {
		String result = "";
		try {
			result= this.scan.next();
		}catch(Exception err){
			System.out.println(err);
			this.scan.nextInt();
		}
		return result;
	}
	public int intInput() {
		Integer result =0;
		try {
			result = scan.nextInt();
		}catch(Exception err){
			System.out.println("ENTREE INCORRECT");
			scan.nextLine();
		}
		return result;
	}
	public void close() {
		scan.close();
	}
}

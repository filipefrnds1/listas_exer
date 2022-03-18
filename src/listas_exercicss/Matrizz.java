package listas_exercicss;

import java.util.Locale;
import java.util.Scanner;

public class Matrizz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("The number int: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		int[][] mat = new int[n][n];
		int neg = 0;
		
		for(int i = 0; i < n; i++) {			
			for(int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Main diagonal: ");
		for(int i = 0; i < n; i++) {			
			for(int j = 0; j < n; j++) {
				if(i == j) {
					System.out.print(mat[i][j] + " ");
				}
				if(mat[i][j] < 0) {
					neg += 1;
				}
			}
		}
		System.out.println();
		System.out.println("Negative numbers = " + neg);
		
		
		sc.close();

	}

}

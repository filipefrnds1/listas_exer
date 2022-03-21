package listas_exercicss;

import java.util.Locale;
import java.util.Scanner;

public class ExerMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int m,n;
		System.out.println("Informe um valor inteiro: ");
		m = sc.nextInt();
		//sc.nextLine();
		System.out.println("Informe outro valor inteiro: ");
		n = sc.nextInt();
		//sc.nextLine();
						
		int[][] mat = new int[m][n];
		
		System.out.println("Informe um valor para X: ");
		int x = sc.nextInt();
		//sc.nextLine();
		
		for(int i = 0;i < m; i++) {
			for(int j = 0;j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i < m; i++) {
			for(int j = 0;j < n; j++) {
				if(mat[i][j] == x) {
					if(j > 0) {
						System.out.println("A esquerda: " + mat[i][j-1] );
					}
					if(i > 0) {
						System.out.println("Acima " + mat[i-1][j] );
					}
					if(j < mat[i].length-1) {
						System.out.println("A direita: " + mat[i][j+1] );
					}
					if(i < mat.length-1) {
					System.out.println("Abaixo: " + mat[i+1][j] );
					}
					
				}
				
			}
		}
		
		sc.close();
	}

}

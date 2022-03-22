package listas_exercicss;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import algg.EmployeFinal;

public class MoreOne1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<EmployeFinal> list = new ArrayList<>();
		
		System.out.print("Informe um valor para N: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		EmployeFinal emp;
		
		for(int i = 0; i < n; i++) {
			System.out.print("Informe o id número" + (i+1) + " :");
			Integer id = sc.nextInt();
			
			
			while(hasId(list,id)) {
				System.out.print("Error, o id já existe, informe outro: ");
				id = sc.nextInt();			
				
			}
			sc.nextLine();
			System.out.print("Informe o nome: ");
			String name = sc.nextLine();
			System.out.print("Informe o salário: ");
			Double salary = sc.nextDouble();
			
			emp = new EmployeFinal(id,name,salary);
			list.add(emp);
			
		}
		
		System.out.print("Informe o id para receber um aumento: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Integer poss = pos(list,id);
		
		if(poss == null) {
			System.out.println("Id não existe !");
		}else {
			System.out.print("Informe a porcentagem para o aumento: ");
			int perc = sc.nextInt();
			list.get(poss).moreSalary(perc);
			
		}
		
		for(EmployeFinal obs : list) {
			System.out.println(obs);
		}
		
		
		
		
		sc.close();
	}
	
	public static Integer pos(List<EmployeFinal> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
			
		}	
		return null;
	}
	
	
	public static boolean hasId(List<EmployeFinal> list, int id) {
		EmployeFinal emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

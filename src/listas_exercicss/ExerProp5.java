package listas_exercicss;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import algg.Employe;

public class ExerProp5 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<Employe> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			while(hasId(list,id)) {
				System.out.print("This id exist !, Other ID please: ");
				id = sc.nextInt();
				sc.nextLine();
			}
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employe emp = new Employe(id,name,salary);
			list.add(emp);
			
		}
		
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer id = sc.nextInt();
		//sc.nextLine();
		
		Integer pos = percent(list,id);
		
		if(pos == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			Integer perc = sc.nextInt();
			list.get(pos).moreSalary(perc);
		}
		
		for(Employe obj : list) {
			System.out.println(obj);
		}
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}
	
	public static Integer percent(List<Employe> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employe> list, int id) {
		Employe emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
				return emp != null;
	}
 }

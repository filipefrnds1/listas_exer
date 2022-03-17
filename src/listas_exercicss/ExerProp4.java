package listas_exercicss;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import algg.Employeee;

public class ExerProp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		Integer n = sc.nextInt();
		sc.nextLine();
		
		List<Employeee> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #" + (1+i) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			while(hasId(list,id)) {
				System.out.println("Error, this id had yet! Answer new ID: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			Employeee emp = new Employeee(id,name,salary);
			list.add(emp);
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int idd = sc.nextInt();
		
		Integer perc = percent(list,idd); 
				
		if(perc == null) {
			System.out.println("This id does not exist! ");
		}else {
			System.out.println("Enter the percentage: ");
			Double percent = sc.nextDouble();
			list.get(perc).plusSalary(percent);
		}
		
		
		
		System.out.println("List of employees: ");
		for(Employeee obj : list) {
			System.out.println(obj);
		}
		
		
		
		sc.close();
	}
	
	public static Integer percent(List<Employeee> list, int id) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
			
		}
		return null;
	}
	
	public static boolean hasId(List<Employeee> list, Integer id) {
		Employeee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

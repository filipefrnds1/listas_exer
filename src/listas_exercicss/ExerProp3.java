package listas_exercicss;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import algg.Employee;

public class ExerProp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Integer n;
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while(hasId(list,id)) {
				System.out.print("Este id já existe, Tente novamente: ");
				id = sc.nextInt();
			}
		    sc.nextLine();		
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emps = new Employee(id,name,salary);
			list.add(emps);
						
		}
		
		System.out.print("Enter the employee id that have salary increase: ");
		Integer idd = sc.nextInt();
		sc.nextLine();
		
		Integer pos = posit(list,idd);
		
		if(pos == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			list.get(pos).aumentSalary(percentage);
		}
		
		
		System.out.println("List of employees: ");
		for(Employee obj : list) {
			System.out.println(obj);
		}
		
		
		
		
		
		
		
		
		sc.close();
		
	}
	
	public static Integer posit(List<Employee> list, Integer id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
			
		}
		return null;
		
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

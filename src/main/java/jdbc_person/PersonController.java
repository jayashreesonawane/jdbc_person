package jdbc_person;

import java.sql.SQLException;
import java.util.Scanner;

public class PersonController {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		PersonCRUD crud = new PersonCRUD();
		
		System.out.println("Enter the choice \n1.Save Person");
		
		System.out.println("2.Fetch Person");
		
		System.out.println("3.Update Person");
		
		System.out.println("4.Delete Person");
		
		int choice = scanner.nextInt();
		
		switch (choice) 
		{
//			1. Insert data into the table
			case 1:
			{
				System.out.println("Enter the id : ");
				int id = scanner.nextInt();
				
				System.out.println("Enter the name : ");
				String name = scanner.next();
				
				System.out.println("Enter the age : ");
				int age = scanner.nextInt();
				
				System.out.println("Enter the phone : ");
				long phone = scanner.nextLong();
				
				System.out.println("Enter the address : ");
				String address = scanner.next();
				
				crud.savePerson(id, name, age, phone, address);
			}
			
				break;
				
//			2. Fetch data from the table
			case 2:
			{
				System.out.println("Enter the id : ");
				int id = scanner.nextInt();
				
				crud.readPerson(id);
			}
			break;
			
//			3. Update data in the table
			case 3:
			{
				System.out.println("Enter the id : ");
				int id = scanner.nextInt();
				
				System.out.println("Enter the name : ");
				String name = scanner.next();
				
				System.out.println("Enter the age : ");
				int age = scanner.nextInt();
				
				System.out.println("Enter the phone : ");
				long phone = scanner.nextLong();
				
				System.out.println("Enter the address : ");
				String address = scanner.next();
				
				crud.updatePerson(id, name, age, phone, address);
			}
			break;
			
//			4. Delete data from the table
			case 4:
			{
				System.out.println("Enter the id : ");
				int id = scanner.nextInt();
				
				crud.deletePerson(id);
			}
			
				break;
			
			default:
				break;
		}
	}

}

package com.person_Details.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.person_Details.dao.PersonDao;
import com.person_Details.dao.PersonDaoImpl;
import com.person_Details.dto.Person;


public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			int id = 0;
			String name = "";
			int age = 0;
			char gender = '\u0000';
			long phone = 0;
			String status = "";
			Person person = null;
			
			PersonDao pd = new PersonDaoImpl();
			
			System.out.println("===================================================");
			System.out.println("*******Person Details********");
			System.out.println("===================================================");
			
			while (true)
			{
				System.out.println();
				System.out.println("1. ADD Person");				
				System.out.println("2. UPDATE Person");
				System.out.println("3. View All");
				System.out.println("4. Find Person By Id");
				System.out.println("5. DELETE Person by Id");
				System.out.println("6. EXIT");
				System.out.print("Select from Above OPTION   : ");
				int option = Integer.parseInt(br.readLine());
				
				switch (option)
				{
					case 1:
					{
						System.out.println("You Selected ADD Module");
						System.out.print("Enter Person Id                   : ");
						id = Integer.parseInt(br.readLine());
						System.out.print("Enter Person Name                 : ");
						name = br.readLine();
						System.out.print("enter Person's Age                : ");
						age = Integer.parseInt(br.readLine());
						System.out.print("Enter Person's Gender             : ");
						String gen = br.readLine();
						if (br.toString().equalsIgnoreCase("F"))
						{
							gender = 'F';
						}
						else {
							gender = 'M';
						}
						System.out.print("Enter Person's Phone              : ");
						phone = Long.parseLong(br.readLine());
						
						person = new Person();
						person.setId(id);
						person.setName(name);
						person.setAge(age);
						person.setGender(gender);
						person.setPhone(phone);
						
						status = pd.save(person);
						
						if (status.equalsIgnoreCase("success"))
						{
							System.out.println("Status : Person Inserted Successfully");
						}
						else if (status.equalsIgnoreCase("exist"))
						{
							System.out.println("Status : Person ID Existed Already");
						}
						else
						{
							System.out.println("Status : Person Insertion Failure");
						}
						
						break;
					}
					
					case 2:
					{
						System.out.println("You Selected Update Module");
						System.out.print("Enter Person Id                   : ");
						id = Integer.parseInt(br.readLine());
						System.out.print("Enter Person Name                 : ");
						name = br.readLine();
						System.out.print("enter Person's Age                : ");
						age = Integer.parseInt(br.readLine());
						System.out.print("Enter Person's Gender             : ");
						String gen = br.readLine();
						if (br.toString().equalsIgnoreCase("F"))
						{
							gender = 'F';
						}
						else {
							gender = 'M';
						}
						System.out.print("Enter Person's Phone              : ");
						phone = Long.parseLong(br.readLine());
						
						person = new Person();
						person.setId(id);
						person.setName(name);
						person.setAge(age);
						person.setGender(gender);
						person.setPhone(phone);
						
						status = pd.update(person);
						
						if (status.equalsIgnoreCase("success"))
						{
							System.out.println("Status : Person Updated Successfully");
						}
						else if (status.equalsIgnoreCase("Noexist"))
						{
							System.out.println("Status : Person ID NOT Existed");
						}
						else
						{
							System.out.println("Status : Person Insertion Failure");
						}
						
						break;
					}
					
					case 3 :
					{
						System.out.println("You Selected VIEW Module");
						pd.findAll();
						break;
					}
					
					case 4:
					{
						System.out.println("You Selected SEARCH By ID Module");
						System.out.print("Enter Person Id                   : ");
						id = Integer.parseInt(br.readLine());
						
						person = pd.findById(id);
						
						if(person == null)
						{
							System.out.println("\nStatus : Student NOT EXISTED");
						}
						else {
							System.out.println("\nStatus : Person EXISTED");
							System.out.println("Person Details");
							System.out.println("------------------------------");
							System.out.println("Person Id           : "+person.getId());
							System.out.println("Person Name         : "+person.getName());
							System.out.println("Person Age          : "+person.getAge());
							System.out.println("Person Gender       : "+person.getGender());
							System.out.println("Person  Phone no.   : "+person.getPhone());
						}
						
						break;
					}
					case 5:
					{
						System.out.println("You Selected DELETE By Id Module");
												
						System.out.print("Enter Person Id                   : ");
						id = Integer.parseInt(br.readLine());
						
						status = pd.delete(id);
						
						if (status.equalsIgnoreCase("Success"))
						{
							System.out.println("Status : Person DELETED Successfully");
						}
						if (status.equalsIgnoreCase("noexist"))
						{
							System.out.println("Status : Person NOT Existed");
						}
						if (status.equalsIgnoreCase("Failure"))
						{
							System.out.println("Status : Person Deletion Failure");
						}
						
						break;
					}
					case 6:
						System.out.println("******** THANK YOU for Using Person Details ******");						
						return;
					default:
						System.out.println("INVALID OPTION : Choose between [1,2,3,4 and 5]");
						break;
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

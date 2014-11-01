import java.io.*;
		//comentari de prova al git
public class MainApp {

	private static User arrayUsers[] = new User[10];
	private static Course arrayCourses[]= new Course[10];
	private static int numUsers = 0;
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		int option = showMenu();
		while(option != 0){
			switch(option){
				case 1:
					User u = addNewUser();
					arrayUsers[numUsers] = u;					
					numUsers++;
					break;
				case 2:
					boolean readingError;
					do{ 
						System.out.println("Which user? (insert array index)");
						BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
						try{
							int index = Integer.parseInt(buffer.readLine());
							modifyUser(arrayUsers[index]);
							readingError = false;
						}catch(Exception e){
							System.out.println("There is no user in the given index");
							readingError = true;
						}
					}while(readingError);
					break;
				case 3: addCourse();
						break;
					
				case 4:	deleteCourse();
						break;
				case 0:
					break;
			}
			option = showMenu();
		}

	}

	/**
	 * Displays a menu and returns option selected
	 * @return option selected
	 */
	public static int showMenu() {
		int result = -1;
		boolean readingError = true;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		while(readingError){
			System.out.println("\tMenu");
			System.out.println("==========");
			System.out.println("1. - Add new User");
			System.out.println("2. - Modify existing User");
			System.out.println("3. - Add course");
			System.out.println("4. - Delete course");
			System.out.println("0. - Exit");
			try{
				String option = buffer.readLine();	
				result = Integer.parseInt(option);
				readingError = false;
			}catch(Exception e){
				readingError = true;
			}
		}		
		return result;
	}

	/**
	 * Asks user for User properties and creates a new one
	 * @return
	 */
	public static User addNewUser() {
		int id, age; id = age = -1;
		String name, surname; name = surname = "";
		boolean readingError;
		do {
			try{
				BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("id:");
				id = Integer.parseInt(buffer.readLine());
				System.out.println("Name:");
				name = buffer.readLine();
				System.out.println("Surname:");
				surname = buffer.readLine();
				System.out.println("age:");
				age = Integer.parseInt(buffer.readLine());
				readingError = false;
			}catch(Exception e){
				System.out.println("Incorrect value!!");
				readingError = true;
			}
		} while(readingError);
		return new User(id, name, surname, age);
	}

	public static void modifyUser(User user){
		System.out.println("===== Current user data =====");
		System.out.println(user.toString());
		System.out.println("===== Insert new data =====");
		User newOne = addNewUser();
		user.setId(newOne.getId());
		user.setName(newOne.getName());
		user.setSurname(newOne.getSurname());
		user.setAge(newOne.getAge());
		System.out.println("Changes done!");
	}
	
	public static void addCourse()throws Exception{
		boolean readingError;
		do{
		try{
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
				System.out.println("Write the id of course:");
				int id = Integer.parseInt(buffer.readLine());
		
				System.out.println("Write the name of course:");
				String nameGroup = buffer.readLine();
								
				readingError = false;
							
		 }catch(Exception e){
				System.out.println("Incorrect value!!");
				readingError = true;
			}
		}while(readingError);		 
		
	}
	
	public static void deleteCourse() throws Exception{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		boolean deleted =false;
		int posicion= -1;
				
		do{			
			System.out.println("Insert the id of the course to delete: ");
			int id = Integer.parseInt(buffer.readLine());
	
						
			//2- delete course
			try{	
				for (int i = 0; i < arrayCourses.length; i++){
					if(arrayCourses[i]!=null && arrayCourses[i].getId() == id){
						posicion= i;
					}	
				} if (posicion==-1) throw new Exception("El id no existe!"); 
				
				arrayCourses[posicion]= null;
				deleted= true;
			} catch(Exception e){
					System.out.println(e.getMessage());
					deleted=false;  
				}
		}while(!deleted);
	}

}

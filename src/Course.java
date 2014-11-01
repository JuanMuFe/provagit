public class Course{
	private static Course arrayCourses[]= new Course[10];
	private int id;
	private String nameGroup;

	//constructor comentari to save a new commit
	public Course(int id, String nameGroup){
		this.id= id;
		this.nameGroup= nameGroup;		
	}
		
	//getters
	public int getId() {
	    return this.id;
	}
	
	public String getNameGroup() {
	    return this.nameGroup;
	}		
	
	//setters
	public void setId(int id) {
	    this.id = id;
	}
	
	public void setNameGroup(String nameGroup) {
	    this.nameGroup = nameGroup;
	}	
		
	
}

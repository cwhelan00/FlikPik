package model;

public class Actor {
	private String id, name;
	
	// getters and setters for properties used for injection
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}


class DVD{
    private String name;
    Person owner;
    Person renter;
    
    public DVD(String name, Person p){
	this.name = name;
	this.owner = p;
    }
    public DVD(String name, Person p, Person n){
	this.name = name;
	this.owner = p;
	this.renter = n;
    }
    public boolean isLentOut(){
	if(renter == null)
	    return false;
	return true;
	
    }
    public Person rentedBy(){
	if(renter != null){
	    return renter;
	}
	return null;
    }
    public void setRenter(Person p){
	this.renter = p;
    }
    public String toString(){
	return this.name;
    }
}

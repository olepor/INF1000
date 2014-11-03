
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
	this.p = p;
	this.n = n;
    }
    public String toString(){
	return this.name;
    }
}

import java.util.*;

class Person {
    private String name;
    HashMap<String, DVD> archive = new HashMap<>();
    HashMap<String, DVD> lArchive = new HashMap<>();
    
    public Person(String name){
	this.name = name;
    }
    public String toString(){
	return this.name;
    }
    public void addDVD(String name, DVD dvd){
	if(archive.containsKey(name)){
	    return;
	} else {	    
	    archive.put(name, dvd);
	}
    }
    public void addDVD(String name, DVD dvd, Person n){
	if(lArchive.containsValue(name)){
	    return;
	} else {
	    lArchive.put(name, dvd);
	}
    }
    public DVD getDVD(String name){
	if(this.archive.containsKey(name))
	    return archive.get(name);
	return null;
	
    }
    public void borrowDVD(String name, Person from){
	if(from.hasDVD(name)){
	    DVD dvd = from.getDVD(name);
	    this.lArchive.put(dvd.toString(), dvd);
	} else {
	    // Does not have the dvd
	}
    }
    public boolean hasDVD(String name){
	if(this.archive.containsKey(name) && this.archive.get(name).isLentOut() ==  false)
	    return true;
	return false;
    }

    public void showArchive(){
	for(Map.Entry<String, DVD> entry: archive.entrySet()){
	    String out = entry.getKey();
	    if(archive.get(out).isLentOut()){
		System.out.println(out);
		System.out.println(archive.get(out).rentedBy());
	    } else {
		System.out.println(out);
	    }	    
	}
	System.out.println();
    }
}

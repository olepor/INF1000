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
	    if(name.charAt(0) == '*'){
		lArchive.put(name.substring(1), )
	    }
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

    public void showArchive(){
	for(Map.Entry<String, DVD> entry: archive.entrySet()){
	    System.out.println(entry.getKey());
	}
    }
}

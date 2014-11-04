import java.util.*;

class Person {
    private String name;
    HashMap<String, DVD> archive = new HashMap<>();
    HashMap<String, DVD> lArchive = new HashMap<>();
    HashMap<String, DVD> bArchive = new HashMap<>();
    
    public Person(String name){
	this.name = name;
    }
    public String toString(){
	return this.name;
    }
    public int archiveSize(){
	return archive.size();
    }
    public int lArchiveSize(){
	return lArchive.size();
    }
    public int bArchiveSize(){
	return bArchive.size();
    }
    public boolean addDVD(String name, DVD dvd){
	if(archive.containsKey(name)){
	    return false;
	} else {	    
	    archive.put(name, dvd);
	    return true;
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
	if(this.archive.containsKey(name)){
	    DVD dvd = archive.get(name);
	    archive.remove(name);
	    return dvd;
	}	    
	return null;
	
    }
    public boolean borrowDVD(String name, Person from){
	if(from.hasDVDInArchive(name)){
	    DVD dvd = from.getDVD(name);
	    dvd.setRenter(this);
	    this.bArchive.put(dvd.toString(), dvd);
	    from.lArchive.put(dvd.toString(), dvd);
	    return true;
	} else {
	    return false;
	}
    }
    public boolean hasDVDInArchive(String name){
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

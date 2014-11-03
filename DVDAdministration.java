import java.util.*;
import java.io.*;

// TODO make sure the addDVD class and addPerson class only takes a String, and the
// creates the obkects within the methods


class DVDAdministration {

    HashMap<String, Person> personMap = new HashMap<>();

    public void readFile(File file) throws Exception {
	Scanner myScanner = new Scanner(file);
	while(myScanner.hasNextLine()){
	    System.out.println("Now reading the line");
	    String line = myScanner.nextLine();
	    //Check for a blank line
	    System.out.println("The line-line is" + line);
	    if(line.isEmpty()){
		// A new dataset will be read in
		System.out.println("The line is empty");
		continue;
	    } else {
		// We are reading a new dataset
		System.out.println("The line is not empty");
		Person p = new Person(line);
		readDataFromFile(myScanner, p);
		addPerson(p);
		
	    }
	    
	}
	
	
    }

 


    public void readDataFromFile(Scanner in, Person p) {
	DVD dvd;
	String nName;
	Person n;
	String dvdName = in.nextLine();
	if(dvdName.isEmpty()){
	    System.out.println("In does not have a next line");
	    return;
	} else {
	    if(dvdName.charAt(0) == '*'){
		addPerson(new Person(in.nextLine()));		
		addDVD(dvdName, new DVD(dvdName.substring(1)), );
		readDataFromFile(in, p);
	    } else {
		dvd = new DVD(dvdName);	  
		addDVD(p, dvd);
		readDataFromFile(in, p);
	    }	   
	}
    }

    public void addPerson(Person p){
	if(personMap.containsValue(p)){
	    return;
	} else {
	    personMap.put(p.toString(), p);
	}
    }
    public void addDVD(String dvdName, Person p){
	System.out.println("Now adding the dvd: " + dvd + " to the person: " + p);
	DVD dvd = new DVD(dvdName, p);
	if(personMap.containsValue(p)){	    
	    p.addDVD(dvd.toString(), dvd);
	}
    }
    public void addDVD(String dvdName, Person p, Person n){
	System.out.println("Adding the lent out dvd");
	DVD dvd;
	if(personMap.containsValue(p)){
	    dvd = new DVD(dvdName, p, n);
	    // Add the lent out dvd
	    p.addDVD(dvd.toString(), dvd, n);
	    
	    
	}
    }

    public void showList(){

	for (Map.Entry<String, Person> entry : personMap.entrySet()) {
	    System.out.println(entry.getKey() );
	    entry.getValue().showArchive();
	    }
    }
}


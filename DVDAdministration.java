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
		dvdName = dvdName.substring(1);
		nName = in.nextLine();
		n = new Person(nName);
		dvd = new DVD(dvdName, p, n);
		addPerson(n);
		p.addDVD(dvdName, dvd);
		n.borrowDVD(dvdName, p);
		readDataFromFile(in, p);
	    } else {
			  
		p.addDVD(dvdName, new DVD(dvdName, p));
		readDataFromFile(in, p);
	    }	   
	}
    }

    public boolean addPerson(Person p){
	if(personMap.containsValue(p)){
	    return false;
	} else {
	    personMap.put(p.toString(), p);
	    return true;
	}
    }

    public Person getPerson(String name){
	if(personMap.contains(name))
	    return personMap.get(name);
	return null;
    }
      

    public void showList(){

	for (Map.Entry<String, Person> entry : personMap.entrySet()) {
	    System.out.println(entry.getKey() );
	    entry.getValue().showArchive();
	    }
    }
}


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
		n = getPerson(nName);
		dvd = new DVD(dvdName, p);
		p.addDVD(dvdName, dvd);
		if(n == null){
		    n = new Person(nName);
		    if(n.borrowDVD(dvdName, p)){
			addPerson(n);
		    } else {
			System.out.println("Something went wrong");
		    }
		} else {
		    n.borrowDVD(dvdName, p);
		}
	    } else {
		if(personMap.containsKey(p.toString())){
		    p = getPerson(p.toString());
		    p.addDVD(dvdName, new DVD(dvdName, p));
		    readDataFromFile(in, p);
		} else {
		    p.addDVD(dvdName, new DVD(dvdName, p));
		    readDataFromFile(in, p);
		}	
	    }	   
	}
    }

    public boolean addPerson(Person p){
	if(personMap.containsKey(p.toString())){
	    return false;
	} else {
	    personMap.put(p.toString(), p);
	    return true;
	}
    }

    public Person getPerson(String name){
	if(personMap.containsKey(name))
	    return personMap.get(name);
	return null;
    }
      
   

    public void showList(){

	for (Map.Entry<String, Person> entry : personMap.entrySet()) {
	    System.out.println(entry.getKey() );
	    entry.getValue().showArchive();
	    }
    }
    public void showOverView(){
	for(Map.Entry<String, Person> entry : personMap.entrySet()){
	    Person p = entry.getValue();
	    System.out.println("The person " + p + " has " + p.archiveSize() + " dvd's in his/hers archive, with " + p.lArchiveSize() + "dvd's lent out, and " + p.bArchiveSize() + " dvd's borrowed" );
	}
    }

    public void runAdminProcess(){
	System.out.println("Hello and welcome to the dvd administration system");
	String userAction;
	do{
	    Scanner myScanner = new Scanner(System.in);
	    System.out.println("Please enter what you would like to do:");
	    System.out.println();
	    System.out.println("In order to add a new person, enter N");
	    System.out.println("In order to buy a new dvd, enter K");
	    System.out.println("In order to borrow a dvd, enter L");
	    System.out.println("In order to show a complete overview, enter O");
	    System.out.println("In order to return a borrowed Dvd, enter R");
	    System.out.println("To show a persons archive, enter V");
	    userAction = myScanner.nextLine();
	    String name;
	    String dvdName;
	    Person p;
	    Person n;
	    switch(userAction){
		
	    case "N":
		System.out.println("what is the name of the Person you would like to add?");
		name = myScanner.nextLine();
		p = new Person(name);		
		if(addPerson(p)){
		    System.out.println("The person " + name + " was added to the archive");
		} else {
		    System.out.println("The person " + name + " already exists in our system");
		}
		break;
		// Case K
	    case "K":
		System.out.println("Who is buying a new dvd?");
		name = myScanner.nextLine();
		p = getPerson(name);
		if(p != null){
		    System.out.println("What is the name of the dvd that he/she would like to buy?");		    
		    dvdName = myScanner.nextLine();
		    if(p.addDVD(dvdName, new DVD(dvdName, p))){
			System.out.println("The dvd was added to " + name +"'s archive");
		    } else {
			System.out.println("The dvd is already in " + name + "'s archive");
		    }
		    
		} else {
		    System.out.println("The person is not found in the archives, please add him/her first");
		}
		break;
		// Case L
	    case "L":
		System.out.println("Who wants to borrow a dvd?");
		name = myScanner.nextLine();
		p = getPerson(name);
		
		if(p != null){
		    System.out.println("Who does he/she want to borrow a dvd from?");
		    name = myScanner.nextLine();
		    n = getPerson(name);
		    if(n != null){
			System.out.println("What is the name of the dvd you wish to borrow?");
			dvdName = myScanner.nextLine();			
			if(n.hasDVDInArchive(dvdName)){
			    // Now borrow the DVD
			    p.borrowDVD(dvdName, n);
			    System.out.println(p + " is now borrowing the dvd " + dvdName + " from " + n);
			}
		    } else {
			System.out.println("Sry, that person is not registered with us.");
		    }
		} else {
		    System.out.println("I am sorry, but the person is not registered in our archives, please add a'N'ew entry");
		}
		break;
			
	    case "O":
		showOverView();
		break;
	    }
	}while(!userAction.equals("Q"));
    }
}





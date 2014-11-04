import java.io.*;

class Oblig7{
    public static void main(String[] args) throws Exception {
	DVDAdministration da = new DVDAdministration();
	File file = new File("dbTest.txt");
	Scanner myScanner = new Scanner(System.in);
	da.readFile(file);
	da.showList();
    }

    public static runAdminProcess(){
	System.out.println("Hello and welcome to the dvd administration system");
	do{
	    System.out.println("Please enter what you would like to do:");
	    System.out.println();
	    System.out.println("In order to add a new person, enter N");
	    System.out.println("In order to buy a new dvd, enter K");
	    System.out.println("In order to borrow a dvd, enter L");
	    System.out.println("In order to show a complete overview, enter O");
	    System.out.println("In order to return a borrowed Dvd, enter R");
	    System.out.println("To show a persons archive, enter V");
	    String userAction = myScanner.nextLine();
	    switch(userAction){
		
	    case "N":
		System.out.println("what is the name of the Person you would like to add?");
		String name = myScanner.nextLine();
		Person p = new Person(name);
		if(da.addPerson(p)){
		    System.out.println("The person " + name + " was added to the archive");
		} else {
		    System.out.println("The person " + name + " already exists in our system");
		}
		break;

	    case "K":
		System.out.println("Who is buying a new dvd?");
		String name = myScanner.nextLine();
		if(da.addPerson(name) == false){
		    System.out.println("What is the name of the dvd that he/she would like to buy?");
		    Person p = da.getPerson(name);
		    String dvdName = myScanner.nextLine();
		    if(p.addDVD(dvdName, new DVD(dvdName))){
			System.out.println("The dvd was added to " + name +"'s archive");
		    } else {
			System.out.println("The dvd is already in " + name + "'s archive");
		    }
		    
		} else {
		    System.out.println("The person is not found in the archives, please add him/her first");
		}
		break;
	    }
	}
    }
}

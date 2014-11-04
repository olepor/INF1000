import java.io.*;
import java.util.*;

class Oblig7{
    public static void main(String[] args) throws Exception {
	DVDAdministration da = new DVDAdministration();
	File file = new File("dbTest.txt");
	Scanner myScanner = new Scanner(System.in);
	da.readFile(file);
	da.runAdminProcess();
	da.showList();
    }
}
    

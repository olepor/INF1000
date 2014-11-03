import java.io.*;

class Oblig7{
    public static void main(String[] args) throws Exception {
	DVDAdministration da = new DVDAdministration();
	File file = new File("dbTest.txt");
	da.readFile(file);
	da.showList();
    }
}

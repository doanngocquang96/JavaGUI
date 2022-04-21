package doAnCK;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO {
	//ArrayList<Customer> cusList = new ArrayList<>();
	
	public static void clearFile() {
		try {
			FileWriter clearFile = new FileWriter("C:\\Users\\Admin\\Desktop\\customer.txt", false);
			clearFile.write("");		
			clearFile.close();					
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void saveListToFile(ArrayList<Customer> list) {
		clearFile();
		for (int i = 0; i < list.size(); i++) {
			try {
				FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\customer.txt", true);
				myWriter.write(list.get(i).getCusID());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(list.get(i).getName());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(list.get(i).getBirth());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(list.get(i).getPhone());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(list.get(i).getMail());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(list.get(i).getBuyApartment());
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write("");
				myWriter.write(System.getProperty("line.separator"));
				myWriter.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}
	
	public static void  loadFileToList(ArrayList<Customer> cusList) {
		//To temp list
		int i=0;
		ArrayList<String> tempList = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\Desktop\\customer.txt"));
			while (scanner.hasNextLine()) {
				tempList.add(i, scanner.nextLine());
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException er) {
			er.printStackTrace();
		}
		tempList.removeAll(Arrays.asList("", null)); //Remove blank elements in the list
		
		//To customer list
		for (i = 0; i < tempList.size(); i += 6)
			cusList.add(new Customer(tempList.get(i), tempList.get(i + 1), tempList.get(i + 2), tempList.get(i + 3),
					tempList.get(i + 4), tempList.get(i + 5)));		
		cusList.removeAll(Arrays.asList("", null)); //Just for sure
		
		//Print to test
		for (i = 0; i < (cusList.size()); i++) {
			System.out.println(cusList.get(i).toString());
		}
		System.out.println(""); 	
	}	
}

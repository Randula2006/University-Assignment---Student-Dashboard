// github Repo :- https://github.com/Randula2006/University-Assignment---Student-Dashboard

import java.util.Scanner;
import java.io.File;
public class Main{
    public static void main(String[] args){
        Boolean isExit;
        File file;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the CSV file name (without .csv extension): ");
        String fileNameWithoutExtention = scanner.nextLine();
        String fileName = fileNameWithoutExtention + ".csv";
        System.out.println("Looking for file: " + fileName);

        if(fileName.trim().isEmpty()){
            System.out.println("No file name provided. Exiting the program.");

            
        }else{
            file = new File(fileName);
            if(file.exists() && !file.isDirectory()){
                System.out.println("File found: " + fileName);  

                do {
                    Menu menu = new Menu();
                    isExit = menu.menu(fileName);            
                } while (!isExit);
                scanner.close();
            }else{
                System.out.println("File not found: " + fileName);
                System.out.println("Please ensure the file exists in the specified path and try again.");
                System.out.println("Exiting the program.");
            }

        }

    }
}
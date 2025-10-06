import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Boolean isExit;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the CSV file name (with .csv extension): ");
        String fileName = scanner.nextLine();

         do {
            Menu menu = new Menu();
            isExit = menu.menu(fileName);            
        } while (!isExit);
    }
}
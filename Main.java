public class Main{
    public static void main(String[] args){
        Boolean isExit;
         do {
            Menu menu = new Menu();
            isExit = menu.menu();            
        } while (!isExit);
    }
}
public class Main{
    public static void main(String[] args){
        Boolean isExit;

        do {
            Menu menu = new Menu();
            isExit = menu.menu();            
        } while (!isExit);

        // System.out.println(Arrays.toString(headers));  
        // for (int i = 0; i < stuData.length; i++) {
        //     System.out.println("Student " + (i+1) + ": " + String.join(", ", stuData[i]));
        // }

        
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public Boolean menu(){

        String fileName = "data.csv";
        FileHandling FileRead = new FileHandling();
        CsvResult result =  FileRead.addDataToArr(fileName);
        

         //view all records - 3
        String[] headers = result.headers;
        String[][] stuData = result.stuData;

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================== \n Welcome to student admistration software \n==========================================");
        System.out.println("Your options for this system are listed below");
        System.out.println("1> Add new student\n2> Edit student data\n3> View All student Info\n4> Filter by Course\n5> Filter by Status\n6> Hightest CWA\n7> Avarage CWA for each Course\n8> Credit analysis\n9> Exit Program");
        int userSelectedItem = sc.nextInt();
        boolean isExit = false;
        boolean isStuIDinFormat = false;//return truw is studentID is in format


        switch (userSelectedItem) {
                case 1:
                    try{
                        System.out.print("Enter student ID:-");
                        sc.nextLine();  //to stop consuming the this input
                        String newStuID = sc.nextLine();
                        System.out.print("Enter student First Name:-");
                        String newStuFirstName = sc.nextLine();
                        System.out.print("Enter student Last Name:-");
                        String newStuLastName = sc.nextLine();
                        System.out.print("Enter Course Enrolled:-");
                        String newCourseEnrolled = sc.nextLine();
                        System.out.print("Enter Student's study year:-");
                        int newYearLevel = sc.nextInt();
                        System.out.print("Enter student's CWA:-");
                        double newStuCWA = sc.nextDouble();
                        sc.nextLine(); //to stop consuming the this input
                        System.out.print("Enter study Status:-");
                        String newStudyStatus = sc.nextLine().toUpperCase();    
                        System.out.print("Enter Credits earned by student:-");
                        int newCredEarn = sc.nextInt();

                        
                        if(newStuID != null && newStuFirstName != null && newStuLastName != null && newCourseEnrolled != null){
                            String[] studentIDFormat = newStuID.split("");
                                if(studentIDFormat[0] == "S"){
                                    for(int i = 1; i < studentIDFormat.length; i++){
                                        if(Character.isDigit(Integer.parseInt(studentIDFormat[i]))){
                                            isStuIDinFormat = true;
                                        }else{
                                        System.out.println("Student ID is not in format");
                                        isExit = true;
                                        break;
                                        }
                                    }                    
                                }else{
                                    System.out.println("Student ID is not in format");
                                    isExit = true;
                                    break;
                                }
                                
                          

                            if(isStuIDinFormat && newYearLevel > 0 && newYearLevel < 5){
                                if(newStuCWA >= 0 && newStuCWA <= 100){
                                    if(newStudyStatus.equals("FT") || newStudyStatus.equals("PT")){
                                        if(newCredEarn > 0 ){
                                            
                                            Student newStudentRecord = new Student(newStuID, newStuFirstName, newStuLastName, newCourseEnrolled, newYearLevel, newStuCWA, newStudyStatus, newCredEarn);
                                            String[] data = newStudentRecord.getStudentData();
                                            FileHandling fw = new FileHandling();
                                            fw.writingToCSVFile(fileName , headers , stuData , data);
                                            System.out.println("Student data has been validated");

                                        }else{}

                                    }else{System.out.println("Styudy Status should be (Either FT or PT) values");}

                                }else{ System.out.println("CWA creadits earned by a student must be within range");}

                            }else{System.out.println("student year should be between 1 to 4");}

                        }else{System.out.println("student ID , FIRST name , LAST name OR Course enrolled are required");}


                        isExit = true;
                        break;

                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.out.println("Input missmatch");
                        isExit = true;
                        break;
                    }

                    

                case 2:
                    System.out.println("================== Edit student Info ==================");
                    System.out.print("Enter student ID:- ");

                    CsvResult studentDataInfo = getStuData();

                    for(int i = 0; )

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

            
                default:
                    break;
            }

            sc.close();

            return isExit;
    }
}

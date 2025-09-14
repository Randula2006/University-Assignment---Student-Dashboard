import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public Boolean menu(){

        String fileName = "data.csv";
        FileHandling fileHandler = new FileHandling(fileName);
        CsvResult result =  fileHandler.readingCsvFile();
        

         //view all records - 3
        String[] headers = result.headers;
        String[][] stuData = result.stuData;

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================== \n Welcome to student admistration software \n==========================================");
        System.out.println("Your options for this system are listed below");
        System.out.println("1> Add new student\n2> Edit student data\n3> View All student Info\n4> Filter by Course\n5> Filter by Status\n6> Hightest CWA\n7> Avarage CWA for each Course\n8> Credit analysis\n9> Exit Program");
        int userSelectedItem = sc.nextInt();
        boolean isExit = false;
        boolean isStuIDinFormat = false;//return true is studentID is in format


        switch (userSelectedItem) {
                case 1:
                    try{
                        System.out.print("Enter student ID:-");
                        sc.nextLine();  //to stop consuming this input
                        String newStuID = sc.nextLine();
                        System.out.print("Enter student First Name:-");
                        String newStuFirstName = sc.nextLine();
                        System.out.print("Enter student Last Name:-");
                        String newStuLastName = sc.nextLine();
                        System.out.print("Enter Course Enrolled:-");
                        String newCourseEnrolled = sc.nextLine();
                        System.out.print("Enter Student's study year:-");
                        int newYearLevel = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter student's CWA:-");
                        double newStuCWA = sc.nextDouble();
                        sc.nextLine(); //to stop consuming this input
                        System.out.print("Enter study Status:-");
                        String newStudyStatus = sc.nextLine().toUpperCase();    
                        System.out.print("Enter Credits earned by student:-");
                        int newCredEarn = sc.nextInt();
                        sc.nextLine();

                        
                        if(newStuID != null && newStuFirstName != null && newStuLastName != null && newCourseEnrolled != null){

                            // previous version
                            // String[] studentIDFormat = newStuID.split("");
                            //     if(studentIDFormat[0].equals("S")){
                            //         for(int i = 1; i < studentIDFormat.length; i++){
                            //             if(Character.isDigit(studentIDFormat[i].charAt(0))){
                            //                 isStuIDinFormat = true;
                            //             }
                            //             else{
                            //             System.out.println("Student ID is not in format - 8 characters required.");
                            //             isExit = true;
                            //             break;
                            //             }
                            //         }                    
                            // }
                                if(newStuID.matches("S\\d{7}")){
                                    isStuIDinFormat = true;
                                }
                                else{
                                    System.out.println("Student ID is not in format");
                                    isExit = true;
                                    break;
                                }
                                
                          

                            if(isStuIDinFormat && (newYearLevel > 0 && newYearLevel < 5)){
                                if(newStuCWA >= 0 && newStuCWA <= 100){
                                    if(newStudyStatus.equals("FT") || newStudyStatus.equals("PT")){
                                        if(newCredEarn > 0 ){
                                            
                                            Student newStudentRecord = new Student(newStuID, newStuFirstName, newStuLastName, newCourseEnrolled, newYearLevel, newStuCWA, newStudyStatus, newCredEarn);
                                            String[] data = newStudentRecord.getStudentData();
                                            
                                            fileHandler.writingToCSVFile(stuData , data);
                                            System.out.println("Student data has been validated");

                                        }else{}

                                    }else{System.out.println("Styudy Status should be (Either FT or PT) values");}

                                }else{ System.out.println("CWA creadits earned by a student must be within range");}

                            }else{System.out.println("student year should be between 1 to 4");}

                        }else{System.out.println("student ID , FIRST name , LAST name OR Course enrolled are required");}


                        isExit = true;
                        break;

                    }catch(InputMismatchException e){
                        e.getStackTrace();
                        System.out.println("Input mismatch" + e);
                        isExit = true;
                        break;
                    }

                    

                case 2:
                        sc.nextLine();
                        System.out.println("================== Edit student Info ==================");
                        System.out.print("Enter student ID:- ");
                        String userStudentIDEntered = sc.nextLine();
                        Boolean isEditing = true;

                        for(int i = 0; i < stuData.length; i++){
                            if(stuData[i][0].equals(userStudentIDEntered)){
                                System.out.println("Select an item to edit");
                                System.out.println("===========================");
                                System.out.println("0) EXIT\n 1) Student first name\n 2) Student last name\n 3) course Enrolled\n 4) Year level\n 5) CWA marks\n 6) Student Status\n 7) Total credits Earned");
                                int studentEditInput = sc.nextInt();

                                switch (studentEditInput) {
                                    case 0:
                                            isExit = false;
                                            System.out.println("Exiting from editing section");
                                        break;
                                    
                                    case 1:
                                            System.out.print("Enter new first-name:- ");
                                            String editStuFName = sc.nextLine();

                                            stuData[i][1] = editStuFName;
                                            System.out.println("updated value:- " + stuData[i][1]);
                                        break;
                                    
                                    case 2:
                                            System.out.print("Enter new last-name:- ");
                                            String editStuLName = sc.nextLine();

                                            stuData[i][2] = editStuLName;
                                            System.out.println("updated value:- " + stuData[i][2]);
                                        break;
                                    
                                    case 3:
                                            System.out.print("Enter the new course:-");
                                            String editCourse = sc.nextLine();

                                            stuData[i][3] = editCourse;
                                            System.out.println("updated course:- " + stuData[i][3]);
                                        break;
                                    
                                    case 4:
                                            System.out.print("Enter the year-level:- ");
                                            int editYearLevel = sc.nextInt();

                                            stuData[i][4] = String.valueOf(editYearLevel);
                                            System.out.println("updated Year:- " + stuData[i][4]);
                                        break;
                                    
                                    case 5:
                                            System.out.print("Enter CWA marks:- ");
                                            Double editCWA = sc.nextDouble();

                                            stuData[i][5] = String.valueOf(editCWA);
                                            System.out.println("updated CWA marks:- " + stuData[i][5]);
                                        break;
                                    
                                    case 6:
                                            System.out.print("Enter Study Status:- ");
                                            String editStatus = sc.nextLine();

                                            stuData[i][6] = editStatus;
                                            System.out.println("updated Status of study:- " + stuData[i][6]);
                                        break;
                                    
                                    case 7:
                                            System.out.print("Enter Credits Earned:- ");
                                            String editCredits = sc.nextLine();

                                            stuData[i][7] = editCredits;
                                            System.out.println("updated Creadits Earned:- " + stuData[i][7]);
                                        break;
                                }       

                            }
                            else{
                                System.out.println("error - user Input is wrong - invalid student ID ");
                            }
                        }

                        isExit = false;



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


            return isExit;
    }
}

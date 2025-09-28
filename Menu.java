import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public Boolean menu(){

        
        String fileName = "data.csv";
        FileHandling fileHandler = new FileHandling(fileName);
        CsvResult result =  fileHandler.readingCsvFile();
        

         //view all records - 3
        // String[] headers = result.headers;
        String[][] stuData = result.stuData;

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================== \n Welcome to student admistration software \n==========================================");
        System.out.println("Your options for this system are listed below");
        System.out.println("1> Add new student\n2> Edit student data\n3> View All student Info\n4> Filter by Course\n5> Filter by Status\n6> Hightest CWA\n7> Avarage CWA for each Course\n8> Credit analysis\n9> Exit Program");
        int userSelectedItem = sc.nextInt();
        boolean isExit = false;
        boolean isStuIDinFormat = false;//return true if studentID is in format


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
                        sc.nextLine(); //to stop consuming this input
                        System.out.print("Enter student's CWA:-");
                        double newStuCWA = sc.nextDouble();
                        sc.nextLine(); //to stop consuming this input
                        System.out.print("Enter study Status:-");
                        String newStudyStatus = sc.nextLine().toUpperCase();    
                        System.out.print("Enter Credits earned by student:-");
                        int newCredEarn = sc.nextInt();
                        sc.nextLine(); //to stop consuming this input

                        // previous version
                        Details details = new Details(newCourseEnrolled, newYearLevel, newStuCWA, newStudyStatus, newCredEarn);                                        
                        Student newStudentRecord = new Student(newStuID, newStuFirstName, newStuLastName, details);
                        String[] data = newStudentRecord.getStudentData();                    
                        fileHandler.writingToCSVFile(stuData , data);
                        System.out.println("Student data has been validated");

                            // Details details = new Details(
                            //     newCourseEnrolled,
                            //     newYearLevel,
                            //     newStuCWA,
                            //     newStudyStatus,
                            //     newCredEarn
                            // );
                            // Student newStudentRecord = new Student(
                            //     newStuID,
                            //     newStuFirstName,
                            //     newStuLastName,
                            //     details
                            // );
                            // String[] data = newStudentRecord.getStudentData();                    
                            // fileHandler.writingToCSVFile(stuData , data);
                            // System.out.println("Student data has been validated");                            
                        break;

                    }catch(InputMismatchException e){
                        e.getStackTrace();
                        System.out.println("Input mismatch:- Enter the Correct Input type" );
                        isExit = true;
                        break;
                    }catch(IllegalArgumentException e){
                        e.getStackTrace();
                        System.out.println("Error - " + e.getMessage());
                        isExit = true;
                        break;
                    }

                    

                case 2:
                        Boolean isEditing = true;
                        sc.nextLine();
                        System.out.println("================== Edit student Info ==================");
                        System.out.print("Enter student ID:- ");
                        String userStudentIDEntered = sc.nextLine();

                    do{
                        
                        Boolean isStundetFound = false;
                        int studentRowNum = 0;
                        

                        for(int i = 0; i < stuData.length; i++){
                            if(stuData[i][0].equals(userStudentIDEntered)){
                                isStundetFound = true;
                                studentRowNum = i;
                            }
                        }
                        if(!isStundetFound){
                            System.out.println("error - Enter a valid student ID");
                        }


                        if(isStundetFound){
                                System.out.println("Select an item to edit");
                                System.out.println("===========================");
                                System.out.println(" 0) EXIT\n 1) Student first name\n 2) Student last name\n 3) course Enrolled\n 4) Year level\n 5) CWA marks\n 6) Student Status\n 7) Total credits Earned");
                                int studentEditInput = sc.nextInt();
                                sc.nextLine();

                                switch (studentEditInput) {
                                    case 0:
                                            isEditing = false;
                                            System.out.println("Exiting from editing section");
                                        break;
                                    
                                    case 1:
                                            System.out.print("Enter new first-name:- ");
                                            String editStuFName = sc.nextLine();

                                            stuData[studentRowNum][1] = editStuFName;
                                            System.out.println("updated value:- " + stuData[studentRowNum][1]);
                                        break;
                                    
                                    case 2:
                                            System.out.print("Enter new last-name:- ");
                                            String editStuLName = sc.nextLine();

                                            stuData[studentRowNum][2] = editStuLName;
                                            System.out.println("updated value:- " + stuData[studentRowNum][2]);
                                        break;
                                    
                                    case 3:
                                            System.out.print("Enter the new course:-");
                                            String editCourse = sc.nextLine();

                                            stuData[studentRowNum][3] = editCourse;
                                            System.out.println("updated course:- " + stuData[studentRowNum][3]);
                                        break;
                                    
                                    case 4:
                                            System.out.print("Enter the year-level:- ");
                                            int editYearLevel = sc.nextInt();

                                            stuData[studentRowNum][4] = String.valueOf(editYearLevel);
                                            System.out.println("updated Year:- " + stuData[studentRowNum][4]);
                                        break;
                                    
                                    case 5:
                                            System.out.print("Enter CWA marks:- ");
                                            Double editCWA = sc.nextDouble();

                                            stuData[studentRowNum][5] = String.valueOf(editCWA);
                                            System.out.println("updated CWA marks:- " + stuData[studentRowNum][5]);
                                        break;
                                    
                                    case 6:
                                            System.out.print("Enter Study Status:- ");
                                            String editStatus = sc.nextLine();

                                            stuData[studentRowNum][6] = editStatus;
                                            System.out.println("updated Status of study:- " + stuData[studentRowNum][6]);
                                        break;
                                    
                                    case 7:
                                            System.out.print("Enter Credits Earned:- ");
                                            String editCredits = sc.nextLine();

                                            stuData[studentRowNum][7] = editCredits;
                                            System.out.println("updated Creadits Earned:- " + stuData[studentRowNum][7]);
                                        break;
                                }       
                        
                                fileHandler.writingToCSVFile(stuData, null);
                                System.out.println("student data updated successfully");
                        }


                    }while(isEditing);

                    break;

                case 3:
                        for (int i = 0; i < stuData.length; i++){
                            System.out.println("Student Name:- " + stuData[i][1] + " " + stuData[i][2] + " : Student ID:- " + stuData[i][0]);
                        }
                    break;

                case 4:

                        sc.nextLine();
                        System.out.println("=============================");
                        System.out.println("Enter course to filter");
                        String userCourseEntered = sc.nextLine();
                        Boolean isFound = false;

                        for(int i = 0; i < stuData.length; i++){
                            // System.out.println(stuData[i][3] + " " + stuData[i][0]);
                            if(userCourseEntered.equalsIgnoreCase(stuData[i][3].trim())){
                                System.out.println("Student Name: " + stuData[i][1] + " " + stuData[i][2] + " :: StudentID: " + stuData[i][0]);
                                isFound = true;
                            }
                        }

                        if(!isFound){
                            System.out.println("No Students are with " + userCourseEntered + " course");
                        }

                    break;
                        
                    

                case 5:
                        
                        System.out.println("Select Study Status");
                        System.out.println("1) Full Time\n2) Part Time");
                        int studyStatusEntered = sc.nextInt();
                        
                        if(studyStatusEntered == 1 ){
                            for(int i = 0; i < stuData.length; i++){
                                if(stuData[i][6].trim().equalsIgnoreCase("FT")){
                                   System.out.println("Student ID: " + stuData[i][0] + " :: Student Name: " + stuData[i][1] + " " + stuData[i][2] );
                                }
                            }
                        }else if (studyStatusEntered == 2){
                            for(int i = 0; i < stuData.length; i++){
                                if(stuData[i][6].trim().equalsIgnoreCase("PT")){
                                   System.out.println("Student ID: " + stuData[i][0] + " :: Student Name: " + stuData[i][1] + " " + stuData[i][2] );
                                }
                            }                            
                        }else{
                            System.out.println("Enter a valid input");
                        }

                    break;

                case 6:

                        System.out.println("=============================");

                        try{
                            int rowNum = 0;
                            Double max = Double.parseDouble(stuData[0][5]);
                            for(int i = 0; i < stuData.length; i++){
                                if(Double.parseDouble(stuData[i][5]) > max){
                                    max = Double.parseDouble(stuData[i][5]);
                                     rowNum = i;
                                 }
                            }

                            System.out.println("Student Name: " + stuData[rowNum][1] + " " + stuData[rowNum][2] + ": Highest CWA marks: " + max);
                        }catch(NumberFormatException e){
                            System.out.println("Error - number format error");
                        }


                    break;

                case 7:
                        System.out.println("Avarage CWA for Each course");
                        String[] courses = new String[stuData.length];
                        
                        //get all the courses stundets do
                        for(int i = 0; i < stuData.length; i++){
                            courses[i] = stuData[i][3].trim();  
                        }
                        //previous version
                        // for (int i = 0; i < stuData.length; i++) {
                        //     int occuredTimes = 0;
                        //     for (int j = 0; j < courses.length; j++) {
                        //         if (courses[i].equals(stuData[i][3].trim())) {
                        //             if (occuredTimes <= 1) {
                        //                 occuredTimes++;
                        //             }
                        //         }
                        //     }
                        // }  

                        // Keep only the first occurrence of each item
                        int uniqueCount = 0; 
                        for (int i = 0; i < courses.length; i++) {
                            boolean isDuplicate = false;
                            // Checking if this item is already kept
                            for (int j = 0; j < uniqueCount; j++) {
                                if (courses[i].equals(courses[j])) {
                                    isDuplicate = true;
                                }
                            }
                            // If not a duplicate, keep it
                            if (!isDuplicate) {
                                courses[uniqueCount] = courses[i];
                                uniqueCount++;
                            }
                        }
                        String[] Final_courses = new String[uniqueCount];
                        // Print only unique elements
                        for (int i = 0; i < uniqueCount; i++) {
                            Final_courses[i] = courses[i];
                        }

                        // calculate avarage cwa for each course
                        for(int i = 0; i < Final_courses.length; i++){
                            Double sum = .0;
                            int count2 = 0;
                            for(int j = 0; j < stuData.length; j++){
                                if(stuData[j][3].trim().equals(Final_courses[i])){
                                    sum = sum + Double.parseDouble(stuData[j][5]);
                                    count2++;
                                }
                            }
                            System.out.println(Final_courses[i] + " Course Avarage CWA: " + sum/count2);   
                        }

                        // System.out.println(Arrays.toString(Final_courses));
                        // previous unfinished versions
                        // Double sum = .0;
                        // int count2 = 0;
                        // for(int i = 0; i < stuData.length; i++){
                        //     for(int j = 0; j < courses.length; j++){
                        //         if(stuData[i][3].trim().equals(courses[j])){
                        //             sum = sum + Double.parseDouble(stuData[i][5]);
                        //             count2++;
                        //         }
                        //     }
                        //     System.out.println(stuData[i][3] + " Course Avarage CWA: " + sum/count2);
                        // }
                    break;

                case 8:
                        System.out.println("Credit Anallysis");
                        for(int i = 0; i < stuData.length; i++){
                             
                        }

                    break;

                case 9:
                        isExit = true;
                    break;

            }


            return isExit;
    }
}


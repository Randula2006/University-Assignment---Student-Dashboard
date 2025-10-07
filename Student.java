public class Student {
    private String studentID;
    private String studentFName;
    private String studentLName;

    private Details details;
    private String[] studentData = new String[8];

    Student(String studentID , String studentFName , String studentLName , Details details){
        setStudentID(studentID);
        setStudentName(studentFName);
        setStudentLName(studentLName);
        this.details = details;
   
        studentData[3] = details.getCourse();
        studentData[4] = String.valueOf(details.getYearLevel());
        studentData[5] = String.valueOf(details.getCwa());
        studentData[6] = details.getStatus();
        studentData[7] = String.valueOf(details.getCreditsEarned()); 


    }
    //getter method for the studentData array
    public String[] getStudentData(){
        return studentData;
    }

    //setter methods
    public void setStudentID(String studentID){
        if(studentID != null){
// Citation:- 
            // Title: Java Regex Validation for a pattern 
            // Date: 2017
            // Availability: https://stackoverflow.com/questions/44932927/regex-for-validating-a-pattern-in-java 
            //               https://www.w3schools.com/java/java_regex.asp
            if(studentID.matches("^S\\d{7}$")){
                this.studentID = studentID;
                studentData[0] = this.studentID;   
            }else{throw new IllegalArgumentException("Invalid student ID format. It should start with 'S' followed by 7 digits.");}
        }else{throw new IllegalArgumentException("Student ID cannot be a null value");}//display a custom error message
    }

    public void setStudentName(String fName){
        if(fName != null){
            this.studentFName = fName;
            
            studentData[1] = this.studentFName;
            
        }else{throw new IllegalArgumentException("First name cannot be null");}
    }

    public void setStudentLName(String lName){
        if(lName != null){
            this.studentLName = lName;
            studentData[2] = this.studentLName;
        }else{throw new IllegalArgumentException("Last name cannot be null");}
    }

}

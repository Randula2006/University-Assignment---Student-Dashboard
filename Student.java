public class Student {
    String studentID;
    String studentFName;
    String studentLName;
    String courseEnrolled;
    int Year;
    double CWA;
    String studyStatus;
    int credEarned;

    private String[] studentData = new String[8];

    Student(String studentID , String studentFName , String studentLName , String courseEnrolled , int Year, double CWA , String studyStatus , int credEarned){
        this.studentID = studentID;
        this.studentFName = studentFName;
        this.studentLName = studentLName;
        this.courseEnrolled = courseEnrolled;
        this.Year = Year;
        this.CWA = CWA;
        this.studyStatus = studyStatus;
        this.credEarned = credEarned;


        studentData[0] = studentID;
        studentData[1] = studentFName;
        studentData[2] = studentLName;
        studentData[3] = courseEnrolled;
        studentData[4] = String.valueOf(Year);
        studentData[5] = String.valueOf(CWA);
        studentData[6] = studyStatus;
        studentData[7] = String.valueOf(credEarned); 


    }
    //getter method for the studentData array
    public String[] getStudentData(){
        return studentData;
    }

}

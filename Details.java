public class Details {
    private String courseEnrolled;
    private int year;
    private Double CWA;
    private String studyStatus;
    private int credEarned;

    public Details(String courseEnrolled, int year, Double CWA, String studyStatus, int credEarned) {
        setCourse(courseEnrolled);
        setYearLevel(year);
        setCwa(CWA);
        setStatus(studyStatus);
        setCreditsEarned(credEarned);

    }


    //setter methods
    public void setCourse(String course){
        if(course != null){
            this.courseEnrolled = course;  
        }else{throw new IllegalArgumentException("Course cannot be a null value");}//display a custom error message
    }
    public void setYearLevel(int yearLevel){
        if(yearLevel > 0 && yearLevel < 5){
            this.year = yearLevel;

        }else{throw new IllegalArgumentException("Year level cannot be a null value AND should be in range 1 to 4");}
    }
    public void setCwa(Double cwa){
        if(cwa >=0 && cwa < 101){
            this.CWA = cwa;
        }else{throw new IllegalArgumentException("CWA cannot be a Null value AND CWA must be between 0 and 100");}
    }
    public void setStatus(String status){
        if(status != null){
            if(status.equalsIgnoreCase("FT") || status.equalsIgnoreCase("PT")){
                this.studyStatus = status.toUpperCase();
            }else{throw new IllegalArgumentException("Status should be either FT or PT");}

        }else{throw new IllegalArgumentException("Status cannot be a null value");}
    }
    public void setCreditsEarned(int creditEarned){
        if(creditEarned >=0 ){
            this.credEarned = creditEarned;
        }else{throw new IllegalArgumentException("Credits earned must be greater than 0");}
    }


    //getter methods
    public String getCourse(){
        return courseEnrolled;
    }
    public int getYearLevel(){
        return year;
    }
    public Double getCwa(){
        return CWA;
    }
    public String getStatus(){
        return studyStatus;
    }
    public int getCreditsEarned(){
        return credEarned;
    }

}

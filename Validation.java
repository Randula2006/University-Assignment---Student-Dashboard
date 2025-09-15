public class Validation {


    public static Boolean EntryValidation(String stuID, String firstName, String lastName, String course, int year, Double CWA, String status, int CredsEarned ){
        Boolean isValidation = false;

        // cite :- https://stackoverflow.com/questions/16005234/java-using-regex-to-verify-an-input-string
        if(stuID != null && stuID.matches("S\\d{7}")){
            isValidation = true;
        }

        if(firstName != null){
            isValidation = true;
        }else{
            isValidation = false;
        }

        if(lastName != null){
            isValidation = true;
        }else{
            isValidation = false;
        }

        if(course != null){
            isValidation = true;
        }else{
            isValidation = false;
        }
        
        if(year > 0 && year < 5){
            isValidation = true;
        }else{
            isValidation = false;
        }

        if(CWA >= 0 && CWA <= 100){
            isValidation = true;
        }else{
            isValidation = false;
        }

        if(status.equals("FT") || status.equals("PT")){
            isValidation =true;
        }else{
            isValidation = false;
        }

        if(CredsEarned >= 0 && CredsEarned <= 400){
            isValidation = true;
        }else{
            isValidation = false;
        }


        return isValidation;
    }
}

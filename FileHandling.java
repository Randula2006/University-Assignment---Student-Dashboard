import java.io.*;

public class FileHandling {
    String[] headers = null;
    String File;

     //storing the CSV file .reason - if user starts with a file there is no need to get it  again and again
    public FileHandling(String file){
        this.File = file;
    }
    //checking the length of the CSV file with headers
    // populate the arrays with data in CSV
    public CsvResult readingCsvFile(){
        int rows = 0;
        String line;


        // Count total rows
        try (BufferedReader rowReader = new BufferedReader(new FileReader(File))) {
            while (rowReader.readLine() != null) rows++;
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error - CSV File not found - " + e);
        }

        
        String[][] stuData = new String[rows - 1][]; // first row = header
        int counter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(File))) {

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (counter == 0) {
                    headers = new String[values.length]; //get the value of headers array

                    for(int i = 0; i < values.length; i++) {
                        headers[i] = values[i];
                    }
                } else {
                    stuData[counter - 1] = new String[values.length]; // initializing the row
                    
                    for (int i = 0; i < values.length; i++) {
                        stuData[counter - 1][i] = values[i];
                    }
                }
                counter++;
            }
            
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Error - reading the CSV file format - " + e);
        }

    return new CsvResult(headers, stuData);
}


    //writing new student data to the CSV file
    public void writingToCSVFile(String[][] prevStuData, String[] studentDataArr ){

            writingFunction();
            
            for(String[] row : prevStuData){
                for(int i = 0; i < row.length; i++){
                    writingFunction(row[i], i);
                }
            }
            if(studentDataArr != null){ //null value is used in the student edit section - as it doesn't add a student
                for(int i = 0; i< studentDataArr.length; i++){
                writingFunction(studentDataArr[i], i);
            }
            }


        System.out.println("Writing to CSV Completed.");
    }


    private void writingFunction(String item , int count ){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(File , true))){
            int CSVLineLength = 7; 
            if(count < CSVLineLength){
                //much efficient
                if(count != 4 && count !=5){
                    pw.print(item.trim() + ", ");
                }
                else if(count == 4){
                    int value = Integer.parseInt(item.trim());
                    pw.print(value + ", ");
                }else{
                    Double value = Double.parseDouble(item.trim());
                    pw.print(value + ", ");
                }
            }
            else if(count == CSVLineLength){
                int lastItemInLine = Integer.parseInt(item.trim());
                pw.println(lastItemInLine);
            }
        }catch(FileNotFoundException e){
            e.getStackTrace();
            System.out.println("Error - File Not Found - Writing section (body) -" + e);
        }catch(NumberFormatException e){
            e.getStackTrace();
            System.out.println("Error - number format error in headers");
        } 
    }

    //overloaded function - headers array
    private void writingFunction(){
        try(PrintWriter pw = new PrintWriter(File)){
            for(int i = 0; i < headers.length; i++){
                if(i == 7){
                    pw.println(headers[i]);
                }
                else{
                    pw.print(headers[i] + ",");
                }
            }
        }catch(FileNotFoundException e){
            e.getStackTrace();
            System.out.println("error - file not found - writing section (headers) -" + e);
        }
    }
}
// :)


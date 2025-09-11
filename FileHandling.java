import java.io.*;

public class FileHandling {
    //checking the length of the CSV file with headers
    // populate the arrays with data in CSV
    public CsvResult addDataToArr(String file){

        int rows = 0;
        String line;
        String[] headers = null;


        // Count total rows
        try (BufferedReader rowReader = new BufferedReader(new FileReader(file))) {
            while (rowReader.readLine() != null) rows++;
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        String[][] stuData = new String[rows - 1][]; // first row = header
        int counter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (counter == 0) {
                    headers = new String[values.length]; //get the value of headers array

                    for (int i = 0; i < values.length; i++) {
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
            e.printStackTrace();
        }

    return new CsvResult(headers, stuData);
}


    //writing new student data to the CSV file
    public void writingToCSVFile(String file , String[] header,String[][] prevStuData, String[] studentDataArr ){
        // System.out.println("fucntion works properly");
            // for(String items : header){
            //     pw.write(items);
            // }
            writingFunction(header , file);
            
            for(String[] row : prevStuData){
                for(int i = 0; i < row.length; i++){
                    writingFunction(row[i], i, file);
                }
            }
            for(int i = 0; i< studentDataArr.length; i++){
                writingFunction(studentDataArr[i], i, file);
            }

        System.out.println("Writing to CSV Completed.");
    }


    private void writingFunction(String item , int count , String file){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(file , true))){
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
        }
    }

    //overloaded fucntion - headers array
    private void writingFunction(String[] headerArr, String file){
        try(PrintWriter pw = new PrintWriter(file)){
            for(int i = 0; i < headerArr.length; i++){
                if(i == 7){
                    pw.println(headerArr[i]);
                }
                else{
                    pw.print(headerArr[i] + ",");
                }
            }
        }catch(FileNotFoundException e){
            e.getStackTrace();
        }
    }
}
// :)


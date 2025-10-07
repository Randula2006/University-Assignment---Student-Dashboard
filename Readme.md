# Documentation

A Student Dashboard CLI made up using the OOP approach which can add a CSV file for student Information and it reads the file where is gets the first lines as the headers and all the other lines will be student information.

## What does this do?

The app provides the functions it can handle in a command line interface.

- Add student Data and a new record
- Edit a current student information
- View all student records in the CSV file
- Filter student information 
    - Filter by course selected by the student 
    - Filter by the status student study
- Analysis
    - CWA analysis
    - Credit analysis


Each student information is extracted from the CSV file and all the new information gethered will be written into the CSV document again. 

## Validation checks

when student data added to a new records the it checks sevaral validation to store the most quality data onto the records.

1. Student ID **cannot be a null value**.
2. Student First name is **required**.
3. Student Last name is **required**.
4. Course the student selects **cannot be a null value**.
5. Student year should be a **intger** value.(whole number ex:- 1, 2, 3, 4)
6. Student year level *cannot exceed the range*. **1 to 4.**
7. CWA marks **cannot be a negative** value as well as it **cannot exceed 100**.
8. Study status should be either **FT or PT** being *Full Time* and *Part Time*. It doesn't matter whether it is in *uppercase* or *lowercase*
9. Credits earned by a student cannot be a **negative value** as well as **cannot be greater than 400**.

---

## Errors and Error handles

This section will cover all the errors the program will handle and what every error code means.

- When the user does not Enter a fileName to run the program it will output a error with "No file name provided. Exiting the program" and exit the program

- If the specified file is not in the working directory as the main file it will result in giving an error "Please ensure the file exists in the specified path and try again" and exit the program

- If the File is not a CSV file format with "," in it , this will genarate an error "Error - reading the CSV file format" and exit the program

- If there is a change in the headers in the CSV file this will result an error "Error - number format error in headers".

- After reading the file if the file relocated to a new destination when Writing this will result an error telling "error - file not found - writing section (headers) " OR "Error - File Not Found - Writing section (body)"

- If the user input types doesn't match this will result an error telling "Input mismatch:- Enter the Correct Input type" and it will prompt the user to enter values again.

- On add student section if you come across the error  "Input mismatch:- Enter the Correct Input type" this means the correct data type isn't provided for the field.

- If you come across the error "Invalid student ID format. It should start with 'S' followed by 7 digits" this is related to the studentID validation and it should be in the format of a uppercase S following 7 digits. otherwise this would result and error.

- "Student ID cannot be a null value" means the student ID cannot be null and it should follow the upper rule.

- In student names both first and last names can't be a null value and if that happens this would result in a error "First name or last name cannot be null"

- When adding a student, student year should not be a null value as well as it has to be between 1 to 4 years.otherwise it would result an error "Year level cannot be a null value AND should be in range 1 to 4".

- Student CWA points cannot be a null value as well as it has be in the ran ge of 0 to 100, otherwise the error "CWA cannot be a Null value AND CWA must be between 0 and 100" would occur.

- Student status should be either ft or pt, **It does not matter whether it is uppercase or lowercase**, is these parameters are excluded an error will occur "Status should be either FT or PT" and also it acnnot be a null value or the error "Status cannot be a null value" will occur.

- Creadits earned by the student cannot be a null value as well as it has to in range or this error "Credits earned must be greater than 0" will occur.

- In student status checking section it has to either ft or pt , otherwise the error "Enter a valid input " will popup.


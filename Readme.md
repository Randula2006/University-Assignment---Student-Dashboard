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

### Validation checks

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




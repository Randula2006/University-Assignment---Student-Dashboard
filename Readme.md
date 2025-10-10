# University Student Records CLI

A command-line interface (CLI) application for managing university student records. This tool reads student data from a CSV file and allows users to perform various operations such as adding, editing, viewing, and analyzing student information.

## Features

-   **Add New Student**: Add a new student record with complete validation for all fields.
-   **Edit Student Data**: Modify the details of an existing student by searching for their Student ID.
-   **View All Records**: Display a list of all students currently in the system.
-   **Filter Records**:
    -   Filter students by their enrolled course.
    -   Filter students by their study status (Full-Time/Part-Time).
-   **Data Analysis**:
    -   Identify the student with the highest Course Weighted Average (CWA).
    -   Calculate the average CWA for each course.
    -   Analyze student credit totals to determine their graduation readiness.

## Requirements

-   Java Development Kit (JDK) 11 or newer.

## How to Compile and Run

1.  **Place Your Data File**: Ensure your student data CSV file (e.g., `data.csv`) is in the same directory as the `.java` files.

2.  **Compile the Code**: Open a terminal or command prompt in the project directory and run the following command to compile all Java files:
    ```bash
    javac *.java
    ```

3.  **Run the Application**: Execute the program using the following command:
    ```bash
    java Main
    ```

4.  **Enter File Name**: The program will prompt you to enter the name of your CSV file. Type the full name (e.g., `data.csv`) and press Enter.

## How to Use

Once the application is running, you will be presented with a main menu. Enter the number corresponding to the action you wish to perform.


## CheckList of Features

**All the features and functionalities are working**

- [x] Design Requirements
- [x] Functionality of the program
    - [x] Add New student
    - [x] Edit student Data
    - [x] View All student Info
    - [x] Filter by course
    - [x] Filter by status
    - [x] Highest CWA
    - [x] Average CWA for Each Course
    - [x] Credit Analysis
    - [x] Exiting the program
- [x] File Handling
    - [x] File Reading
    - [x] File Writing
- [x] Error handling and Validation
- [x] Menu System

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

## Data format and validation Rules

This application requires a CSV file with a header row. The data for each student must adhere to the following format and rules.

| Header | Validation Rule |
|---|---|
| StudentID | Required. Must be in the format S followed by 7 digits (eg:- S1234567). |
| FirstName | Required.Cannot be empty | 
| LastName | Required.Cannot be empty |
| CourseEnrolled | Required.Cannot be empty |
| YearLevel | Must be an integer between 1 and 4. |
| CWA | Must be a number between 0 to 100 |
| Status | Must be either FT or PT (case-Insensitive). |
| CreditsEarned | Must be 0 or a positive number. |

## Errors and Error handles

This application is designed to handle common errors gracefully.

- **File Errors:** If a filename is not provided or the specifies file cannot be found, the program will display an error and exit.
- **Input Mismatch:** If you entre text where a number is expected (or vice-versa), the program will report an "Input mismatch" Error and ask you to try again.
- **Invalid Data:** If you enter data that violates one of the validation rules (eg :- an invalid Student ID format or a CWA over 100), a specific error message is shown, and the program will prompt you to re-enter the data.


import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        System.out.print("Welcome to student management ");
        System.out.print("Enter the number of students to manage: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        int enteredStudents = 0; 

        while (true) {
            System.out.println("Please enter your request");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Info");
            System.out.println("3. Sort Students by Score");
            System.out.println("4. Remove Student");
            System.out.println("5. Find Student by ID");
            System.out.println("6. Print All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    if (enteredStudents >= numberOfStudents) {
                        System.out.println("You have exceeded the number of students to manage");
                        break;
                    }

                    Student newStudent = new Student();
                    System.out.print("Enter ID for new student: ");
                    newStudent.setId(scanner.nextLine());
                    
                    
                    if (studentManagement.checkId(newStudent.getId())) {
                        System.out.println("Student with ID " + newStudent.getId() + " already exists. Please enter a different ID.");
                        break; 
                    }

                    System.out.print("Enter Full Name for new student: ");
                    newStudent.setFullname(scanner.nextLine());

                    
                    double score;
                    while (true) {
                        System.out.print("Enter Score for new student: ");
                        score = scanner.nextDouble();
                        if (score > 10.0 || score < 0) {
                            newStudent.setScore(score);
                        } else {
                            newStudent.setScore(score);
                            break; 
                        }
                    }
                    scanner.nextLine(); 

                
                    studentManagement.addStudent(newStudent);
                    enteredStudents++; 
                    break;

                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    String Idstudent = scanner.nextLine();
                    
                    Student studentToUpdate = studentManagement.findStudentById(Idstudent);
                    if (studentToUpdate == null) {
                        System.out.println("Student with ID " + Idstudent + " does not exist.");
                        break; 
                    }
                    System.out.print("Enter new Full Name: ");
                    String newFullname = scanner.nextLine();
                    
                    double newScoreUpdate;
                    while (true) {
                        System.out.print("Enter new Score: ");
                        newScoreUpdate = scanner.nextDouble();
                        if (newScoreUpdate > 10.0 || newScoreUpdate < 0 ) {
                            System.out.println("Invalid score, student score must be between 0 - 10");
                        } else {
                            break; 
                        }
                    }
                    studentManagement.updateStudentById(Idstudent, newFullname, newScoreUpdate);
                    break;

                
                case 3: 
                    studentManagement.sortStudentsByScore();
                    System.out.println("Students sorted by score.");
                    break;

                case 4: 
                    System.out.print("Enter ID of the student to remove: ");
                    String removeId = scanner.nextLine();
                    studentManagement.removeStudent(removeId);
                    break;

                case 5: 
                    System.out.print("Enter ID of the student to find: ");
                    String findId = scanner.nextLine();
                    studentManagement.findStudentById(findId);
                    break;

                case 6: 
                    studentManagement.printAllStudents();
                    break;

                case 7: 
                    System.out.println("Exiting program");
                    return ; 

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

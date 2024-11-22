import java.util.ArrayList;

public class StudentManagement {
    ArrayList<Student> listStudent = new ArrayList<>();

    public void addStudent(Student student) {
        listStudent.add(student);
        System.out.println("The student just added to the student list is named: " + student.getFullname() + " id is: " + student.getId() + " score is: " + student.getScore() + " ranking is: " + student.getRank());  
    }
    public boolean checkId(String id) {
        for (Student s : listStudent) {
            if (s.getId().equals(id)) {
                return true; 
            }
        }
        return false; 
    }
    public void removeStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : listStudent) {
            if (student.getId().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            listStudent.remove(studentToRemove);
            System.out.println("Removed student: Name: " + studentToRemove.getFullname() 
                    + ", id is : " + studentToRemove.getId() 
                    + ", score is : " + studentToRemove.getScore() 
                    + ", ranking is : " + studentToRemove.getRank());
        } else {
            System.out.println("Student with ID " + studentId + " does not exist.");
        }
    }
    // public void sortStudentsByScore() {
    //     int n = listStudent.size();
    //     for (int i = 0; i < n - 1; i++) {
    //         for (int j = 0; j < n - i - 1; j++) {
    //             if (listStudent.get(j).getScore() < listStudent.get(j + 1).getScore()) {
    //                 Student index = listStudent.get(j);
    //                 listStudent.set(j, listStudent.get(j + 1));
    //                 listStudent.set(j + 1, index);
    //             }
    //         }
    //     }
    //     System.out.println("Students sorted by score from highest to lowest.");
    //     for (Student student : listStudent) {
    //         System.out.println("Name student is : " + student.getFullname() + ", ID is : " + student.getId() 
    //                 + ", Score is : " + student.getScore() + ", Rank is : " + student.getRank());
    //     }
    // }
    
    // public void sortStudentsByScore() {
    //     // Gọi hàm mergeSort để sắp xếp danh sách
    //     listStudent = mergeSort(listStudent);
    
    //     // In danh sách sinh viên sau khi sắp xếp
    //     System.out.println("Students sorted by score from highest to lowest.");
    //     for (Student student : listStudent) {
    //         System.out.println("Name student is : " + student.getFullname() + ", ID is : " + student.getId()
    //                 + ", Score is : " + student.getScore() + ", Rank is : " + student.getRank());
    //     }
    // }
    
    // // Hàm chính của thuật toán Merge Sort
    // private ArrayList<Student> mergeSort(ArrayList<Student> students) {
    //     if (students.size() <= 1) {
    //         return students; // Nếu danh sách chỉ có 1 phần tử hoặc rỗng thì trả về luôn
    //     }
    
    //     // Chia đôi danh sách
    //     int mid = students.size() / 2;
    //     ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
    //     ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));
    
    //     // Đệ quy để sắp xếp từng nửa
    //     left = mergeSort(left);
    //     right = mergeSort(right);
    
    //     // Gộp hai danh sách con đã sắp xếp
    //     return merge(left, right);
    // }
    
    // // Hàm merge để gộp hai danh sách đã sắp xếp
    // private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
    //     ArrayList<Student> merged = new ArrayList<>();
    //     int i = 0, j = 0;
    
    //     // So sánh từng phần tử của hai danh sách
    //     while (i < left.size() && j < right.size()) {
    //         if (left.get(i).getScore() >= right.get(j).getScore()) { // Sắp xếp từ cao xuống thấp
    //             merged.add(left.get(i));
    //             i++;
    //         } else {
    //             merged.add(right.get(j));
    //             j++;
    //         }
    //     }
    
    //     // Thêm các phần tử còn lại của danh sách bên trái
    //     while (i < left.size()) {
    //         merged.add(left.get(i));
    //         i++;
    //     }
    
    //     // Thêm các phần tử còn lại của danh sách bên phải
    //     while (j < right.size()) {
    //         merged.add(right.get(j));
    //         j++;
    //     }
    
    //     return merged;
    // }



    public Student findStudentById(String studentId) {
        for (Student student : listStudent) {
            if (student.getId().equals(studentId)) {
                System.out.println("Found student: Name: " + student.getFullname() 
                        + ", ID is : " + student.getId() 
                        + ", Score is : " + student.getScore() 
                        + ", Rank is : " + student.getRank());
                return student; 
            }
        }
        System.out.println("Student with ID " + studentId + " does not exist.");
        return null; 
    }

    public void updateStudentById(String studentId, String newFullname, Double newScore) {
        Student studentToUpdate = findStudentById(studentId); // Tìm học sinh theo ID
    
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + studentId + " does not exist.");
            return; // Không thực hiện cập nhật và quay lại menu
        }
    
        studentToUpdate.setFullname(newFullname);
    
        // Kiểm tra và nhập điểm
        if (newScore > 10.0 || newScore < 0 ) {
            studentToUpdate.setScore(newScore);
            return; // Thoát nếu điểm không hợp lệ
        }
        studentToUpdate.setScore(newScore);
    
        System.out.println("Updated student info: Name: " + studentToUpdate.getFullname() 
                + ", ID: " + studentToUpdate.getId() 
                + ", Score: " + studentToUpdate.getScore() 
                + ", Rank: " + studentToUpdate.getRank());
    }
    
    public void printAllStudents() {
        if (listStudent.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("Student List:");
        for (Student student : listStudent) {
            System.out.println("Name: " + student.getFullname() 
                    + ", ID is : " + student.getId() 
                    + ", Score is : " + student.getScore() 
                    + ", Rank is : " + student.getRank());
        }
    }
}

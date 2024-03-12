import java.util.Scanner;

public class StudentDB {
    public static void main(String[] args){

        // Ask for how many students we want to enroll
        System.out.print("Enter number of new students to enroll: ");
        Scanner sc = new Scanner(System.in);
        int numOfStudent = sc.nextInt();
        Student[] students = new Student[numOfStudent];

        //looping through each students
        for(int i = 0; i < numOfStudent; i++)
        {
            students[i] = new Student();
            // System.out.println(students[i].getStudentID());
            students[i].enroll();
            students[i].payTuition(); // currency: VND
        }

        for(int i = 0; i < numOfStudent; i++)
        {
            System.out.println(students[i].displayInfo());
        }
    }
}

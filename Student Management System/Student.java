import java.util.Scanner;

public class Student{
    private String lastName; // family name: Tran
    private String middleName; // mid name: Nam
    private String firstName; // people call: Son
    private String fullName;
    private int year; // ask year of student
    private String studentID;
    private String courses = "";
    private int tutionBalance = 0;
    private static int eachCourseCost = 700000; // currency: VND
    private int spareMoney;
    private static int id = 0;
    
    // Ask for students' name + enrolled year
    public Student(){
        System.out.println("Enter student's full name (example: Tran Nam Son):");
        Scanner sc = new Scanner(System.in);
        this.fullName = sc.nextLine();
        String shortName = fullName.replaceAll("\\s", "");
        System.out.print("Choose:\n1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's level: ");
        this.year = sc.nextInt();

        setStudentID();
        // System.out.println("Your student ID : " + shortName + studentID);
    }

    //Create personal ID
    private void setStudentID(){
        id++;
        this.studentID = year + "00" + id;
    }
    // Incase sb forgot their ID
    public String getStudentID(){
        return "Student's ID: " + studentID;
    }
    
    // Enroll in WHAT courses math/ philosophy
    public void enroll(){
        int countClass = 0;
        System.out.println("Select (MAX: 3 courses):");
        System.out.println("+-------+\n|MATH55 |\n|-------|\n|CS50   |\n|-------|\n|MBA45  |\n|-------|\n|HIS35  |\n|-------|\n|FIN25  |\n+-------+");
        do{
            System.out.print("Enter a course for enrollment ('Q' to quit): ");
            Scanner sc = new Scanner(System.in);
            String aCourse = sc.nextLine();
            aCourse = aCourse.toUpperCase();
            if(!aCourse.equals("Q")){
                this.courses = this.courses + " " + aCourse;
                this.tutionBalance = this.tutionBalance + eachCourseCost; 
                countClass ++;
            }
            else{
                break;
            }
        } while(countClass < 3);
        if (courses.equals("")){
            System.out.println("Enrolled in: none");
        }
        else{
            System.out.println("Enrolled in:" + courses);
        }
        System.out.println("Tuition (total): " + tutionBalance + " VND");
    }

    // Student want to pay tution
    public void payTuition(){
        System.out.print("Enter your payment in VND: ");
        Scanner sc = new Scanner(System.in);
        int payment = sc.nextInt();
        do{
            if(tutionBalance == 0){
                System.out.println("No tution needed to be pay, spare money: " + payment + " VND");
                break;
            } else{
                tutionBalance = tutionBalance - payment;
            }
    
            if (tutionBalance >= 0)
            {
                System.out.println("You've paid " + payment + "VND , remaining tution: " + tutionBalance + " VND");
                break;
            } else if (tutionBalance < 0) {
                spareMoney = Math.abs(tutionBalance);
                System.out.println("You have paid all enrolled courses, spare change : " + spareMoney + " VND");
                break;
            }
        }while( 1 != 0);
    }

    //display()
    public String displayInfo(){
        String balance = "";
        if (tutionBalance < 0){
                balance = "NONE \nSpare money: " +spareMoney + " VND";
        } else{
            balance = tutionBalance + " VND";
        }
        return "Full Name: " + fullName +
                "\nGrade level: " + year +
                "\nStudent's ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nTuition remain: " + balance; 
    }
}
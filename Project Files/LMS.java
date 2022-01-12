package Assignment_2;

import java.util.ArrayList;
import java.util.Scanner;


public class LMS{

    static Scanner input = new Scanner(System.in);
    private static final ArrayList<Student> student_list = new ArrayList<Student>();
    private static final ArrayList<Instructor> instructor_list = new ArrayList<Instructor>();


    public static ArrayList<Student> getStudent_list() {
        return student_list;
    }

    public static void add_instructor(String ID){
        for(int i = 0; i < instructor_list.size(); i++){
            if(instructor_list.get(i).getS_id().equals(ID)){
                System.out.println("Same ID already present!");
                return;
            }
        }
        Instructor ni = new Instructor();
        ni.setS_id(ID);
        instructor_list.add(ni);
    }

    public static void add_student(String ID){
        for(int i = 0; i < student_list.size(); i++){
            if(student_list.get(i).getS_id().equals(ID)){
                System.out.println("Same ID already present!");
                return;
            }
        }
        Student ns = new Student();
        ns.setS_id(ID);
        student_list.add(ns);
    }

    public static int display_instructors(){
        System.out.println("Instructors:");
        if(instructor_list.size() == 0){
            System.out.println("None! Please register atleast 1 instructor");
            return -1;
        }
        for(int i = 0; i < instructor_list.size(); i++){
            System.out.println(i + " - " + instructor_list.get(i).getS_id());
        }
        return 0;
    }

    public static int display_students(){
        System.out.println("Students:");
        if(student_list.size() == 0){
            System.out.println("None! Please register atleast 1 student");
            return -1;
        }
        for(int i = 0; i < student_list.size(); i++){
            System.out.println(i + " - " + student_list.get(i).getS_id());
        }
        return 0;
    }

    public static String get_instructor(int c_id){
        return instructor_list.get(c_id).getS_id();
    }

    public static String get_student(int c_id){
        return student_list.get(c_id).getS_id();
    }

//    public static void display_instructor_menu() {
//        System.out.println("INSTRUCTOR MENU");
//        System.out.println("1. Add Class Material");
//        System.out.println("2. Add Assessments");
//        System.out.println("3. View Lecture Materials");
//        System.out.println("4. View Assessments");
//        System.out.println("5. Grade Assessments");
//        System.out.println("6. Close Assessment");
//        System.out.println("7. View Comments");
//        System.out.println("8. Add Comments");
//        System.out.println("9. Logout");
//    }
//
//    public static void display_student_menu() {
//        System.out.println("STUDENT MENU");
//        System.out.println("1. View Lecture Materials");
//        System.out.println("2. View Assessments");
//        System.out.println("3. Submit Assessments");
//        System.out.println("4. View Grades");
//        System.out.println("5. View Comments");
//        System.out.println("6. Add Comments");
//        System.out.println("7. Logout");
//    }

    public static void run_instructor(String id){
        int i;
        int f = 0;
        Scanner input1 = new Scanner(System.in);
        for(i = 0; i < instructor_list.size() ; i++){
            if(instructor_list.get(i).getS_id().equals(id)){
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("No Instructor with given ID!!!");
            return;
        }
        while(true){
            System.out.println("Welcome " + id);
            instructor_list.get(i).display_menu();
            System.out.print("Enter Choice: ");
            int ch = input1.nextInt();
            if(ch < 1 || ch > 9){
                System.out.println("Invalid Choice!!!");
            }
            int l = instructor_list.get(i).call_choice(ch);
            if(l == -1){
                break;
            }
        }
    }

    public static void run_student(String id){
        int i;
        int f = 0;
        Scanner input1 = new Scanner(System.in);
        for(i = 0; i < student_list.size() ; i++){
            if(student_list.get(i).getS_id().equals(id)){
                f = 1;
                break;
            }
        }
        if (f == 0) {
            System.out.println("No Student with given ID!!!");
            return;
        }
        while(true){
            System.out.println("Welcome " + id);
            student_list.get(i).display_menu();
            System.out.print("Enter Choice: ");
            int ch = input1.nextInt();
            if(ch < 1 || ch > 7){
                System.out.println("Invalid Choice!!!");
            }
            int l = student_list.get(i).call_choice(ch);
            if(l == -1){
                break;
            }
        }
    }


}

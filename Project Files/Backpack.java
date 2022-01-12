package Assignment_2;

import java.util.Scanner;

public class Backpack {
    static Scanner input = new Scanner(System.in);

    public static void login_menu(){

        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as instructor");
        System.out.println("2. Enter as student");
        System.out.println("3. Exit");

    }

    public static void new_or_old_ins(){
        System.out.println("1. Enter as Existing Instructor");
        System.out.println("2. Enter as New Instructor");
    }

    public static void new_or_old_stu(){
        System.out.println("1. Enter as Existing Student");
        System.out.println("2. Enter as New Student");
    }

    public static void main(String[] args){
        int c;
        int f = 0;
        LMS.add_instructor("I0");
        LMS.add_instructor("I1");
        LMS.add_student("S0");
        LMS.add_student("S1");
        LMS.add_student("S2");
        while(true){
            login_menu();
            System.out.print("Enter Choice: ");
            try{
                c = input.nextInt();
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid Input!!");
                continue;
            }
            int ch;
            int empty;
            switch(c){
                case 1:
                    new_or_old_ins();
                    System.out.print("Enter Choice: ");
                    ch = input.nextInt();
                    switch(ch){
                        case 1:
                            empty = LMS.display_instructors();
                            if(empty == 0){
                                System.out.print("Choose ID: ");
                                int c_id = input.nextInt();
                                LMS.run_instructor(LMS.get_instructor(c_id));
                            }
                            break;
                        case 2:
                            System.out.print("Enter ID for new Instructor: ");
                            String n_id = input.next();
                            LMS.add_instructor(n_id);
                            LMS.run_instructor(n_id);
                            break;
                        default: System.out.println("Invalid Service number entered!!");
                            break;
                    }
                    break;
                case 2:
                    new_or_old_stu();
                    System.out.print("Enter Choice: ");
                    ch = input.nextInt();
                    switch(ch){
                        case 1:
                            empty = LMS.display_students();
                            if(empty == 0){
                                System.out.print("Choose ID: ");
                                int c_id = input.nextInt();
                                LMS.run_student(LMS.get_student(c_id));
                            }
                            break;
                        case 2:
                            System.out.print("Enter ID for new Student: ");
                            String n_id = input.next();
                            LMS.add_student(n_id);
                            LMS.run_student(n_id);
                            break;
                        default: System.out.println("Invalid Service number entered!!");
                            break;
                    }
                    break;
                case 3: System.out.println("Thanks a lot for visiting Backpack");
                    f = 1;
                    break;
                default: System.out.println("Invalid Service number entered!! \nPlease try again!!");
                    break;
            }
            if(f == 1){
                break;
            }
        }
    }

}

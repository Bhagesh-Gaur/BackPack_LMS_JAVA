package Assignment_2;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Tasks implements Instructor_task, Student_task{

    static Scanner input = new Scanner(System.in);
    private static ArrayList<Comments> comments_list = new ArrayList<Comments>();
    private static ArrayList<Lecture_mat> material_list = new ArrayList<Lecture_mat>();
    private static ArrayList<Assess> asse = new ArrayList<Assess>();
    private static ArrayList<Assess> closed_asse = new ArrayList<Assess>();
    //Common Functions
    @Override
    public void view_lec_mat(){
//        System.out.println("Common: for view lecture materials");
        for (int i = 0; i < material_list.size() ; i++){
            material_list.get(i).view_mat();
            System.out.println();
        }
    }

    @Override
    public void view_assess(){
//        System.out.println("Common: for view assessment");
        int i = 0;
        System.out.println("Open Assessments:");
        if(asse.size() == 0){
            System.out.println("None!");
        }
        else{
            for (i = 0; i < asse.size() ; i++){
                System.out.print("ID: " + i + " ");
                asse.get(i).view_asse();
                System.out.println("----------------");
            }
        }

//        System.out.println("Closed Assessments:");
//        if(closed_asse.size() == 0){
//            System.out.println("None!");
//        }
//        else{
//            for (int j = 0; j < closed_asse.size() ; j++){
//                System.out.print("ID: " + (i+j) + " ");
//                closed_asse.get(j).view_asse();
//                System.out.println("----------------");
//            }
//        }
    }

    @Override
    public void view_comments() {
//        System.out.println("Common: for view comments");
        for (int i = 0 ; i < comments_list.size() ; i++){
            System.out.println(comments_list.get(i).getCom() + " - " + comments_list.get(i).getId());
            System.out.println(String.format("%tc", comments_list.get(i).getC_date()));
            System.out.println();
        }
    }

    @Override
    public void add_comments(String id){
//        System.out.println("Common: for add comments");
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter comment: ");
        String s = input1.nextLine();
        Date d = new Date();
        Comments co = new Comments(id, s, d);
        comments_list.add(co);
    }

    //Instructor Functions
    @Override
    public void add_class_mat(Instructor ins){
//        System.out.println("Ins: for add class materials");
        int c;
        int f = 0;
        while(true) {
            System.out.println("1. Add Lecture Slide");
            System.out.println("2. Add Lecture Video");
            System.out.print("Enter Choice: ");
            try {
                c = input.nextInt();
//                input.nextLine();
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Input!!");
                continue;
            }
            Lecture_mat lm;
            switch (c) {
                case 1: lm = new Lec_mat_slide(ins);
                    material_list.add(lm);
                    f = 1;
                    break;
                case 2: lm = new Lec_mat_video(ins);
                    material_list.add(lm);
                    f = 1;
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
            if(f == 1){
                break;
            }
        }
    }

    @Override
    public void add_assess(Instructor ins){
//        System.out.println("Ins: for add assessment");
        int c;
        int f = 0;
        while(true) {
            System.out.println("1. Add Assignment");
            System.out.println("2. Add Quiz");
            System.out.print("Enter Choice: ");
            try {
                c = input.nextInt();
//                input.nextLine();
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Input!!");
                continue;
            }
            Assess a;
            String s;
            int m;
            switch (c) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter problem statement: ");
                    s = input.nextLine();
                    System.out.print("Enter max marks: ");
                    m = input.nextInt();
                    a = new Assess(s, m, ins);
                    asse.add(a);
                    f = 1;
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter quiz question: ");
                    s = input.nextLine();
                    a = new Assess(s, ins);
                    asse.add(a);
                    f = 1;
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
            if(f == 1){
                break;
            }
        }
    }

    @Override
    public void grade_assess(Instructor ins) {
//        System.out.println("Ins: for grade assessment");
        if(asse.size()==0 && closed_asse.size()==0){
            System.out.println("No Assessments to be graded");
            return;
        }
        System.out.println("List of assessments");
        int i;
        for (i = 0; i < asse.size() ; i++){
            System.out.print("ID: " + i + " ");
            asse.get(i).view_asse();
            System.out.println("----------------");
        }
        int j;
        for (j = 0; j < closed_asse.size() ; j++){
            System.out.print("ID: " + (i+j) + " ");
            closed_asse.get(j).view_asse();
            System.out.println("----------------");
        }
        int ch;
        System.out.print("Enter ID of assessment to view submissions: ");
        ch = input.nextInt();
        if(ch < 0 || ch >=(i+j)){
            System.out.println("Invalid Choice!");
            return;
        }
        Assess ca;
        if(ch < i){
            //open assignment
            ca = asse.get(ch);
        }
        else{
            //closed assignment
            ca = closed_asse.get(ch-i);
        }
        System.out.println("Choose ID from these ungraded submissions");
        ArrayList<Student> stu_sub = LMS.getStudent_list();
        ArrayList<Student> students_check = new ArrayList<Student>();
        int count = 0;
        for(int k = 0 ; k < stu_sub.size() ; k++){
            for(int l = 0 ; l < stu_sub.get(k).getAsse_sub().size() ; l++){
                if(stu_sub.get(k).getAsse_sub().get(l).getQue().getQues().equals(ca.getQues()) && stu_sub.get(k).getAsse_sub().get(l).getGraded() == -1 && (stu_sub.get(k).getAsse_sub().get(l).getQue().getMax_m()== ca.getMax_m())){
                    System.out.println(count + ". " + stu_sub.get(k).getS_id());
                    students_check.add(stu_sub.get(k));
                    count++;
                }
            }
        }
        if(students_check.size()==0){
            System.out.println("No submissions!");
            return;
        }
        System.out.print("Choose ID: ");
        int check_id = input.nextInt();
        Student tocheck = students_check.get(check_id);
        int f = 0;
        for(int l = 0 ; l < tocheck.getAsse_sub().size() ; l++){
            if(tocheck.getAsse_sub().get(l).getQue().getQues().equals(ca.getQues()) && tocheck.getAsse_sub().get(l).getGraded() == -1 && (tocheck.getAsse_sub().get(l).getQue().getMax_m()== ca.getMax_m())){
                f = 1;
                System.out.print("Submission: ");
                System.out.println(tocheck.getAsse_sub().get(l).getAns());
                System.out.println("-------------------------------");
                int ms;
                while(true){
                    System.out.println("Max Marks: " + tocheck.getAsse_sub().get(l).getQue().getMax_m());
                    System.out.print("Marks Scored: ");
                    ms = input.nextInt();
                    if(ms < 0 || ms > tocheck.getAsse_sub().get(l).getQue().getMax_m()){
                        System.out.println("Invalid Marks!");
                    }
                    else{
                        tocheck.getAsse_sub().get(l).setGraded(ms);
                        tocheck.getAsse_sub().get(l).setGrader(ins);
                        break;
                    }
                }
            }
            if(f == 1){
                break;
            }
        }


    }

    @Override
    public void close_assess(){
//        System.out.println("Ins: for closing assessment");
        System.out.println("List of Open Assignments: ");
        int i = 0;
        if(asse.size() == 0){
            System.out.println("None");
            return;
        }
        else{
            for (i = 0; i < asse.size() ; i++){
                System.out.print("ID: " + i + " ");
                asse.get(i).view_asse();
                System.out.println("----------------");
            }
            System.out.print("Enter id of assignment to close: ");
            int id = input.nextInt();
            if(id < 0 || id >= i){
                System.out.println("Invalid ID!!");
                return;
            }
            closed_asse.add(asse.get(id));
            asse.remove(id);
        }

    }

    //Student Functions
    @Override
    public void submit_assess(Student stu) {
//        System.out.println("Student: for submit assessment");
        ArrayList<Assess> pen_a = new ArrayList<Assess>();
//        System.out.println("Pending assessments: ");
        int f = 0;
        for(int i = 0; i < asse.size() ; i++){
            f = 0;
            for(int j = 0; j < stu.getAsse_sub().size(); j++){
                if(stu.getAsse_sub().get(j).getQue().getQues().equals(asse.get(i).getQues())){
                    f = 1;
                    break;
                }
            }
            if(f == 0){
                pen_a.add(asse.get(i));
            }
        }
        if (pen_a.size() == 0) {
            System.out.println("No pending assessments");
            return;
        }
        System.out.println("Pending assessments:");
        int i;
        for(i = 0; i < pen_a.size() ; i++){
            System.out.print("ID: " + i + " ");
            pen_a.get(i).view_asse();
        }
        System.out.print("Enter ID of assessment: ");
        int id = input.nextInt();
        if(id < 0 || id >= i){
            System.out.println("Invalid ID!!");
            return;
        }
        Submission submit = new Submission();
        String ans;
        if(pen_a.get(id).getQu() == 0){
            input.nextLine();
            while(true){
                System.out.print("Enter filename of assignment: ");
                ans = input.nextLine();
                if(ans.length() > 4 && ans.substring(ans.length()-4).equals(".zip")){
                    break;
                }
                System.out.println("Invalid filename!! Please enter a valid .zip filename.");
            }
            submit.setQue(pen_a.get(id));
            submit.setAns(ans);
//            ArrayList<Submission> sub = stu.getAsse_sub();
//            sub.add(submit);
            stu.setAsse_sub(submit);
        }
        else if(pen_a.get(id).getQu() == 1){
            input.nextLine();
            while(true){
                String x;
                System.out.print(pen_a.get(id).getQues() + " ");
                ans = input.next();
                x = input.nextLine();
                if(x.length() == 0){
                    break;
                }
                System.out.println("Invalid ans!! Enter only 1 word without spaces.");
            }
            submit.setQue(pen_a.get(id));
            submit.setAns(ans);
//            ArrayList<Submission> sub = stu.getAsse_sub();
//            sub.add(submit);
            stu.setAsse_sub(submit);
        }
    }

    @Override
    public void view_grade(Student stu){
//        System.out.println("Student: for grade assessment");
        System.out.println("Graded submissions");
        for(int j = 0; j < stu.getAsse_sub().size(); j++){
            if(stu.getAsse_sub().get(j).getGraded() != -1){
                System.out.println("Submission:" + stu.getAsse_sub().get(j).getAns());
                System.out.println("Marks scored: " + stu.getAsse_sub().get(j).getGraded());
                System.out.println("Graded by: " + stu.getAsse_sub().get(j).getGrader().getS_id());
            }
        }
        System.out.println("----------------------------");
        System.out.println("Ungraded submissions");
        for(int j = 0; j < stu.getAsse_sub().size(); j++){
            if(stu.getAsse_sub().get(j).getGraded() == -1){
                System.out.println("Submission:" + stu.getAsse_sub().get(j).getAns());
            }
        }
        System.out.println("----------------------------");
    }
}

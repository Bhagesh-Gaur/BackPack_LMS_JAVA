package Assignment_2;

import java.util.ArrayList;

public class Student implements Account{
    private String s_id;
    private Student_task sfa;
    private ArrayList<Submission> asse_sub;


    public void setS_id(String s_id) {
        this.s_id = s_id;
        this.sfa = new Tasks();
        this.asse_sub = new ArrayList<Submission>();
    }

    public ArrayList<Submission> getAsse_sub() {
        return asse_sub;
    }

    public void setAsse_sub(Submission sub) {
        this.asse_sub.add(sub);
    }

    public String getS_id() {
        return s_id;
    }

    public Student_task getSfa() {
        return sfa;
    }

    public void display_menu() {
        System.out.println("STUDENT MENU");
        System.out.println("1. View Lecture Materials");
        System.out.println("2. View Assessments");
        System.out.println("3. Submit Assessments");
        System.out.println("4. View Grades");
        System.out.println("5. View Comments");
        System.out.println("6. Add Comments");
        System.out.println("7. Logout");
    }

    public int call_choice(int c){
        switch(c) {
            case 1: this.sfa.view_lec_mat();
                break;
            case 2: this.sfa.view_assess();
                break;
            case 3: this.sfa.submit_assess(this);
                break;
            case 4: this.sfa.view_grade(this);
                break;
            case 5: this.sfa.view_comments();
                break;
            case 6: this.sfa.add_comments(this.getS_id());
                break;
            case 7: return -1;
        }
        return 1;
    }
}

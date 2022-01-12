package Assignment_2;

public class Instructor implements Account{
    private String i_id;
    private Instructor_task ifa;

    public void setS_id(String i_id) {
        this.i_id = i_id;
        ifa = new Tasks();
    }

    public String getS_id() {
        return i_id;
    }

    public Instructor_task getIfa() {
        return ifa;
    }

    public void display_menu() {
        System.out.println("INSTRUCTOR MENU");
        System.out.println("1. Add Class Material");
        System.out.println("2. Add Assessments");
        System.out.println("3. View Lecture Materials");
        System.out.println("4. View Assessments");
        System.out.println("5. Grade Assessments");
        System.out.println("6. Close Assessment");
        System.out.println("7. View Comments");
        System.out.println("8. Add Comments");
        System.out.println("9. Logout");
    }

    public int call_choice(int c){
        switch(c){
            case 1: this.ifa.add_class_mat(this);
                break;
            case 2: this.ifa.add_assess(this);
                break;
            case 3: this.ifa.view_lec_mat();
                break;
            case 4: this.ifa.view_assess();
                break;
            case 5: this.ifa.grade_assess(this);
                break;
            case 6: this.ifa.close_assess();
                break;
            case 7: this.ifa.view_comments();
                break;
            case 8: this.ifa.add_comments(this.getS_id());
                break;
            case 9: return -1;
        }
        return 1;
    }


}

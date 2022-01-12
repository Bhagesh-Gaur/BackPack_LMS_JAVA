package Assignment_2;

import java.util.Scanner;

public class Assess {
    private String ques;
    private int max_m;
    private Instructor ins;
    private int qu;

    Scanner input = new Scanner(System.in);

    public Assess(String q, Instructor ins){
        this.ins = ins;
        this.ques = q;
        this.max_m = 1;
        this.qu = 1;
    }

    public Assess(String q, int m, Instructor insc){
        this.ins = ins;
        this.ques = q;
        this.max_m = m;
        this.qu = 0;
    }

    public void view_asse(){
        if(this.qu == 0){
            System.out.println("Assignment: " + this.ques + " Max Marks: " + this.max_m);
        }
        else{
            System.out.println("Question: " + this.ques);
        }
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public int getMax_m() {
        return max_m;
    }

    public void setMax_m(int max_m) {
        this.max_m = max_m;
    }

    public Instructor getIns() {
        return ins;
    }

    public void setIns(Instructor ins) {
        this.ins = ins;
    }

    public int getQu() {
        return qu;
    }

    public void setQu(int qu) {
        this.qu = qu;
    }
}

package Assignment_2;

public class Submission {
    private Assess que;
    private String ans;
    private int graded;
    private Instructor grader;

    public Submission(){
        this.graded = -1;
    }

    public Assess getQue() {
        return que;
    }

    public void setQue(Assess que) {
        this.que = que;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getGraded() {
        return graded;
    }

    public void setGraded(int graded) {
        this.graded = graded;
    }

    public Instructor getGrader() {
        return grader;
    }

    public void setGrader(Instructor grader) {
        this.grader = grader;
    }
}

package Assignment_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lec_mat_slide implements Lecture_mat{
    private String title;
    private int num_slides;
    private ArrayList<String> content = new ArrayList<String>();
    private Date d;
    private Instructor ins;

    Scanner input = new Scanner(System.in);

//    @Override
    public Lec_mat_slide(Instructor ins) {
        System.out.print("Enter topic of Slides: ");
        this.title = input.nextLine();
        System.out.print("Enter number of Slides: ");
        this.num_slides = input.nextInt();
        input.nextLine();
        System.out.println("Enter content of Slides: ");
        String c;
        for (int i = 0; i < num_slides ; i++){
            System.out.print("Content of Slide " + (i+1) + ": ");
            c = input.nextLine();
            content.add(c);
        }
        this.d = new Date();
        this.ins = ins;
    }

    @Override
    public void view_mat() {
        System.out.println("Title: " + this.title);
        for (int i = 0; i < this.num_slides ; i++){
            System.out.println("Slide " + i+1 + ": " + this.content.get((i)));
        }
        System.out.println("Number of slides: " + this.num_slides);
        System.out.println("Date of upload: " + String.format("%tc", this.d));
        System.out.println("Uploaded by: " + this.ins.getS_id());
    }

}

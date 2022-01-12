package Assignment_2;

import java.util.Date;
import java.util.Scanner;

public class Lec_mat_video implements Lecture_mat{
    private String topic;
    private String filename;
    private Date d;
    private Instructor ins;

    Scanner input = new Scanner(System.in);

//    @Override
    public Lec_mat_video(Instructor ins) {//add_mat
        System.out.print("Enter topic of Video: ");
        this.topic = input.nextLine();
        while(true){
            System.out.print("Enter filename of Video: ");
            this.filename = input.nextLine();
            if(this.filename.length() > 4 && this.filename.substring(this.filename.length()-4).equals(".mp4")){
                break;
            }
            System.out.println("Invalid filename!! Please enter a valid .mp4 filename.");
        }
        this.d = new Date();
        this.ins = ins;
    }

    @Override
    public void view_mat() {
        System.out.println("Title of video: " + this.topic);
        System.out.println("Video file: " + this.filename);
        System.out.println("Date of upload: " + String.format("%tc", this.d));
        System.out.println("Uploaded by: " + this.ins.getS_id());
    }

}

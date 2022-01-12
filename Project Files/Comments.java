package Assignment_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {

    private String id;
    private String com;
    private Date c_date;

    public Comments(String id, String com, Date c_date) {
        this.id = id;
        this.com = com;
        this.c_date = c_date;
    }

    public String getId() {
        return id;
    }

    public String getCom() {
        return com;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }
}

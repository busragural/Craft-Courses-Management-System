package management;

import java.util.Date;

public class Payment {
    private int paymentID;
    private Student payer;
    private Course course;
    private double amount;
    private Date date;
    private String method;

    public Payment(Student payer, Course course, double amount, Date date, String method) {
        this.payer = payer;
        this.course = course;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public Student getPayer() {
        return payer;
    }

    public Course getCourse() {
        return course;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getMethod() {
        return method;
    }
}

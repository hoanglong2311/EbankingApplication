
package model.bussiness;

import java.sql.Date;


public class Translog {
    private int accNo;
    private int logId;
    private Date time;
    private String task;
    private double amount;
    private double postBalance;

    public Translog() {
    }

    public Translog(int accNo, String task, double amount, double postBalance) {
        this.accNo = accNo;
        this.task = task;
        this.amount = amount;
        this.postBalance = postBalance;
    }
    
    
    public Translog(int accNo, int logId, Date time, String task, double amount, double postBalance) {
        this.accNo = accNo;
        this.logId = logId;
        this.time = time;
        this.task = task;
        this.amount = amount;
        this.postBalance = postBalance;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(double postBalance) {
        this.postBalance = postBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    

    @Override
    public String toString() {
        return "Translog{" + "logId=" + logId + ", time=" + time + ", task=" + task + ", amount=" + amount + ", postBalance=" + postBalance + '}';
    }
    
    
    
    
}

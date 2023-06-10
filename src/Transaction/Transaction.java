package Transaction;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int custId;
    private int itemId;
    private Date startDate;
    private Date endDate;
    private Date returnDate;
    private double rentalFee;

    public Transaction() {
    }

    public Transaction(int transactionId, int custId, int itemId, Date startDate, Date endDate, Date returnDate, double rentalFee) {
        this.transactionId = transactionId;
        this.custId = custId;
        this.itemId = itemId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.rentalFee = rentalFee;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }
}

package Model;

import java.util.Date;

public class Payment {
    public int      receiptNumber;
    public String   employeeNumber;
    public Date paymentDate;
    public String   accountNumber;
    public Date	firstDayOccupied;
    public Date lastDayOccupied;
    public int      totalNights;
    public double	amountCharged;
    public double	subTotal;
    public double	taxRate;
    public double	taxAmount;
    public double   totalAmountPaid;

    public Payment(int receiptNumber, String employeeNumber, Date paymentDate, String accountNumber, Date firstDayOccupied, Date lastDayOccupied, int totalNights, double amountCharged, double subTotal, double taxRate, double taxAmount, double totalAmountPaid) {
        this.receiptNumber = receiptNumber;
        this.employeeNumber = employeeNumber;
        this.paymentDate = paymentDate;
        this.accountNumber = accountNumber;
        this.firstDayOccupied = firstDayOccupied;
        this.lastDayOccupied = lastDayOccupied;
        this.totalNights = totalNights;
        this.amountCharged = amountCharged;
        this.subTotal = subTotal;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getFirstDayOccupied() {
        return firstDayOccupied;
    }

    public void setFirstDayOccupied(Date firstDayOccupied) {
        this.firstDayOccupied = firstDayOccupied;
    }

    public Date getLastDayOccupied() {
        return lastDayOccupied;
    }

    public void setLastDayOccupied(Date lastDayOccupied) {
        this.lastDayOccupied = lastDayOccupied;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
}

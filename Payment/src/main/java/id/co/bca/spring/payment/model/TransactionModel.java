package id.co.bca.spring.payment.model;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table(name="transaction")
public class TransactionModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "tran_date")
    private String tran_date;
    @Column(name = "package_id")
    private int packageId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "qty")
    private int qty;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "invoice_reff_no")
    private String invoiceReffNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTran_date() {
        return tran_date;
    }

    public void setTran_date(String tran_date) {
        this.tran_date = tran_date;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvoiceReffNo() {
        return invoiceReffNo;
    }

    public void setInvoiceReffNo(String invoiceReffNo) {
        this.invoiceReffNo = invoiceReffNo;
    }
}

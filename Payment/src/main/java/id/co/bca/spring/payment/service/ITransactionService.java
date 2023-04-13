package id.co.bca.spring.payment.service;

import id.co.bca.spring.payment.model.TransactionModel;

public interface ITransactionService {
    void insert(TransactionModel transaction);
    void update(TransactionModel transaction);
    TransactionModel findTheTransaction(TransactionModel transaction);
}

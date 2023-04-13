package id.co.bca.spring.payment.service;

import id.co.bca.spring.payment.model.TransactionModel;

import java.util.List;

public interface ITransactionService {
    TransactionModel insert(TransactionModel transaction);
    TransactionModel update(TransactionModel transaction);
    TransactionModel delete(TransactionModel transaction);
    List<TransactionModel> findAllByCustomerId(int customerId);
}

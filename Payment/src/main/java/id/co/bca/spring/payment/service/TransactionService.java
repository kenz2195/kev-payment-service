package id.co.bca.spring.payment.service;

import id.co.bca.spring.payment.model.TransactionModel;
import id.co.bca.spring.payment.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    TransactionRepo transactionRepo;


    @Override
    public void insert(TransactionModel transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public void update(TransactionModel transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public TransactionModel findTheTransaction(TransactionModel transaction) {
        return transactionRepo.findTransactionByCustId(transaction.getCustomerId());
    }
}

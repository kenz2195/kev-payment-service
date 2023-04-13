package id.co.bca.spring.payment.service;

import id.co.bca.spring.payment.model.TransactionModel;
import id.co.bca.spring.payment.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    TransactionRepo transactionRepo;


    @Override
    public TransactionModel insert(TransactionModel transaction) {
        transactionRepo.save(transaction);
        return transaction;
    }

    @Override
    public TransactionModel update(TransactionModel transaction) {
        transactionRepo.save(transaction);
        return transaction;
    }

    @Override
    public TransactionModel delete(TransactionModel transaction){
        transactionRepo.deleteById(transaction.getId());
        return transaction;
    }

    @Override
    public List<TransactionModel> findAllByCustomerId(int customerId) {
        return transactionRepo.findAllByCustomerId(customerId);
    }
}

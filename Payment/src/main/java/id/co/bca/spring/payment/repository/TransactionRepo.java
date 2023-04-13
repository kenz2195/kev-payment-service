package id.co.bca.spring.payment.repository;

import id.co.bca.spring.payment.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<TransactionModel, Integer> {
    TransactionModel findTransactionByCustId(Integer aInteger);
    List<TransactionModel> findAllByOrderByCustomerId();
}

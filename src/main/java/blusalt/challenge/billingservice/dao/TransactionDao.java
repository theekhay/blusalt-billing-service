package blusalt.challenge.billingservice.dao;


import blusalt.challenge.billingservice.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionDao extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
}

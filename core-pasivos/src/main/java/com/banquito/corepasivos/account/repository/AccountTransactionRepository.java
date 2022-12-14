package com.banquito.corepasivos.account.repository;

import com.banquito.corepasivos.account.model.AccountTransaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    List<AccountTransaction> findByCodeLocalAccount(String codeLocalAccount);
    List<AccountTransaction> findByCodeUniqueTransaction(String codeUniqueTransaction);
    List<AccountTransaction> findByStatus(String status);
    List<AccountTransaction> findByRecipientBank(String recipientBank);
    
    List<AccountTransaction> findByExecuteDateBetween(Date start,Date end);

    List<AccountTransaction> findAllByCodeLocalAccountAndCodeInternationalAccount(String codeLocalAccount,
    String codeInternationalAccount);

    List<AccountTransaction> findAllByCodeLocalAccountAndCodeInternationalAccountAndType(String codeLocalAccount,
    String codeInternationalAccount,String type);

    List<AccountTransaction> findAllByCodeLocalAccountAndCodeInternationalAccountAndRecipientBank(String codeLocalAccount,
    String codeInternationalAccount,String recipientBank);

    List<AccountTransaction> findAllByCodeLocalAccountAndCodeInternationalAccountAndStatus(String codeLocalAccount,
    String codeInternationalAccount,String status);

}


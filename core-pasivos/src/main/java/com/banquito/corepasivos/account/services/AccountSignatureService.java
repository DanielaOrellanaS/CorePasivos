package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.account.repository.AccountSignatureRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class AccountSignatureService {
    private final AccountSignatureRepository accountSignatureRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountSignatureService(AccountSignatureRepository accountSignatureRepository,
            AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.accountSignatureRepository = accountSignatureRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public List<AccountSignature> findAll() {
        return this.accountSignatureRepository.findAll();
    }

    public List<AccountSignature> findByCodeAccount(String code) {
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if (!accountSignatures.isEmpty()) {
            return accountSignatures;
        } else {
            return null;
        }
    }

    public void register(AccountSignature accountSignature) {
        boolean existClient = this.clientRepository.existsById(accountSignature.getClient().getPk());
        boolean existeAccount = this.accountRepository.existsById(accountSignature.getAccount().getPk());
        List<AccountSignature> accountSignatures = this.accountSignatureRepository
                .findBySignatureReference(accountSignature.getSignatureReference());
        if (existClient && existeAccount && accountSignatures.isEmpty()) {
            this.accountSignatureRepository.save(accountSignature);
        } else{
            throw new RuntimeException("The entry data is incorrect");
        }
    }

    @Transactional
    public void delete (String code){
        List<AccountSignature> accountSignatures = this.accountSignatureRepository.findByPkCodelocalaccount(code);
        if (!accountSignatures.isEmpty()) {
            accountSignatures.get(0).setStatus("INA");
            this.accountSignatureRepository.save(accountSignatures.get(0));
        } else {
            throw new RuntimeException("The entry code does not belong to an account");
        }
    }
}
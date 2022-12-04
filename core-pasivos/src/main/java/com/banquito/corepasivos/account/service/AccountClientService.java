package com.banquito.corepasivos.account.service;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.repository.AccountClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountClientService {

    private final AccountClientRepository accountClientRepository;

    public AccountClientService(AccountClientRepository accountClientRepository) {
        this.accountClientRepository = accountClientRepository;
    }

    public List<AccountClient> findAllAccountClient() {
        return accountClientRepository.findAll();
    }
}

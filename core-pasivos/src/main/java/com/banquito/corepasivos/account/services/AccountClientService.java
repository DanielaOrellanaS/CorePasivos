package com.banquito.corepasivos.account.services;

import com.banquito.corepasivos.account.model.AccountClient;
import com.banquito.corepasivos.account.repository.AccountClientRepository;
import com.banquito.corepasivos.account.repository.AccountRepository;
import com.banquito.corepasivos.client.repository.ClientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountClientService {

    private final AccountClientRepository accountClientRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountClientService(AccountClientRepository accountClientRepository, AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.accountClientRepository = accountClientRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(AccountClient accountClient) {
        if (!accountRepository.existsByPkCodelocalaccount(accountClient.getPk().getCodelocalaccount()))
            throw new RuntimeException("Local account entered does not exist.");

        if (!accountRepository.existsByPkCodeinternationalaccount(accountClient.getPk().getCodeinternationalaccount()))
            throw new RuntimeException("International account entered does not exist.");

        if (!clientRepository.existsByPkIdentification(accountClient.getPk().getIdentification()))
            throw new RuntimeException("Client identification entered does not exist.");


        this.accountClientRepository.save(accountClient);
    }

    public List<AccountClient> findAll() {
        List<AccountClient> accountClients = this.accountClientRepository.findAll();

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClients not found.");

        return accountClients;
    }

    public List<AccountClient> findByCodeLocalAccount(String codeLocalAccount) {
        List<AccountClient> accountsByCodeLocalAccount = this.accountClientRepository
                .findByPkCodelocalaccount(codeLocalAccount);

        if (accountsByCodeLocalAccount.isEmpty())
            throw new RuntimeException("AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        return accountsByCodeLocalAccount;
    }

    public List<AccountClient> findByCodeInternationalAccount(String codeInternationalAccount) {
        List<AccountClient> accountsByCodeInternationalAccount = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountsByCodeInternationalAccount.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-international-account: " + codeInternationalAccount + " not found.");

        return accountsByCodeInternationalAccount;
    }

    public List<AccountClient> findByIndentificationType(String identificationType) {
        List<AccountClient> accountsByIdentificationType = this.accountClientRepository
                .findByPkIdentificationtype(identificationType);

        if (accountsByIdentificationType.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification-type: " + identificationType + " not found.");

        return accountsByIdentificationType;
    }

    public List<AccountClient> findByIndentification(String identification) {
        List<AccountClient> accountsByIdentification = this.accountClientRepository
                .findByPkIdentification(identification);

        if (accountsByIdentification.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification: " + identification + " not found.");

        return accountsByIdentification;
    }

    public List<AccountClient> findByStatus(String status) {
        List<AccountClient> accountsByStatus = this.accountClientRepository.findByStatus(status);

        if (accountsByStatus.isEmpty())
            throw new RuntimeException("AccountClient with status: " + status + " not found.");

        return accountsByStatus;
    }

    @Transactional
    public void updateByCodeLocalAccount(String codeLocalAccount, AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void updateByCodeInternationalAccount(String codeInternationalAccount,
            AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-international-account: " + codeInternationalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void updateByIdentification(String identification, AccountClient accountClientDetails) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkIdentification(identification);

        if (accountClients.isEmpty())
            throw new RuntimeException("AccountClient with identification: " + identification + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus(accountClientDetails.getStatus());
        accountClient.setCreateDate(accountClientDetails.getCreateDate());

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void deleteByCodeLocalAccount(String codeLocalAccount) {
        List<AccountClient> accountClients = this.accountClientRepository.findByPkCodelocalaccount(codeLocalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-local-account: " + codeLocalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void deleteByCodeInternationalAccount(String codeInternationalAccount) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkCodeinternationalaccount(codeInternationalAccount);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with code-International-account: " + codeInternationalAccount + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        this.accountClientRepository.save(accountClient);
    }

    @Transactional
    public void deleteByIdentification(String Identification) {
        List<AccountClient> accountClients = this.accountClientRepository
                .findByPkIdentification(Identification);

        if (accountClients.isEmpty())
            throw new RuntimeException(
                    "AccountClient with identification: " + Identification + " not found.");

        AccountClient accountClient = accountClients.get(0);
        accountClient.setStatus("INA");

        this.accountClientRepository.save(accountClient);
    }
}

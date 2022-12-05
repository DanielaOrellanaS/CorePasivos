package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientPhonePK;

@Repository
public interface ClientPhoneRepository  extends JpaRepository<ClientPhone, ClientPhonePK> {
    List<ClientPhone> findByPkIdentificationEquals(String identification);
    List<ClientPhone> removeByPkIdentification(String identification);
    List<ClientPhone> deleteByPkIdentification(String identification);
    // List<ClientPhone> setPkPhonenumberFor(String phoneNumber, String identification);
}
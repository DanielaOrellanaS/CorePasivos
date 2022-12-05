package com.banquito.corepasivos.client.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.service.ClientReferenceService;

@RestController
@RequestMapping("/api/clientsreferences")
public class ClientReferenceController {
    private final ClientReferenceService clientReferenceService;

    public ClientReferenceController(ClientReferenceService clientReferenceService) {
        this.clientReferenceService = clientReferenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientReference>> findReferences() {
        List<ClientReference> clientReference = this.clientReferenceService.findAllClientReferences();
        if (clientReference == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(clientReference);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<ClientReference>> findReferences(
            @PathVariable("id") String id) {
        List<ClientReference> clientReference = this.clientReferenceService.findAllClientReference(id);
        if (clientReference == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(clientReference);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> createClientReference(@RequestBody ClientReference clientRef) {
        try {
            this.clientReferenceService.saveClientReference(clientRef);
            return ResponseEntity.ok("Client reference created succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> updateClientReference(@RequestBody ClientReference clientRef) {
        try {
            this.clientReferenceService.updateClientReference(clientRef);
            return ResponseEntity.ok("Client reference updated succesfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{codeReference}")
    public ResponseEntity<String> deleteClientReference(
            @PathVariable("codeReference") Integer codeReference) {
        try {
            this.clientReferenceService.deleteClientReference(codeReference);
            return ResponseEntity.ok("Direccion eliminada con exito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
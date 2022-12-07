package com.banquito.corepasivos.account.controller;

import com.banquito.corepasivos.account.model.AccountSignature;
import com.banquito.corepasivos.account.services.AccountSignatureService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account-signature")
public class AccountSignatureController {
    private final AccountSignatureService accountSignatureService;

    public AccountSignatureController(AccountSignatureService accountSignatureService) {
        this.accountSignatureService = accountSignatureService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findAll() {
        List<AccountSignature> accounts = this.accountSignatureService.findAll();

        if (accounts.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(accounts);
    }

    @RequestMapping(value = "/local/{codeLocalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByCodeLocalAccount(
            @PathVariable("codeLocalAccount") String codeLocalAccount) {
        List<AccountSignature> accountSignatures = this.accountSignatureService
                .findByCodeLocalAccount(codeLocalAccount);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "/international/{codeInternationalAccount}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByCodeInternationalAccount(@PathVariable("codeInternationalAccount") String codeInternationalAccount) {
        List<AccountSignature> accountSignatures = this.accountSignatureService.findByCodeInternationalAccount(codeInternationalAccount);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "/{identification}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByIdentification(@PathVariable("identification") String identification) {
        List<AccountSignature> accountSignatures = this.accountSignatureService.findByIdentification(identification);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "/role/{account}/{identification}/{role-code}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByRole(@PathVariable("account") String account,
                                                             @PathVariable("identification") String identification,
                                                             @PathVariable("role-code") String role) {
        List<AccountSignature> accountSignatures = this.accountSignatureService.findByRole(identification, role);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }

    @RequestMapping(value = "/status/{account}/{identification}/{status-code}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountSignature>> findByStatus( @PathVariable("account") String account,
                                                                @PathVariable("identification") String identification,
                                                                @PathVariable("status-code") String status) {
        List<AccountSignature> accountSignatures = this.accountSignatureService.findByStatus(identification, status);
        if (accountSignatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(accountSignatures);
        }
    }



    @RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> createAccountSignature(
			@RequestBody AccountSignature accountSignature) {
		try {
            this.accountSignatureService.register(accountSignature);
			return ResponseEntity.ok("Account Signature succesfully added");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

    @RequestMapping(value = "/local/{codeLocalAccount}/{identification}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccountSignature(
        @PathVariable("codeLocalAccount") String codeLocalAccount, @PathVariable("identification") String identification) {
		try {
            this.accountSignatureService.delete(codeLocalAccount, identification);
			return ResponseEntity.ok("Account Signature succesfully deleted");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

}

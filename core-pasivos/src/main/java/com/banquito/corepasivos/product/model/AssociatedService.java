package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "associated_service")
@NoArgsConstructor
public class AssociatedService implements Serializable {

    @Id
    @Column(name = "code_associated_service", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "allow_payment", length = 1, nullable = false)
    private String allowPayment;

    @Column(name = "payment_method", length = 3)
    private String paymentMethod;

    @Column(name = "charge_vat", length = 1, nullable = false)
    private String chargeVat;

    @Column(name = "fee", scale = 17, precision = 2, nullable = false)
    private BigDecimal fee;

    public AssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }

}

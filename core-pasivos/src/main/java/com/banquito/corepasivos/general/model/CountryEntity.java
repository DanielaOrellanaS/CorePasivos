package com.banquito.corepasivos.general.model;

import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country_entity")
public class CountryEntity {
    @Id
    @Include
    @Column(name = "code_country", length = 2, nullable = false)
    private String codeCountry;

    @Column(name = "code_phone", length = 4, nullable = false)
    private String codePhone;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    public CountryEntity(String codeCountry) {
        this.codeCountry = codeCountry;
    }

}

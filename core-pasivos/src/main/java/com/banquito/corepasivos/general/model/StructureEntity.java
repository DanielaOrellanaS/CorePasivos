package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "structure_entity")
public class StructureEntity {

    @EmbeddedId
    @Include
    private StructureEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CODE_COUNTRY", nullable = false, insertable = false, updatable = false)
    private CountryEntity countryEntity;

    public StructureEntity(StructureEntityPK pk) {
        this.pk = pk;
    }
}

package com.banquito.corepasivos.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Table(name = "RELATIONSHIP_CLIENT")
public class RelationshipClient {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_RELATIONSHIP", nullable = false )
    public Integer codeRelationship;
    
    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT", referencedColumnName = "CODE_CLIENT", nullable = false)
    public Client codeClient;

    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT_RELATIONSHIP", referencedColumnName = "CODE_CLIENT", nullable = false)
    public Client codeClientRelationship;

    @Column(name = "RELATIONSHIP_TYPE", length = 32, nullable = false)
    public String relationshipType;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date endDate;

    public RelationshipClient(Integer codeRelationship) {
        this.codeRelationship = codeRelationship;
    }
    
}

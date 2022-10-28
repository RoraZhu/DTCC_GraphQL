package com.bezkoder.springgraphql.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Family {
    @Id
    @Column(name = "FAMILY_ID")
    private Long familyId;

    @Column(name = "FAMILY_NAME")
    private String familyName;

    @Column(name = "FAMILY_DESCRIPTION")
    private String familyDescription;

    @Override
    public String toString() {
        return "Family{" +
                "familyId=" + familyId +
                ", familyName='" + familyName + '\'' +
                ", familyDescription='" + familyDescription + '\'' +
                '}';
    }

}
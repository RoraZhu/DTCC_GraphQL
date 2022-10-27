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
    private Long family_id;

    @Column(name = "FAMILY_NAME")
    private String family_name;

    @Column(name = "FAMILY_DESCRIPTION")
    private String family_description;

    @Override
    public String toString() {
        return "Family{" +
                "familyId=" + family_id +
                ", familyName='" + family_name + '\'' +
                ", familyDescription='" + family_description + '\'' +
                '}';
    }
}
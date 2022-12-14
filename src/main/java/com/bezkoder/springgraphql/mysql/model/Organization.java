package com.bezkoder.springgraphql.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "ORG_LONG_NAME")
    private String orgLongName;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "ORG_TYPE")
    private String orgType;

    @Column(name = "ESG_REGION_CODE")
    private String esgRegionCode;

    @Column(name = "PRIVATE_FLAG")
    private Character privateFlag;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BIC_LID_PRIORITY_ID")
    private Long bicLidPriorityId;

    @Column(name = "MARKET_ID")
    private Long marketId;

    @ManyToOne
    @JoinColumn(name = "FAMILY_ID", nullable = false, updatable = false)
    private Family family;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="ORG_ID")
    private List<OrganizationXref> organizationXref;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "organizations"
    )
    private Set<Location> locations = new HashSet<>();

}

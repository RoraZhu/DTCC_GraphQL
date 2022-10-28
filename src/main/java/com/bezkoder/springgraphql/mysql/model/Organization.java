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

@Entity
@Table(name = "ORGANIZATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @Column(name = "ORG_ID")
    private Long org_id;

    @Column(name = "ORG_NAME")
    private String org_name;

    @Column(name = "ORG_LONG_NAME")
    private String org_long_name;

    @Column(name = "START_DATE")
    private String start_date;

    @Column(name = "END_DATE")
    private String end_date;

    @Column(name = "ORG_TYPE")
    private String org_type;

    @Column(name = "ESG_REGION_CODE")
    private String esg_region_code;

    @Column(name = "PRIVATE_FLAG")
    private Character private_flag;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BIC_LID_PRIORITY_ID")
    private Long bic_lid_priority_id;

    @Column(name = "MARKET_ID")
    private Long market_id;

    @ManyToOne
    @JoinColumn(name = "FAMILY_ID", nullable = false, updatable = false)
    private Family family;

}

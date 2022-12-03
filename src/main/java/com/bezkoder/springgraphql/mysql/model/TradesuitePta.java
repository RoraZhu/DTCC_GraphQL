package com.bezkoder.springgraphql.mysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tradesuite_pta")
@Getter
@Setter
public class TradesuitePta implements Serializable {

    @Column(name = "LOAD_DATE")
    private Long loadDate;

    @Id
    @Column(name = "DTCC_CONTROL_NUM")
    private Long dtccControlNum;

    @Column(name = "REC_TYPE")
    private String RecType;

    @Column(name = "BKRID")
    private String bkrid;

    @Column(name = "INSTID")
    private String instid;

    @Column(name = "AGTID")
    private String agtid;

    @Column(name = "SECUR_ID")
    private String securId;

    @Column(name = "BUYSELL")
    private String buysell;

    @Column(name = "PSET")
    private String pset;

    @Column(name = "PDQ_SECUR_TYPE")
    private String pdqSecurType;

    @Column(name = "ATP_CANCEL")
    private String atpCancel;

    @Column(name = "AGT_INT_ACC")
    private String agtIntAcc;

    @Column(name = "BKR_INT_ACC")
    private String bkrIntAcc;

    @Column(name = "SETT_OPTION")
    private String settOption;

    @Column(name = "AFF_PARTY")
    private String affParty;

    @Column(name = "ELIG_TYPE")
    private String eligType;

    @Column(name = "STATUS_TYPE")
    private String statusType;

    @Column(name = "TRADE_TYPE")
    private String tradeType;

    @Column(name = "CANCEL_TYPE")
    private String cancelType;

    @Column(name = "AFFIRM_TYPE")
    private String affirmType;

    @Column(name = "INST_NAME")
    private String instName;

    @Column(name = "INST_BILL")
    private String instBill;

    @Column(name = "AGT_NAME")
    private String agtName;

    @Column(name = "CNS_SETTING_ELIG")
    private String cnsSettingElig;

    @Column(name = "CL_AGTID")
    private String clAgtid;

    @Column(name = "BROKER_NAME")
    private String brokerName;

    @Column(name = "CL_BKRID")
    private String clBkrid;

    @Column(name = "SECURITY_DESC")
    private String securityDesc;

    @Column(name = "CONFIRM")
    private Long confirm;

    @Column(name = "CANCELS")
    private Long cancels;

    @Column(name = "NOT_AFF")
    private Long notAff;

    @Column(name = "AFF_ON_T")
    private Long affOnT;

    @Column(name = "AFF_ON_T1AM")
    private Long affOnT1am;

    @Column(name = "AFF_ON_T1PM")
    private Long affOnT1pm;

    @Column(name = "LATE_AFFIRM")
    private Long lateAffirm;

    @Column(name = "PDQ_ELIG")
    private Long pdqElig;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PERIOD")
    private String period;

    @Column(name = "TRADE_DATE")
    private Date tradeDate;

    @Column(name = "SETT_DATE")
    private Date settDate;

    @Column(name = "LATE_PDQ_ELIG")
    private Long latePdqElig;

    @Column(name = "INSITE")
    private String insite;

    @Column(name = "ALC_SOURCE")
    private String alcSource;

    @Column(name = "IPID_1")
    private String ipid1;

    @Column(name = "IP_NAME_1")
    private String ipName1;

    @Column(name = "IPID_2")
    private String ipid2;

    @Column(name = "IP_NAME_2")
    private String ipName2;

    @Column(name = "IPID_3")
    private String ipid3;

    @Column(name = "IP_NAME_3")
    private String ipName3;

    @Column(name = "AGT_CATEG")
    private String agtCateg;

    @Column(name = "AGT_FEE")
    private String agtFee;

    @Column(name = "AGT_DEL_FEE")
    private String agtDelFee;

    @Column(name = "AGT_DISC")
    private String agtDisc;

    @Column(name = "BKR_CATEG")
    private String bkrCateg;

    @Column(name = "BKR_FEE")
    private String bkrFee;

    @Column(name = "INSITE_FEE")
    private String insiteFee;

    @Column(name = "NOTIFICATION_FEE")
    private String notificationFee;

    @Column(name = "BKR_DEL_FEE")
    private String bkrDelFee;

    @Column(name = "BKR_DISC")
    private String bkrDisc;

    @Column(name = "LOAD_ID")
    private Long loadId;

    @Column(name = "LOAD_ROWNUM")
    private Long loadRownum;

    @Column(name = "TRD_TRANSM_DT")
    private Timestamp trdTransmDt;

    @Column(name = "TRD_ACTV_DT")
    private Timestamp trdActvDt;

    @Column(name = "TRD_MATCH_DT")
    private Timestamp trdMatchDt;

    @Column(name = "TRD_CNCLCORR_DT")
    private Timestamp trdCnclcorrDt;

    @Column(name = "TRD_DISAFFIRM_DT")
    private Timestamp trdDisaffirmDt;

    @Column(name = "TRD_AFFIRM_DT")
    private Timestamp trdAffirmDt;

    @Column(name = "CTM_BLOCK_REF_ID")
    private String ctmBlockRefId;

    @Column(name = "CTM_DETAIL_REF_ID")
    private String ctmDetailRefId;

    @Column(name = "CTM_BKR_CONF_ID")
    private String ctmBkrConfId;

    @Column(name = "CTM_BRKR_REF_ID")
    private String ctmBrkrRefId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ctm_detail_ref_id", referencedColumnName = "trade_detail_id", insertable = false, updatable = false),
            @JoinColumn(name = "ctm_block_ref_id", referencedColumnName = "trade_side_id", insertable = false, updatable = false),
    })
    @JsonIgnore
    private LiveTradeDetails liveTradeDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instid", referencedColumnName = "org_id", insertable = false, updatable = false)
    @JsonIgnore
    private Organization organization;
}

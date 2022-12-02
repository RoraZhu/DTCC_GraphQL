package com.bezkoder.springgraphql.mysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LIVE_TRADE_DETAILS")
@Getter
@Setter
public class LiveTradeDetails {
    @Id
    @Column(name="TRADE_DETAIL_ID")
    private Long tradeDetailId;
//    TRADE_DETAIL_ID : Int!
    @Column(name="TD_BAG_OBJECT_TYPE")
    private Long tdBagObjectType;
//    TdBagObjectType : Int
    @Column(name="ACCRUED_INTEREST_AMOUNT")
    private Float accruedInterestAmount;
//    accrued_interest_amount : Float
    @Column(name="ACCOUNT_ID")
    private Long accountId;
//    account_id: Int
    @Column(name="EXCHANGE_RATE")
    private Float exchangeRate;
//    exchange_rate: Float
    @Column(name = "SETTLEMENT_AMOUNT")
    private Float settlementAmount;
//    settlement_amount: Float
    @Column(name = "QUANTITY_ALLOCATED")
    private Long quantityAllocated;
//    quantity_allocated : Int
    @Column(name = "QUANTITY_ALLOCATED")
    private Long QuantityAllocated;
//    version_of_trade_component : Int
    @Column(name = "TRADE_AMOUNT")
    private Float  tradeAmount;
//    TRADE_AMOUNT: Float
    @Column(name = "NET_CASH_AMOUNT")
    private Float netCashAmount;
//    NET_CASH_AMOUNT: Float
    @Column(name = "CLIENT_ALLOCATION_REFERENCE")
    private String clientAllocationReference;
//    CLIENT_ALLOCATION_REFERENCE:String
    @Column(name = "ALERT_COUNTRY_CODE")
    private Long alertCountryCode;
//    ALERT_COUNTRY_CODE : Int
    @Column(name = "ALERT_METHOD_TYPE ")
    private Long alertMethodType;
//    ALERT_METHOD_TYPE : Int
    @Column(name = "ALERT_SECURITY_TYPE")
    private Long alertSecurityType;
//    ALERT_SECURITY_TYPE : Int
    @Column(name = "ALERT_SETTLEMENT_MODEL_NAME")
    private String alertSettlementModelName;
//    ALERT_SETTLEMENT_MODEL_NAME :String
    @Id
    @Column(name = "TRADE_SIDE_ID")
    private Long tradeSideId;
//    TRADE_SIDE_ID : Int
    @Column(name = "ADDITIONAL_TEXT_STRING")
    private String additionalTextString;
//    ADDITIONAL_TEXT_STRING:String
    @Column(name = "PARTY_FUND_NAME_SA")
    private String partyFundNameSa;
//    PARTY_FUND_NAME_SA :String
    @Column(name = "ORIGINAL_FACE_AMOUNT")
    private Float originalFaceAmount;
//    ORIGINAL_FACE_AMOUNT : Float
    @Column(name = "DIRECTED_COMMISSIONS_A")
    private Float directedCommissionsA;
//    DIRECTED_COMMISSIONS_A : Float
    @Column(name = "COUNTER_PARTY_DETAIL_ID")
    private Long counterPartyDetailId;
//    COUNTER_PARTY_DETAIL_ID : Int
    @Column(name = "MATCH_STATUS")
    private Long matchStatus;
//    MATCH_STATUS : Int
    @Column(name = "ERROR_STATUS")
    private Long errorStatus;
//    ERROR_STATUS : Int
    @Column(name = "TD_HIGHEST_ERROR_SEVERITY_DTM")
    private String tdHighestErrorSeverityDtm;
//    TD_HIGHEST_ERROR_SEVERITY_DTM :String
    @Column(name = " MATCH_STATUS_DTM")
    private String matchStatusDtm;
//    MATCH_STATUS_DTM :String
    @Column(name = "ERROR_STATUS_DTM")
    private String errorStatusDtm;
//    ERROR_STATUS_DTM :String
    @Column(name = "CANCEL_TEXT_STRING")
    private String cancelTextString;
//    CANCEL_TEXT_STRING :String
    @Column(name = "TRANSPORT_MESSAGE_ID")
    private String transportMessageId;
//    TRANSPORT_MESSAGE_ID :String
    @Column(name = "USER_ID")
    private Long userId;
//    USER_ID : Int
    @Column(name = "TE_VISIBLE_ONLY")
    private Boolean teVisibleOnly;
//    TE_VISIBLE_ONLY :Boolean
    @Column(name = "REJECT_FLAG")
    private Boolean rejectFlag;
//    reject_flag :boolean
    @Column(name = "ISITC_REJECT_REASON_CODE")
    private Long isitcRejectReasonCode;
//    ISITC_REJECT_REASON_CODE : Int
    @Column(name = "REJECT_COMPONENT_TEXT_STRING")
    private String rejectComponentTextString;
//    REJECT_COMPONENT_TEXT_STRING :String
    @Column(name = " REJECT_COMPONENT_DTM")
    private String rejectComponentDtm;
//    REJECT_COMPONENT_DTM :String
    @Column(name = "LOGIN_ID")
    private String loginId;
//    LOGIN_ID :STRING
    @Column(name = "ORIGINATOR_OF_MESSAGE_ID")
    private Long originatorOfMessageId;
//    ORIGINATOR_OF_MESSAGE_ID : Int
    @Column(name = "COUNTER_PARTY_ORG_ID")
    private Long counterPartyOrgId;
//    COUNTER_PARTY_ORG_ID : Int
    @Column(name = "FIRST_MATCH_STATUS_NMAT")
    private String firstMatchStatusNmat;
//    FIRST_MATCH_STATUS_NMAT :String
    @Column(name = "FIRST_MATCH_STATUS_MISM")
    private String firstMatchStatusMism;
//    FIRST_MATCH_STATUS_MISM :String
    @Column(name = "PACKED_COMMISSIONS")
    private Float packedCommissions;
//    PACKED_COMMISSIONS : Float
    @Column(name = "ASYNCH_ERROR_EXISTS")
    private Boolean asynchErrorExists;
//    ASYNCH_ERROR_EXISTS :Boolean
    @Column(name = "REPORTED_PRICE")
    private Float reportedPrice;
//    REPORTED_PRICE : Float
    @Column(name = "MARKUP_MARKDOWN")
    private Float markupMarkdown;
//    MARKUP_MARKDOWN : Float
    @Column(name = "ASSET_BACKED")
    private Boolean assetBacked;
//    ASSET_BACKED :Boolean
    @Column(name = "MARKET_MAKER")
    private String  marketMaker;
//    MARKET_MAKER :String
    @Column(name = "CURRENT_FACE_VALUE")
    private Float currentFaceValue;
//    CURRENT_FACE_VALUE : Float
    @Column(name = "CLEARING_BROKER_ORG_ID")
    private Long clearingBrokerOrgId;
//    CLEARING_BROKER_ORG_ID : Int
    @Column(name = "CLEARING_BROKER")
    private String clearingBroker;
//    CLEARING_BROKER :String
    @Column(name = "TD_FORCEMATCHFLAG")
    private Long tdForcematchflag;
//    TD_FORCEMATCHFLAG : Int
    @Column(name = "DML_ACTION CHAR")
    private String dmlActionl;
//    DML_ACTION CHAR
    @Column(name = "DML_TIMESTAMP")
    private String dmlTimestamp;
//    DML_TIMESTAMP :String
    @Column(name = "DML_SCN")
    private Long dmlScn;
//    DML_SCN : Int
    @Column(name = "WORKFLOW_MODIFIERS")
    private Long workflowModifiers;
//    WORKFLOW_MODIFIERS : Int
    @Column(name = "ACCESS_CODE_LE_ID")
    private Long accessCodeLeId;
//    ACCESS_CODE_LE_ID : Int
    @Column(name = "LARGE_TRADE_ID")
    private Long largeTradeId;
//    LARGE_TRADE_ID : Int

}


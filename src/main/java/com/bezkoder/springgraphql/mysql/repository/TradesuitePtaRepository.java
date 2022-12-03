package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.LiveTradeDetails;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.model.TradesuitePta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradesuitePtaRepository extends JpaRepository<TradesuitePta, Long> {

//    List<Organization> findByFamilyFamilyId(Long familyId);
//    Organization findOrganizationByOrgId(Long orgId);
//
//    Organization findByOrganizationXrefOrgXrefTypeAndOrganizationXrefOrgXrefValue(
//            String xrefType, String xrefValue);
//
//    List<Organization> findByLocationsPoliticalSubdivision(String subdivision);
    TradesuitePta findTradesuitePtaByDtccControlNum(Long dtccControlNum);
    List<TradesuitePta> findByLiveTradeDetailsIn(List<LiveTradeDetails> liveTradeDetailses);
    List<TradesuitePta> findByOrganizationIn(List<Organization> organizations);

}

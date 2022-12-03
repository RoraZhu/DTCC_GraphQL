package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.LiveTradeDetails;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.model.TradesuitePta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveTradeDetailsRepository extends JpaRepository<LiveTradeDetails, Long> {

//    List<Organization> findByFamilyFamilyId(Long familyId);
//    Organization findOrganizationByOrgId(Long orgId);
//
//    Organization findByOrganizationXrefOrgXrefTypeAndOrganizationXrefOrgXrefValue(
//            String xrefType, String xrefValue);
//
//    List<Organization> findByLocationsPoliticalSubdivision(String subdivision);
   List<LiveTradeDetails> findLiveTradeDetailsByTradeDetailId(Long tradeDetailId);
   LiveTradeDetails findLiveTradeDetailsByTradeDetailIdAndTradeSideId(Long tradeDetailId, Long tradeSideId);
   List<LiveTradeDetails> findByOrganizationIn(List<Organization> organizations);
}

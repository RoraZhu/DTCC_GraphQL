package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.Family;
import com.bezkoder.springgraphql.mysql.model.LiveTradeDetails;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.model.TradesuitePta;
import com.bezkoder.springgraphql.mysql.repository.FamilyRepository;
import com.bezkoder.springgraphql.mysql.repository.LiveTradeDetailsRepository;
import com.bezkoder.springgraphql.mysql.repository.OrganizationRepository;
import com.bezkoder.springgraphql.mysql.repository.TradesuitePtaRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TradeSuitePtaResolver implements GraphQLResolver<TradesuitePta> {
    @Autowired
    private LiveTradeDetailsRepository liveTradeDetailsRepository;
    private TradesuitePtaRepository tradesuitePtaRepository;



    public TradeSuitePtaResolver(TradesuitePtaRepository tradesuitePtaRepository,
                                 LiveTradeDetailsRepository liveTradeDetailsRepository) {
        this.tradesuitePtaRepository = tradesuitePtaRepository;
        this.liveTradeDetailsRepository = liveTradeDetailsRepository;
    }

    public List<LiveTradeDetails> getLiveTradeDetailses(TradesuitePta tradesuitePta){
        System.out.println(Long.valueOf(tradesuitePta.getCtmDetailRefId()));
        List<LiveTradeDetails> res = liveTradeDetailsRepository.findLiveTradeDetailsByTradeDetailId(
                Long.valueOf(tradesuitePta.getCtmDetailRefId())
        );

        return res;
    }

    public LiveTradeDetails getLiveTradeDetails(TradesuitePta tradesuitePta){
        System.out.println(Long.valueOf(tradesuitePta.getCtmDetailRefId()));

        return liveTradeDetailsRepository.findLiveTradeDetailsByTradeDetailIdAndTradeSideId(
                Long.valueOf(tradesuitePta.getCtmDetailRefId()), Long.valueOf(tradesuitePta.getCtmBlockRefId())
        );
    }



//    public Family getFamilyId(long orgId){
//        Organization organization = organizationRepository.findById(orgId).orElseThrow(null);
//        return familyRepository.findById(organization.getFamily().getFamilyId()).orElseThrow(null);
//    }
//
//    public Family getFamilyId(Organization organization) {
//        return familyRepository.findById(organization.getFamily().getFamilyId()).orElseThrow(null);
//    }
}
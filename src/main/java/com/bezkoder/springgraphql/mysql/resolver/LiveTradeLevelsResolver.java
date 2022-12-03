package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.LiveTradeLevels;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.model.SecurityTypeLp;
import com.bezkoder.springgraphql.mysql.repository.OrganizationRepository;
import com.bezkoder.springgraphql.mysql.repository.SecurityTypeLpRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiveTradeLevelsResolver implements GraphQLResolver<LiveTradeLevels> {
    @Autowired
    private OrganizationRepository organizationRepository;
    private SecurityTypeLpRepository securityTypeLpRepository;

    public LiveTradeLevelsResolver(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public Organization getCounterPartyOrgId(LiveTradeLevels liveTradeLevels){
        return organizationRepository.findById(liveTradeLevels.getCounterParty().getOrgId()).orElseThrow(null);
    }

    public Organization getInstructingPartyOrgId(LiveTradeLevels liveTradeLevels){
        return organizationRepository.findById(liveTradeLevels.getInstructingParty().getOrgId()).orElseThrow(null);
    }

    public Organization getExecutingBrokerOrgId(LiveTradeLevels liveTradeLevels){
        return organizationRepository.findById(liveTradeLevels.getExecutingBroker().getOrgId()).orElseThrow(null);
    }

    public SecurityTypeLp getSecurityTypeLpCode(LiveTradeLevels liveTradeLevels){
        return securityTypeLpRepository.findByCode(liveTradeLevels.getSecurityTypeLp().getCode());
    }


}

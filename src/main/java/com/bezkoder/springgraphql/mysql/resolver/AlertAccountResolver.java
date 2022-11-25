package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.AlertAccount;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.repository.AlertAccountRepository;
import com.bezkoder.springgraphql.mysql.repository.OrganizationRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertAccountResolver implements GraphQLResolver<AlertAccount> {
    @Autowired
    private OrganizationRepository organizationRepository;

    public AlertAccountResolver(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganizationId(AlertAccount account){
        return organizationRepository.findById(account.getOrganization().getOrgId()).orElseThrow(null);
    }
}

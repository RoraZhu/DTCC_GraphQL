package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.Family;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.repository.FamilyRepository;
import com.bezkoder.springgraphql.mysql.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Tutorial;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class OrganizationResolver implements GraphQLResolver<Tutorial> {
    @Autowired
    private FamilyRepository familyRepository;
    private OrganizationRepository organizationRepository;

    public OrganizationResolver(FamilyRepository familyRepository,
                                OrganizationRepository organizationRepository) {
        this.familyRepository = familyRepository;
        this.organizationRepository = organizationRepository;
    }

    public Family getFamilyId(long orgId){
        Organization organization = organizationRepository.findById(orgId).orElseThrow(null);
        return familyRepository.findById(organization.getFamily().getFamilyId()).orElseThrow(null);
    }

    public Family getFamilyId(Organization organization) {
        return familyRepository.findById(organization.getFamily().getFamilyId()).orElseThrow(null);
    }
}
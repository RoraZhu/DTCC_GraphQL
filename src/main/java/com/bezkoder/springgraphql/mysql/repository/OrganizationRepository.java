package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.Location;
import com.bezkoder.springgraphql.mysql.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    List<Organization> findByFamilyFamilyId(Long familyId);
    Organization findOrganizationByOrgId(Long orgId);

    Organization findByOrganizationXrefOrgXrefTypeAndOrganizationXrefOrgXrefValue(
            String xrefType, String xrefValue);

    List<Organization> findByLocationsPoliticalSubdivision(String subdivision);
}
package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.Family;
import com.bezkoder.springgraphql.mysql.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    //@Query(value = "SELECT ORG_ID as \"org_id\", ORG_NAME as \"org_name\", ORG_LONG_NAME as \"org_long_name\", FAMILY_ID as \"family_id\", START_DATE as \"start_date\", END_DATE as \"end_date\", ORG_TYPE as \"org_type\", ESG_REGION_CODE as \"esg_region_code\", PRIVATE_FLAG as \"private_flag\", DESCRIPTION as \"description\", BIC_LID_PRIORITY_ID as \"bic_lid_priority_id\", MARKET_ID as \"market_id\" FROM ORGANIZATION WHERE ORG_ID = ?", nativeQuery = true)
    //Optional<Organization> findById(Long id);

    //@Query(value = "SELECT ORG_ID as \"org_id\", ORG_NAME as \"org_name\", ORG_LONG_NAME as \"org_long_name\", FAMILY_ID as \"family_id\", START_DATE as \"start_date\", END_DATE as \"end_date\", ORG_TYPE as \"org_type\", ESG_REGION_CODE as \"esg_region_code\", PRIVATE_FLAG as \"private_flag\", DESCRIPTION as \"description\", BIC_LID_PRIORITY_ID as \"bic_lid_priority_id\", MARKET_ID as \"market_id\" FROM ORGANIZATIONN", nativeQuery = true)
    //List<Organization> findAll();

    List<Organization> findByFamilyFamilyId(Long familyId);
    Organization findOrganizationByOrgId(Long orgId);

}

package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.AlertAccount;
import com.bezkoder.springgraphql.mysql.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertAccountRepository extends JpaRepository<AlertAccount, Long> {
    List<AlertAccount> findByOrganizationIn(List<Organization> organizations);

    List<AlertAccount> findByOrganizationOrgId(long id);
}

package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.LiveTradeLevels;
import com.bezkoder.springgraphql.mysql.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface LiveTradeLevelsRepository extends JpaRepository<LiveTradeLevels, Long> {
    List<LiveTradeLevels> findByInstructingPartyOrgIdAndSecurityTypeLpCode(
            Long orgId, String securityTypeCode);

    List<LiveTradeLevels> findBySecurityTypeLpCode(String code);

    List<LiveTradeLevels> findByInstructingPartyIn(List<Organization> organizations);

    List<LiveTradeLevels> findAllByTradeDateTimeLessThanEqualAndTradeDateTimeGreaterThanEqual(
            Timestamp endDate, Timestamp startDate);
}

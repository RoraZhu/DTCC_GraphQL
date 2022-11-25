package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.SecurityTypeLp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityTypeLpRepository extends JpaRepository<SecurityTypeLp, Long> {
    SecurityTypeLp findByCode(String code);
}

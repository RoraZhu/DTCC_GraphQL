package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.AlertAccount;
import com.bezkoder.springgraphql.mysql.model.Location;
import com.bezkoder.springgraphql.mysql.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
   List<Location> findLocationByCountry(String country);
}

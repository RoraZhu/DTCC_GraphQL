package com.bezkoder.springgraphql.mysql.repository;

import com.bezkoder.springgraphql.mysql.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

//    @Query(value = "SELECT FAMILY_ID as \"family_id\", FAMILY_NAME as \"family_name\", FAMILY_DESCRIPTION as \"family_description\" FROM FAMILY WHERE FAMILY_ID = ?", nativeQuery = true)
//    Optional<Family> findById(Long id);

    Family findByFamilyId(Long familyId);

//    @Query(value = "SELECT FAMILY_ID as \"family_id\", FAMILY_NAME as \"family_name\", FAMILY_DESCRIPTION as \"family_description\" FROM FAMILY", nativeQuery = true)
//    List<Family> findAll();
}
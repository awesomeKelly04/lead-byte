package com.byteworks.leadbyte.repository;

import com.byteworks.leadbyte.model.NinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinRepository extends JpaRepository<NinData, Long> {
    Boolean existsByNin(String nin);
}

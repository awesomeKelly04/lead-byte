package com.byteworks.leadbyte.repository;

import com.byteworks.leadbyte.model.NinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="nins")
public interface NinRepository extends JpaRepository<NinData, Long> {

    Optional<NinData> findByNin(String nin);
}

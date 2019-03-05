package com.customermgmt.repository;

import com.customermgmt.domain.CustomerProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerProfileRepository extends CrudRepository<CustomerProfile, Long> {
    List<CustomerProfile> findAll();
    Optional<CustomerProfile> findById(Long id);
}

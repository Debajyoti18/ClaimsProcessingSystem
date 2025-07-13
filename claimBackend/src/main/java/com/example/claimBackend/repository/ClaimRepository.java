package com.example.claimBackend.repository;

import java.util.Date;
import java.util.List;

import com.example.claimBackend.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByUserUserId(Long userId); // use this if you're filtering by foreign key user ID

    List<Claim> findByClaimStatusAndLastUpdatedBefore(String claimStatus, Date lastUpdated);

    List<Claim> findByUserId(Long userId);
}

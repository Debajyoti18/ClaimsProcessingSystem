package com.example.claimBackend.repository;

import com.example.claimBackend.entity.ClaimReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.Date;
import java.util.List;

@Repository
public interface ClaimReportRepository extends JpaRepository<ClaimReport, Long> {
    // Example method to fetch claim reports by status
    List<ClaimReport> findByClaimStatus(String claimStatus);

    // Example method to fetch claim reports by a date range
    List<ClaimReport> findByReportDateBetween(Date startDate, Date endDate);
}

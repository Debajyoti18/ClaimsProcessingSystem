package com.example.claimBackend.Service;

import com.example.claimBackend.dto.ClaimDTO;
import com.example.claimBackend.entity.Claim;
import com.example.claimBackend.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;


    @Transactional
    public ClaimDTO submitClaim(Claim claim) {
        claim.setClaimStatus("Submitted");
        claim.setClaimDate(new Date());
        return convertToDTO(claimRepository.save(claim));
    }

    @Transactional(readOnly = true)
    public Claim findClaimById(Long claimId) {
        Optional<Claim> claim = claimRepository.findById(claimId);
//            .orElseThrow(() -> new RuntimeException("Claim not found with id: " + claimId));
//        return convertToDTO(claim);
        return claim.get();
    }

    @Transactional
    public ClaimDTO updateClaim(Long claimId, ClaimDTO updatedClaim) {
        Claim claim = findClaimById(claimId);
        claim.setClaimAmount(updatedClaim.getClaimAmount());
        claim.setClaimType(updatedClaim.getClaimType());
        claim.setClaimStatus(updatedClaim.getClaimStatus());
        claim.setLastUpdated(new Date());
        return convertToDTO(claimRepository.save(claim));
    }

    @Transactional
    public void deleteClaim(Long claimId) {
        Claim claim = findClaimById(claimId);
        claimRepository.delete(claim);
    }

    @Transactional(readOnly = true)
    public List<ClaimDTO> findClaimsByUserId(Long userId) {
        List<Claim> claims = claimRepository.findByUserId(userId);
        return claims.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClaimDTO convertToDTO(Claim claim) {
        return new ClaimDTO(claim.getClaimId(), claim.getUser() != null ? claim.getUser().getUserId() : null,
                claim.getClaimDate(), claim.getClaimAmount(), claim.getClaimType(), claim.getClaimStatus(),
                claim.getLastUpdated());
    }



}
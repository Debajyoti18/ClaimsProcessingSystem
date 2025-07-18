package com.example.claimBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "claims")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column
    private Date claimDate;

    @Column
    private Double claimAmount;

    @Column
    private String emailId;

    @Column
    private String claimType;

    @Column
    private String claimStatus;

    @Column
    private Date lastUpdated;
}
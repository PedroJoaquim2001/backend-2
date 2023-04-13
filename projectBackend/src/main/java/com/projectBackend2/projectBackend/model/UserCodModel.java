package com.projectBackend2.projectBackend.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "USER_COD")
public class UserCodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private BigInteger adminCod;
    @Column(nullable = false)
    private BigInteger employeeCod;
}

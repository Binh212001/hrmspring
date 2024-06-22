package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefitId;
    private String benefitName;
    private String description;
    private String eligibility;
}

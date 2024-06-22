package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;
    private String firstName;
    private String lastName;
    private String contactInfo;
    private Date applicationDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "recruitmentId")
    private Recruitment recruitment;
}

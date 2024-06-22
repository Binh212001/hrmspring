package org.example.springhrm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitmentId;
    private String jobTitle;
    private String jobDescription;
    private String requirements;
    private String status;
    private Date applicationDeadline;
}
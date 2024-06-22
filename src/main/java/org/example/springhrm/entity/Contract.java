package org.example.springhrm.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    private String contractType;
    private Date startDate;
    private Date endDate;
    private String details;

    @OneToOne(mappedBy = "contract")
    private Employee employee;
}
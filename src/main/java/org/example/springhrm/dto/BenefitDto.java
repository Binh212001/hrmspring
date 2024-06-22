package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Benefit}
 */
@Value
public class BenefitDto implements Serializable {
    Long benefitId;
    String benefitName;
    String description;
    String eligibility;
}
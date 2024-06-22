package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Benefit}
 */
@Value
public class BenefitForm implements Serializable {
    Long benefitId;
    String benefitName;
    String description;
    String eligibility;
}
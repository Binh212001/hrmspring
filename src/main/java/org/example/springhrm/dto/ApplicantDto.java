package org.example.springhrm.dto;

import lombok.Value;
import org.example.springhrm.entity.Recruitment;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Applicant}
 */
@Value
public class ApplicantDto implements Serializable {
    Long applicantId;
    String firstName;
    String lastName;
    String contactInfo;
    Date applicationDate;
    String status;
    Recruitment recruitment;
}
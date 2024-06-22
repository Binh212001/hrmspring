package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Recruitment;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Applicant}
 */
@Value
public class ApplicantForm implements Serializable {
    Long applicantId;
    String firstName;
    String lastName;
    String contactInfo;
    Date applicationDate;
    String status;
    Recruitment recruitment;
}
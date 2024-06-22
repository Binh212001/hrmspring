package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Recruitment}
 */
@Value
public class RecruitmentForm implements Serializable {
    Long recruitmentId;
    String jobTitle;
    String jobDescription;
    String requirements;
    String status;
    Date applicationDeadline;
}
package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Recruitment}
 */
@Value
public class RecruitmentDto implements Serializable {
    Long recruitmentId;
    String jobTitle;
    String jobDescription;
    String requirements;
    String status;
    Date applicationDeadline;
}
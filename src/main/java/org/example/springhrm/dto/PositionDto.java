package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Position}
 */
@Value
public class PositionDto implements Serializable {
    Long positionId;
    String positionName;
    String salaryGrade;
    String description;
}
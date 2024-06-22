package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springhrm.entity.Position}
 */
@Value
public class PositionForm implements Serializable {
    Long positionId;
    String positionName;
    String salaryGrade;
    String description;
}
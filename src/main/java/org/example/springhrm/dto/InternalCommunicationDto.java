package org.example.springhrm.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.InternalCommunication}
 */
@Value
public class InternalCommunicationDto implements Serializable {
    Long communicationId;
    String title;
    String content;
    Date date;
    EmployeeDto sender;
    EmployeeDto receiver;
}
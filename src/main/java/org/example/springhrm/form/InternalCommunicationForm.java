package org.example.springhrm.form;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.InternalCommunication}
 */
@Value
public class InternalCommunicationForm implements Serializable {
    Long communicationId;
    String title;
    String content;
    Date date;
    EmployeeForm sender;
    EmployeeForm receiver;
}
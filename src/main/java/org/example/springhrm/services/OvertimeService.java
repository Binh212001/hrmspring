package org.example.springhrm.services;

import org.example.springhrm.form.OvertimeForm;
import org.example.springhrm.utils.Response;

import java.util.List;

public interface OvertimeService {
    Response save(OvertimeForm overtimeForm);
    Response edit(OvertimeForm form);
    Response approved(List<Long> ids);
}

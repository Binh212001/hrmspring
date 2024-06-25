package org.example.springhrm.services;

import org.example.springhrm.form.OvertimeForm;
import org.example.springhrm.utils.Response;

public interface OvertimeService {
    Response save(OvertimeForm overtimeForm);
    Response edit(OvertimeForm form);
}

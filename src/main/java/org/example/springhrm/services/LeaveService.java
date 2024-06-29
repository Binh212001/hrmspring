package org.example.springhrm.services;

import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.utils.Response;

public interface LeaveService {
    Response save(LeaveForm form);

    Response edit(LeaveForm form);
}

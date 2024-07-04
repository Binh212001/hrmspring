package org.example.springhrm.services;

import org.example.springhrm.form.LeaveForm;
import org.example.springhrm.utils.Response;

import java.util.List;

public interface LeaveService {
    Response save(LeaveForm form);

    Response edit(LeaveForm form);

    Response approved(List<Long> ids);
}

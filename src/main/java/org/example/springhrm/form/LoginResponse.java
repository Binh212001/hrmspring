package org.example.springhrm.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class LoginResponse {
    String token;
}

package org.example.springhrm.services;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = userRepository.findByEmail(username);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(employee.getEmail())
                .password(employee.getPassword())
                .roles("USER")
                .build();
    }
}

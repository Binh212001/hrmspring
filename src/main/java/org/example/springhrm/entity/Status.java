package org.example.springhrm.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    DRAFT, APPROVED , REJECTED
}

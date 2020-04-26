package com.spring.micro.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSize {
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL");

    @NonNull
    private String label;
}

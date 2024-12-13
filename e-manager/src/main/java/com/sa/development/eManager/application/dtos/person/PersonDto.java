package com.sa.development.eManager.application.dtos.person;

public record PersonDto(
        String id,
        String name,
        String phoneNumber,
        String email,
        Integer personType
) {}

package com.udeajobs.identity.account_service.dto;

public record ErrorResponse(
        int status,
        String message,
        String error
) {}

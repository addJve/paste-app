package com.addjve.pasteapp.dto;

import lombok.Data;

@Data
public class PasteLockerRequest {
    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;
}

package com.addjve.pasteapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteLockerResponse {
    private final String data;
    private final boolean isPublic;
}

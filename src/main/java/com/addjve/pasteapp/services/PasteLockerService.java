package com.addjve.pasteapp.services;

import com.addjve.pasteapp.dto.PasteLockerRequest;
import com.addjve.pasteapp.dto.PasteLockerResponse;
import com.addjve.pasteapp.dto.PasteLockerUrlResponse;

import java.util.List;

public interface PasteLockerService {
    PasteLockerResponse getByHash(String hash);
    List<PasteLockerResponse> getFirstPublicPasteLocker();
    PasteLockerUrlResponse addPasteLocker(PasteLockerRequest request);
}

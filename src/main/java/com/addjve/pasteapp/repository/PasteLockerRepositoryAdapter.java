package com.addjve.pasteapp.repository;

import com.addjve.pasteapp.model.PasteLocker;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PasteLockerRepositoryAdapter {
    PasteLocker findPasteLockerByHash(String hash);

    void save(PasteLocker pasteLocker);

    List<PasteLocker> findListOfPublicAndAlive(
            int amount,
            LocalDateTime timeFrom,
            LocalDateTime timeTo);
}

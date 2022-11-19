package com.addjve.pasteapp.repository;

import com.addjve.pasteapp.model.PasteLocker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PasteLockerPostgreRepository implements PasteLockerRepositoryAdapter {
    private final PasteLockerRepository repository;

    @Override
    public PasteLocker findPasteLockerByHash(String hash) {
        return repository.findPasteLockerByHash(hash);
    }

    @Override
    public void save(PasteLocker pasteLocker) {
        repository.save(pasteLocker);
    }

    @Override
    public List<PasteLocker> findListOfPublicAndAlive(int amount, LocalDateTime timeFrom, LocalDateTime timeTo) {
        return repository.findListOfPublicAndAlive(amount, timeFrom, timeTo);
    }
}

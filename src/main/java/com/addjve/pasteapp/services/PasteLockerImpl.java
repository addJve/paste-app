package com.addjve.pasteapp.services;

import com.addjve.pasteapp.dto.PasteLockerRequest;
import com.addjve.pasteapp.dto.PublicStatus;
import com.addjve.pasteapp.dto.PasteLockerResponse;
import com.addjve.pasteapp.dto.PasteLockerUrlResponse;
import com.addjve.pasteapp.configuration.MyConfig;
import com.addjve.pasteapp.model.PasteLocker;
import com.addjve.pasteapp.repository.PasteLockerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PasteLockerImpl implements PasteLockerService {
    private final MyConfig config;
    private final PasteLockerRepository repository;

    private final HashGenerator hashGenerator;

    public PasteLockerResponse getByHash(String hash) {
        PasteLocker pasteLocker = repository.findPasteLockerByHash(hash);
        return new PasteLockerResponse(pasteLocker.getData(), pasteLocker.isPublic());
    }

    public List<PasteLockerResponse> getFirstPublicPasteTemplate() {
        List<PasteLocker> list =
                repository.findListOfPublicAndAlive(
                        config.getListSizeToShow(),
                        LocalDateTime.now(),
                        LocalDateTime.now().plusSeconds(config.getTimeInSecondsToShow()));


        return list.stream().map(pasteLocker ->
                new PasteLockerResponse(pasteLocker.getData(), pasteLocker.isPublic()))
                .collect(Collectors.toList());
    }

    public PasteLockerUrlResponse create(PasteLockerRequest request) {

        String hash = hashGenerator.generateHash(16);

        PasteLocker pasteLocker = new PasteLocker();
        pasteLocker.setData(request.getData());
        pasteLocker.setHash(hash);
        pasteLocker.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteLocker.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.save(pasteLocker);

        return new PasteLockerUrlResponse(config.getHost() + "/" + pasteLocker.getHash());
    }

}

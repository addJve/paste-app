package com.addjve.pasteapp;

import com.addjve.pasteapp.configuration.MyConfig;
import com.addjve.pasteapp.dto.PasteLockerResponse;
import com.addjve.pasteapp.exception.NotFoundEntityException;
import com.addjve.pasteapp.model.PasteLocker;
import com.addjve.pasteapp.repository.PasteLockerRepositoryAdapter;
import com.addjve.pasteapp.services.HashGenerator;
import com.addjve.pasteapp.services.PasteLockerImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PastLockerServiceUnitTests {
    private final MyConfig config = mock(MyConfig.class);
    private final PasteLockerRepositoryAdapter repository = mock(PasteLockerRepositoryAdapter.class);
    private final HashGenerator hashGenerator = mock(HashGenerator.class);

    @Test
    public void shouldGetPasteLockerResponseWhenGetByHash() {
        // GIVEN
        PasteLockerImpl pasteLockerImpl = new PasteLockerImpl(config, repository, hashGenerator);
        String hash = "EEcCCAYuUcQk7IuzdaPzrg";
        PasteLocker pasteLocker = new PasteLocker("mypaste", hash, LocalDateTime.now(), true);
        PasteLockerResponse expected = new PasteLockerResponse(pasteLocker.getData(), pasteLocker.isPublic());
        given(repository.findPasteLockerByHash(hash)).willReturn(pasteLocker); // STAB

        // WHEN
        PasteLockerResponse actual = pasteLockerImpl.getByHash(hash);

        // THEN
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldThrowNotFoundExceptionWhenGetByHash() {
        // GIVEN
        PasteLockerImpl pasteLockerImpl = new PasteLockerImpl(config, repository, hashGenerator);
        String hash = "EEcCCAYuUcQk7IuzdaPzrg";
        PasteLocker pasteLocker = new PasteLocker("mypaste", hash, LocalDateTime.now(), true);
        NotFoundEntityException expected = new NotFoundEntityException("No such paste in DB");
        given(repository.findPasteLockerByHash(hash)).willThrow(expected); // STAB

        // WHEN
        PasteLockerResponse actual = pasteLockerImpl.getByHash(hash);

        // THEN
//        assertThat(() -> );
    }


}

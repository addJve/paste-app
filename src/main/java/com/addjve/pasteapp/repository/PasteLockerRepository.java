package com.addjve.pasteapp.repository;

import com.addjve.pasteapp.model.PasteLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PasteLockerRepository extends JpaRepository<PasteLocker, Long> {
    PasteLocker findPasteLockerByHash(String hash);

    @Query(value = "select * from pastes\n" +
    "where is_public = 'true' and lifetime between :timeFrom and :timeTo order by lifetime desc limit :amount",
            nativeQuery = true)
    List<PasteLocker> findListOfPublicAndAlive(
            @Param("amount") int amount,
            @Param("timeFrom") LocalDateTime timeFrom,
            @Param("timeTo") LocalDateTime timeTo);
}

package com.addjve.pasteapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pastes")
@Data
public class PasteLocker {
    @Id
    @SequenceGenerator(name = "paste_seq", sequenceName = "paste_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="paste_seq")
    private Long id;
    private String data;
    private String hash;
    private LocalDateTime lifetime;
    private boolean isPublic;
}

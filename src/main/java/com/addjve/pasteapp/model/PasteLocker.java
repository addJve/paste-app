package com.addjve.pasteapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pastes")
@Data
public class PasteLocker {
    @Id
    @GeneratedValue(generator="my_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_generator", sequenceName = "seq_generator", initialValue = 1)
    private Long id;
    private String data;
    private String hash;
    private LocalDateTime lifetime;
    private boolean isPublic;
}

package org.commonModule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "history")
@Data
public class HistoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;
    @Column(nullable = false)
    private String history;
    @Column
    private Long date;
}

package org.commonModule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.commonModule.constant.StorageAddress;

import java.io.Serializable;

@Entity
@Table(name = "storage")
@Data
public class StorageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private StorageAddress address;
}

package org.commonModule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category = new CategoryEntity();
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id", referencedColumnName = "id", nullable = false)
    private StorageEntity storage = new StorageEntity();
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private Long criticalQuantity;
}

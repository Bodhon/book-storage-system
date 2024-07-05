package com.github.bodhon.book_storage_system.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "copies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Copy {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "shelf_location", nullable = false)
    private String shelfLocation;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "copy")
    private Set<Loan> loans;
}

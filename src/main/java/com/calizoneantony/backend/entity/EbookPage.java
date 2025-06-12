package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ebook_page")
@Data
public class EbookPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ebook_page_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ebook_id")
    private Ebook ebook;

    @Column(name = "page_number")
    private Long pageNumber;

    @Column(name = "html_content", columnDefinition = "TEXT", nullable = false)
    private String htmlContent;
}

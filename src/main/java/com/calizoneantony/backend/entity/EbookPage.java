package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ebook_page")
@Getter
@Setter
public class EbookPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ebook_id")
    private Ebook ebook;

    @Column(name = "page_number")
    private Long pageNumber;

    @Column(name = "html_content", columnDefinition = "TEXT")
    private String htmlContent;
}

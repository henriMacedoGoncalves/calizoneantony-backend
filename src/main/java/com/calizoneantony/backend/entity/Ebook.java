package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ebook")
@Data
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ebook_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @CreationTimestamp
    @Column(name = "create_Date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "price", nullable = false)
    private Float price;

    @OneToMany(mappedBy = "ebook")
    private List<EbookPage> ebookPages;
}

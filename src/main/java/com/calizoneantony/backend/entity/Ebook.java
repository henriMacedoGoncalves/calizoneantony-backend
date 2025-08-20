package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ebook")
@Getter
@Setter
public class Ebook {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "folder_path")
    private String folderPath;

    @OneToMany(mappedBy = "ebook")
    private List<EbookPage> ebookPages;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}

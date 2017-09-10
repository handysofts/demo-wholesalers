package com.visma.demowholesalers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Vasif Mustafayev on 2017-08-02 18:46
 * vmustafayev@gmail.com
 */
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "products")
@Getter
@Setter
@ToString
public class Product implements Serializable {
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name_")
    private String name;

    private BigDecimal price;

    @JsonIgnore
    @Column(insertable = false)
    private int status;

    @JsonIgnore
    @Column(name = "upd_time")
    @LastModifiedDate
    private Date updTime;
}

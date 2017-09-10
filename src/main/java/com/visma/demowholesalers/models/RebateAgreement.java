package com.visma.demowholesalers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasif Mustafayev
 * vmustafayev@gmail.com
 */
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "rebate_agreements")
@Getter
@Setter
@ToString
public class RebateAgreement implements Serializable {
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name_")
    private String name;

    @Column(name = "desc_")
    private String desc;

    @OneToMany(mappedBy="rebateAgreement")
    private List<RebateAgreementDetails> details;

    @JsonIgnore
    @Column(insertable = false)
    private int status;

    @JsonIgnore
    @Column(name = "upd_time")
    @LastModifiedDate
    private Date updTime;
}

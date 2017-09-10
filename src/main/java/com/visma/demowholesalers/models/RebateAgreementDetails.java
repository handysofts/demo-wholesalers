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

/**
 * Created by Vasif Mustafayev
 * vmustafayev@gmail.com
 */
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "rebate_agreement_details")
@Getter
@Setter
@ToString (exclude = {"rebateAgreement"})
public class RebateAgreementDetails implements Serializable {
    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "key_")
    private String key;

    @Column(name = "value_")
    private String value;

    @ManyToOne
    @JoinColumn(name="rebate_agreement_id", nullable=false)
    private RebateAgreement rebateAgreement;

    @JsonIgnore
    @Column(insertable = false)
    private int status;

    @JsonIgnore
    @Column(name = "upd_time")
    @LastModifiedDate
    private Date updTime;
}

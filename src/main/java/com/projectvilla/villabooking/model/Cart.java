package com.projectvilla.villabooking.model;


import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                 property = "id",scope = Long.class )
public class Cart {
    @Id
    @Column(name = "cart_id")
    @SequenceGenerator(name = "seq", sequenceName = "cart_id_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "is_closed", nullable = false)
    private Boolean isClosed =false;

    @Column(name = "created_on", nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIdentityReference(alwaysAsId =false)
    private Set<LineItem> lineItem;

    private Double total = 0d;

    public Cart() {
    }

    public Cart(Long id, Boolean isClosed, Date createdOn, Set<LineItem> lineItem, Double total) {
        this.id = id;
        this.isClosed = isClosed;
        this.createdOn = createdOn;
        this.lineItem = lineItem;
        this.total = total;
    }

    /*
     * @ManyToMany(fetch = FetchType.LAZY)
     * 
     * @JoinTable(name = "line_item", joinColumns = @JoinColumn(name = "cart_id"),
     * inverseJoinColumns = @JoinColumn(name = "prod_id")) private Set<Product>
     * products;
     */

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Boolean return the isClosed
     */
    public Boolean isIsClosed() {
        return isClosed;
    }

    /**
     * @param isClosed the isClosed to set
     */
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    /**
     * @return LocalDateTime return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return Collection<LineItem> return the lineItem
     */
    public Set<LineItem> getLineItem() {
        return lineItem;
    }

    /**
     * @param lineItem the lineItem to set
     */
    public void setLineItem(Set<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    /**
     * @return Double return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

}

package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name="t_purchase_order_lines")
public class OrderLine extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name="item_fk")
    public Item item;

    public Integer quantity;

    @ManyToOne
    @JoinColumn(name="purchase_order_fk")
    public PurchaseOrder purchaseOrder;

    @Column(name="created_date")
    public Instant cretedDate = Instant.now();
}

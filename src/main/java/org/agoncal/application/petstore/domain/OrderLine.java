package org.agoncal.application.petstore.domain;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
@Data
@NoArgsConstructor
public class OrderLine {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @OneToOne
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item;

    // ======================================
    // =            Constructors            =
    // ======================================
    
    public OrderLine(Integer quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    // ======================================
    // =              Public Methods        =
    // ======================================

    public Float getSubTotal() {
        return item.getUnitCost() * quantity;
    }
}


package com.dmanso.apimTestingUtils.model;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    Long itemId;
    
    @Column
    String itemName;
    
    @Column
    int itemVendorId;
    
    @Column
    int itemModelYear;
    
    @Column
    Number itemListPrice;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    
    @UpdateTimestamp
    Timestamp lastModified;

    
}

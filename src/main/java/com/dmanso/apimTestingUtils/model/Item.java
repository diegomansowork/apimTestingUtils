
package com.dmanso.apimTestingUtils.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    Long id;
    
    @Column
    String name;
    
    @Column
    int vendorId;
    
    @Column
    int modelYear;
    
    @Column
    Number listPrice;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    
    @UpdateTimestamp
    Timestamp lastModified;

    
}

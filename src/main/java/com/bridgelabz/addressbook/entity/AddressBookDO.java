package com.bridgelabz.addressbook.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "address")
@Data
public class AddressBookDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "address_id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "address")
  private String address;
  @Column(name = "city")
  private String city;
  @Column(name = "state")
  private String state;
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "zip")
  private int zip;
  @CreationTimestamp
  @Column(name = "created_on")
  private LocalDateTime createdOn;
  @UpdateTimestamp
  @Column(name = "updated_on")
  private LocalDateTime updatedOn;

}

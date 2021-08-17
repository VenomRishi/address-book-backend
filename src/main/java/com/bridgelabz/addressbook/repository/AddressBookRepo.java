package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBookDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<AddressBookDO, Integer> {

}

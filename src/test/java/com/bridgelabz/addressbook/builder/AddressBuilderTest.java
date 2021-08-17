package com.bridgelabz.addressbook.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddressBuilderTest {

  @InjectMocks
  private AddressBuilder addressBuilder;

  @Test
  public void buildDOTest() {
    AddressBookDTO addressBookDTO = new AddressBookDTO();
    addressBookDTO.setName("something");
    addressBookDTO.setState("MH");
    AddressBookDO addressBookDO = addressBuilder.buildDO(addressBookDTO);
    assertEquals("something", addressBookDO.getName());
    assertEquals("MH", addressBookDO.getState());
  }
}

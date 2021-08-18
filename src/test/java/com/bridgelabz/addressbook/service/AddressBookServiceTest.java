package com.bridgelabz.addressbook.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookDO;
import com.bridgelabz.addressbook.exception.CustomException;
import com.bridgelabz.addressbook.repository.AddressBookRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {

  @InjectMocks
  private AddressBookService addressBookService;
  @Mock
  private AddressBookRepo addressBookRepo;
  @Mock
  private ModelMapper modelMapper;
  @Mock
  private AddressBuilder addressBuilder;

  @Test
  public void getAddressesTest() {
    List<AddressBookDO> addressBookDOList = new ArrayList<>();
    AddressBookDO addressBookDO = new AddressBookDO();
    addressBookDO.setId(1);
    addressBookDO.setName("Sanobar");
    AddressBookDO addressBookDO2 = new AddressBookDO();
    addressBookDO2.setId(2);
    addressBookDO2.setName("Divya");
    addressBookDOList.add(addressBookDO);
    addressBookDOList.add(addressBookDO2);

    AddressBookDTO addressBookDTO = new AddressBookDTO();
    addressBookDTO.setId(1);
    addressBookDTO.setName("Sanobar");
    AddressBookDTO addressBookDTO2 = new AddressBookDTO();
    addressBookDTO2.setId(2);
    addressBookDTO2.setName("Divya");

    when(addressBookRepo.findAll()).thenReturn(addressBookDOList);
    when(modelMapper.map(addressBookDOList.get(0), AddressBookDTO.class)).thenReturn(
        addressBookDTO);
    when(modelMapper.map(addressBookDOList.get(1), AddressBookDTO.class)).thenReturn(
        addressBookDTO2);

    List<AddressBookDTO> actualAddressesList = addressBookService.getAddresses();

    assertNotNull(actualAddressesList);
    for (int i = 0; i < addressBookDOList.size(); i++) {
      assertEquals(i + 1, actualAddressesList.get(i).getId());
    }
    assertEquals("Sanobar", actualAddressesList.get(0).getName());
    assertEquals("Divya", actualAddressesList.get(1).getName());
  }

  @Test
  public void addAddressBookTest() {
    AddressBookDTO addressBookDTO = new AddressBookDTO();
    addressBookDTO.setName("Sanobar");
    addressBookDTO.setAddress("MH");

    AddressBookDO addressBookDO = new AddressBookDO();
    addressBookDO.setName("Sanobar");
    addressBookDO.setAddress("MH");
    addressBookDO.setId(1);

    when(addressBuilder.buildDO(addressBookDTO)).thenReturn(addressBookDO);
    when(addressBookRepo.save(addressBookDO)).thenReturn(addressBookDO);

    AddressBookDTO actualAddressBookDTO = addressBookService.addAddressBook(addressBookDTO);
    assertNotNull(actualAddressBookDTO);
    assertEquals(1, actualAddressBookDTO.getId());
  }

  @Test(expected = CustomException.class)
  public void updateAddressBook_whenFindById_shouldThrowExceptionTest() {
    int id = 1;
    AddressBookDTO addressBookDTO = new AddressBookDTO();
    addressBookDTO.setName("Sanobar");
    addressBookDTO.setAddress("MH");

    when(addressBookRepo.findById(id)).thenReturn(Optional.empty());
    addressBookService.updateAddressBook(id, addressBookDTO);
  }

  @Test
  public void updateAddressBookTest() {
    int id = 1;
    AddressBookDTO addressBookDTO = new AddressBookDTO();
    addressBookDTO.setName("Sanobar");
    addressBookDTO.setAddress("MH");

    AddressBookDO addressBookDO = new AddressBookDO();
    addressBookDO.setId(1);
    addressBookDO.setName("Test");
    addressBookDO.setAddress("MH");

    when(addressBookRepo.findById(id)).thenReturn(Optional.of(addressBookDO));
    when(addressBookRepo.save(addressBookDO)).thenReturn(addressBookDO);
    AddressBookDTO actualAddressBookDTO = addressBookService.updateAddressBook(id, addressBookDTO);
    ArgumentCaptor<AddressBookDO> addressBookDOArgumentCaptor = ArgumentCaptor.forClass(
        AddressBookDO.class);
    verify(addressBookRepo, times(1)).save(addressBookDOArgumentCaptor.capture());
    assertNotNull(actualAddressBookDTO);
    assertEquals("Sanobar", addressBookDOArgumentCaptor.getValue().getName());
    assertEquals("MH", addressBookDOArgumentCaptor.getValue().getAddress());

  }
}

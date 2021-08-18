package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.constant.ExceptionConstant;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookDO;
import com.bridgelabz.addressbook.exception.CustomException;
import com.bridgelabz.addressbook.repository.AddressBookRepo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

  @Autowired
  private AddressBookRepo addressBookRepo;
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private AddressBuilder addressBuilder;

  @Override
  public List<AddressBookDTO> getAddresses() {
    return addressBookRepo.findAll().stream()
        .map(addressBookDO -> modelMapper.map(addressBookDO, AddressBookDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public AddressBookDTO addAddressBook(AddressBookDTO addressBookDTO) {
    AddressBookDO addressBookDO = addressBuilder.buildDO(addressBookDTO);
    addressBookDO = addressBookRepo.save(addressBookDO);
    addressBookDTO.setId(addressBookDO.getId());
    return addressBookDTO;
  }

  @Override
  public AddressBookDTO updateAddressBook(int id, AddressBookDTO addressBookDTO) {
    AddressBookDO addressBookDO = addressBookRepo.findById(id)
        .orElseThrow(() -> new CustomException(ExceptionConstant.ID_NOT_FOUND.getMessage()));
    BeanUtils.copyProperties(addressBookDTO, addressBookDO);
    // DTO-> Sanobar
    // DO-> Test -> Sanobar
    addressBookRepo.save(addressBookDO);
    return addressBookDTO;
  }
}

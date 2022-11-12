package org.sg.addressbook.dao;

import org.sg.addressbook.dto.Address;

import java.util.List;

public interface AddressBookDao {
    public Address saveAddress(String lastName, Address address) throws AddressBookDaoException;

    public Address deleteAddress(String lastName) throws AddressBookDaoException;
    public Address getAddress(String lastName) throws AddressBookDaoException;
    public int getAddressCount() throws AddressBookDaoException;
    public List<Address> getAddresses() throws AddressBookDaoException;
}
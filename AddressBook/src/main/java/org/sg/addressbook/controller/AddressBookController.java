package org.sg.addressbook.controller;

import org.sg.addressbook.dao.AddressBookDao;
import org.sg.addressbook.dao.AddressBookDaoException;
import org.sg.addressbook.dao.AddressBookDaoImpl;
import org.sg.addressbook.dto.Address;
import org.sg.addressbook.ui.AddressBookView;

import java.util.List;

public class AddressBookController {
    private AddressBookView addressBookView;
    private AddressBookDao addressBookDao;

    public AddressBookController(AddressBookView addressBookView, AddressBookDao addressBookDao) {
        this.addressBookView = addressBookView;
        this.addressBookDao = addressBookDao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
try {

    while (keepGoing) {
        menuSelection = getMenuSelection();

        switch (menuSelection) {
            case 1:
                addAddress();
                break;
            case 2:
                editAddress();
                break;
            case 3:
                deleteAddress();
                break;
            case 4:
                listAddress();
                break;
            case 5:
                listAddressCount();
                break;
            case 6:
                listAddresses();
                break;
            case 7:
                keepGoing = false;
                break;
            default:
                unknownCommand();
        }
    }
    addressBookView.displayGoodbyeBanner();
} catch (AddressBookDaoException e) {
    addressBookView.displayErrorMessage(e.getMessage());
}
    }
private void unknownCommand() {
    addressBookView.displayUnknownCommandBanner();
}

    private int getMenuSelection() {
        return addressBookView.printMenuAndGetSelection();
    }

    private void addAddress() throws AddressBookDaoException{
        addressBookView.displayAddAddressBanner();
        Address address = addressBookView.getAddressAndNameDetails();
        addressBookDao.saveAddress(address.getLastName(), address);
        addressBookView.displaySuccessfulAddBanner();
    }

    private void editAddress() throws AddressBookDaoException{
        addressBookView.displayEditAddressBanner();
        String lastName = addressBookView.getLastName();
        Address foundAddress = addressBookDao.getAddress(lastName);
        if(foundAddress != null) {
            foundAddress = addressBookView.updateFoundAddressDetails(foundAddress);
            addressBookDao.saveAddress(foundAddress.getLastName(), foundAddress);
            addressBookView.displaySuccessfulAddBanner();
        } else {
            addressBookView.displayAddressNotFoundBanner();
        }
    }

    private void deleteAddress() throws AddressBookDaoException{
        addressBookView.displayDeleteAddressBanner();
        String lastName = addressBookView.getLastName();
        Address removedAddress = addressBookDao.deleteAddress(lastName);
        addressBookView.displayRemoveResult(removedAddress);
    }

    private void listAddress() throws AddressBookDaoException{
        addressBookView.displayGetAddressBanner();
        String lastName = addressBookView.getLastName();
        Address foundAddress = addressBookDao.getAddress(lastName);
        addressBookView.displayAddress(foundAddress);
    }

    private void listAddressCount() throws AddressBookDaoException{
        addressBookView.displayAddressCountBanner();
        int totalAddresses = addressBookDao.getAddressCount();
        addressBookView.displayAddressCount(totalAddresses);
    }
    private void listAddresses() throws AddressBookDaoException{
        addressBookView.displayAddressesBanner();
        List<Address> addresses = addressBookDao.getAddresses();
        addressBookView.displayAddresses(addresses);
    }


}

package org.sg.addressbook.dao;

import org.sg.addressbook.dto.Address;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBookDaoImpl implements AddressBookDao {
    public static final String ADDRESS_BOOK_FILE = "address-book.txt";
    public static final String DELIMITER = "::";

    HashMap<String, Address> addresses = new HashMap<>();

    @Override
    public Address saveAddress(String lastName, Address address) throws AddressBookDaoException {
        loadAddress();
        Address addedAddress = addresses.put(lastName, address);
        writeAddress();
        return addedAddress;
    }

    @Override
    public Address deleteAddress(String lastName) throws AddressBookDaoException {
        loadAddress();
        Address deletedAddress = addresses.remove(lastName);
        writeAddress();
        return deletedAddress;
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookDaoException {
        loadAddress();
        return addresses.get(lastName); }

    @Override
    public List<Address> getAddresses() throws AddressBookDaoException {
        loadAddress();
        return new ArrayList<>(addresses.values());
    }

    @Override
    public int getAddressCount() throws AddressBookDaoException {
        loadAddress();
        return addresses.size();
    }



    private Address unmarshallAddress(String addressAsTxt) {
        // lastName::firstName::lastName::streetAddress::city::state::zip
        String[] addressTokens = addressAsTxt.split(DELIMITER);
        String lastNameKey = addressTokens[0];
        String firstName = addressTokens[1];
        String streetAddress = addressTokens[3];
        String city = addressTokens[4];
        String state = addressTokens[5];
        String zip = addressTokens[6];
        Address addressFromFile = new Address(firstName, lastNameKey, streetAddress, city, state, zip);
        return addressFromFile;
    }

    private void loadAddress() throws AddressBookDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("Could not load addresses from memory.", e);
        }
        String currentLine;
        Address currentAddress;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentAddress = unmarshallAddress(currentLine);
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        scanner.close();
    }

    private String marshallAddress(Address address) {
        String addressAsTxt = address.getLastName() + DELIMITER;
        addressAsTxt += address.getFirstName() + DELIMITER;
        addressAsTxt += address.getLastName() + DELIMITER;
        addressAsTxt += address.getStreet() + DELIMITER;
        addressAsTxt += address.getCity() + DELIMITER;
        addressAsTxt += address.getState() + DELIMITER;
        addressAsTxt += address.getZip() + DELIMITER;
        return addressAsTxt;
    }

    private void writeAddress() throws AddressBookDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_BOOK_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save address data.", e);
        }
        String addressAsTxt;
        List<Address> addressList = this.getAddresses();
        for(Address currentAddress : addressList) {
            addressAsTxt = marshallAddress(currentAddress);
            out.println(addressAsTxt);
            out.flush();
        }
    out.close();
    }

}

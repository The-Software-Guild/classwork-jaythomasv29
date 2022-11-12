package org.sg.addressbook.ui;

import org.sg.addressbook.dto.Address;

import java.util.List;

public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO io) { this.io = io; }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("\t Please select the operation you with to perform:");
        io.print("\t 1. Add Address");
        io.print("\t 2. Edit Address");
        io.print("\t 3. Delete Address");
        io.print("\t 4. Find Address by Last Name");
        io.print("\t 5. List Address Count");
        io.print("\t 6. List All Addresses");
        io.print("\t 7. Exit");
        return io.readInt("Please select from the above choices", 1, 7);
    }

    public void displayAddAddressBanner() {
        io.print("Add Address Menu:");
    }
    public void displaySuccessfulAddBanner() {
        io.readString("Address saved successfully! Hit enter to continue");
    }
    public void displayDeleteAddressBanner() {
        io.print("Delete Address Menu:");
    }
    public void displayGetAddressBanner() {
        io.print("Display Address Details:");
    }
    public void displayAddressCountBanner() {
        io.print("List Address Count Menu:");
    }
    public void displayAddressesBanner() {
        io.print("List Addresses Menu:");
    }
    public void displayAddressNotFoundBanner() {
        io.readString("Address not found. Hit enter to go back to main menu");
    }

    public void displayUnknownCommandBanner() { io.print("Please enter a valid command"); }
    public void displayGoodbyeBanner() { io.print("Goodbye"); }
    public void displayEditAddressBanner() { io.print("Edit Address"); }
    public void displayErrorMessage(String message) { io.print(message); }
    public void displayRemoveResult(Address address) {
        displayAddress(address);
        if(address != null) {
            io.print("Address successfully deleted");
        } else {
            io.print("No such address associated with this last name.");
        }
        io.readString("Hit enter to continue");
    }

    public Address getAddressAndNameDetails() {
        String firstName = io.readString("\t Please Enter First Name:");
        String lastName = io.readString("\t Please Enter Last Name:");
        String streetAddress = io.readString("\t Please Enter Street Address:");
        String city = io.readString("\t Please Enter City:");
        String state = io.readString("\t Please Enter State:");
        String zip = io.readString("\t Please Enter Zip:");
        return new Address(firstName, lastName, streetAddress, city, state, zip);
    }

    public Address updateFoundAddressDetails(Address foundAddress) {
        if(foundAddress != null) {
            String streetAddress = io.readString("\t Please Enter Street Address:");
            String city = io.readString("\t Please Enter City:");
            String state = io.readString("\t Please Enter State:");
            String zip = io.readString("\t Please Enter Zip:");
            return new Address(foundAddress.getFirstName(), foundAddress.getLastName(), streetAddress, city, state, zip);
        } else {
            io.print("No such address associated with this last name");
            return null;
        }
    }


    public String getLastName() {
        String lastName = io.readString("\t Please Enter Last Name:");
        return lastName;
    }

    public void displayAddress(Address address) {
        if(address != null) {
            String name = address.getFirstName() + " " + address.getLastName();
            String cityStateZip = address.getCity() + ", " + address.getState() + ", " + address.getZip();
            io.print(name);
            io.print(address.getStreet());
            io.print(cityStateZip);
        } else {
            io.print("No such address associated with this last name.");
        }
        io.readString("Hit enter to continue");
    }

    public void displayAddressCount(int count) {
        String statement = "There are " + count + " addresses in the book.";
        io.print(statement);
        io.readString("Hit enter to continue");
    }

    public void displayAddresses(List<Address> addresses) {
        if(addresses.size() == 0) {
            io.readString("0 addresses in book, Hit enter to continue");
            return;
        }
        for(Address address : addresses) {
            String name = address.getFirstName() + " " + address.getLastName();
            String cityStateZip = address.getCity() + ", " + address.getState() + ", " + address.getZip();
            io.print(name);
            io.print(address.getStreet());
            io.print(cityStateZip);
            System.out.println("");
        }
        io.readString("Hit enter to continue");
    }



}

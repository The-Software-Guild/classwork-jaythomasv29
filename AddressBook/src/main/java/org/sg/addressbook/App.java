package org.sg.addressbook;

import org.sg.addressbook.controller.AddressBookController;
import org.sg.addressbook.dao.AddressBookDao;
import org.sg.addressbook.dao.AddressBookDaoImpl;
import org.sg.addressbook.ui.AddressBookView;
import org.sg.addressbook.ui.UserIO;
import org.sg.addressbook.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
     UserIO userIo = new UserIOConsoleImpl();
     AddressBookView addressBookView = new AddressBookView(userIo);
     AddressBookDao addressBookDao = new AddressBookDaoImpl();
     AddressBookController addressBookController = new AddressBookController(addressBookView, addressBookDao);
     addressBookController.run();

    }


}

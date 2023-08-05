package nvds.Geography;

import nvds.Contact.Contact;
import java.util.HashSet;

public class Address {

    private String street;

    private String postalCode;

    private HashSet<Contact> listOfContacts;

    public Address(String street, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
        this.listOfContacts = new HashSet<>();
    }

    public Contact addContact(String phoneNumber) {
        Contact contact = new Contact(phoneNumber);
        listOfContacts.add(contact);
        return contact;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public HashSet<Contact> getListOfContacts() {
        return listOfContacts;
    }

    public void setListOfContacts(HashSet<Contact> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }

    @Override
    public String toString() {
        return street + ", " + postalCode;
    }

}

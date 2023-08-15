package nvds.geography;

import java.util.HashSet;

/**
 * @author libby
 * @author mutara
 */
public class Address {

    private String street;

    private String postalCode;

    private HashSet<Contact> contactsList;

    public Address(String street, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
        this.contactsList = new HashSet<>();
    }

    public Contact addContact(String phoneNumber) {
        Contact contact = new Contact(phoneNumber);
        contactsList.add(contact);
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

    public HashSet<Contact> getContactsList() {
        return contactsList;
    }

    public void setContactsList(HashSet<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public String toString() {
        return street + ", " + postalCode;
    }

}

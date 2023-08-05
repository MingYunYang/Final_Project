package model.Contact;

public class Contact {

    private String participatingOrganizationPhoneNumber;

    public Contact(String participatingOrganizationPhoneNumber) {
        this.participatingOrganizationPhoneNumber = participatingOrganizationPhoneNumber;
    }

    public String getParticipatingOrganizationPhoneNumber() {
        return participatingOrganizationPhoneNumber;
    }

    public void setParticipatingOrganizationPhoneNumber(String participatingOrganizationPhoneNumber) {
        this.participatingOrganizationPhoneNumber = participatingOrganizationPhoneNumber;
    }

    @Override
    public String toString() {
        return participatingOrganizationPhoneNumber;

    }

}

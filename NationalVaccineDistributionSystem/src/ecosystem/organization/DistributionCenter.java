package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.DistributionCenterRole;
import ecosystem.role.Role;

public class DistributionCenter extends Organization {
    
    private Role distributionCenterRole;

    public DistributionCenter(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.DistributionCenter, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(distributionCenterRole == null){
            distributionCenterRole = new DistributionCenterRole();
        }
        return distributionCenterRole;
    }

    

}

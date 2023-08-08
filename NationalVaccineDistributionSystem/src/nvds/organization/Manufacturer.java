package nvds.organization;

import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.Role;
import java.util.ArrayList;
import nvds.role.VaccineInventoryManagerRole;

public class Manufacturer extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Manufacturer(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Manufacturer, country, state, city, address, contact);
    }
    
//    public int getVaccineAvailability(Vaccine vaccineType, VaccineInventoryCatalog inventoryCatalog){
//        int sum = 0;
//        for(VaccineItem vaccineItem : inventoryCatalog.getVaccineItemList()){
//            if(vaccineItem.getVaccine().equals(vaccineType)){
//                sum = sum + 1;
//            }
//        }
//        return sum;
//    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new VaccineInventoryManagerRole());
        }
        return supportedRole;
    }

    

}

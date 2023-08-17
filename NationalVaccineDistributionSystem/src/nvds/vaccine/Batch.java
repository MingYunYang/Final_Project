package nvds.vaccine;

import nvds.organization.Manufacturer;

/**
 * @author libby
 * @author mutara
 */
public class Batch {

    private Vaccine vaccine;
    private int quantity; // manufatcured quantity 製作出來的數量
    private int priceForEachVaccine;
    private Manufacturer manufacturer;
    private String manufactureDate;
    private String expirationDate;
    private String batchId;
    private String paymentStatus;
    private int originalQuantity; // allocated quantity for clinic 分配給診所的數量
    private int availableQuantity; // left quantity in clinic 診所實際上剩下的數量
    private int availableQuantityInCDC; // left quantity in CDC CDC實際上剩下的數量
    private int availableQuantityInHospital; // left quantity in hospital 醫院實際上剩下的數量
    private int availableQuantityInDistributor; // left quantity in distributor Distributor實際上剩下的數量


    public Batch ( Vaccine vaccine, int quantity, int priceForEachVaccine, Manufacturer manufacturer, String manufactureDate, String expirationDate, String batchId ) {

        this.vaccine = vaccine;
        this.quantity = quantity;
        this.priceForEachVaccine = priceForEachVaccine;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.batchId = batchId;
        paymentStatus = "Waiting";
    }
    
    public String getInventoryStatus(){
        if(availableQuantity < 50 ){
            return "Insufficient";
        }
        return "Sufficient";
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity ( int quantity ) {
        this.quantity = quantity;
    }

    public Manufacturer getManufacturer () {
        return manufacturer;
    }

    public void setManufacturer ( Manufacturer manufacturer ) {
        this.manufacturer = manufacturer;
    }

    public String getManufactureDate () {
        return manufactureDate;
    }

    public void setManufactureDate ( String manufactureDate ) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate () {
        return expirationDate;
    }

    public void setExpirationDate ( String expirationDate ) {
        this.expirationDate = expirationDate;
    }

    public String getBatchId () {
        return batchId;
    }

    public void setBatchId ( String batchId ) {
        this.batchId = batchId;
    }

    public int getPriceForEachVaccine () {
        return priceForEachVaccine;
    }

    public void setPriceForEachVaccine ( int priceForEachVaccine ) {
        this.priceForEachVaccine = priceForEachVaccine;
    }

    public Vaccine getVaccine () {
        return vaccine;
    }

    public String getPaymentStatus () {
        return paymentStatus;
    }

    public void setPaymentStatus ( String paymentStatus ) {
        this.paymentStatus = paymentStatus;
    }

    public int getOriginalQuantity () {
        return originalQuantity;
    }

    public void setOriginalQuantity ( int originalQuantity ) {
        this.originalQuantity = originalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantityInCDC() {
        return availableQuantityInCDC;
    }

    public void setAvailableQuantityInCDC(int availableQuantityInCDC) {
        this.availableQuantityInCDC = availableQuantityInCDC;
    }

    public int getAvailableQuantityInHospital() {
        return availableQuantityInHospital;
    }

    public void setAvailableQuantityInHospital(int availableQuantityInHospital) {
        this.availableQuantityInHospital = availableQuantityInHospital;
    }

    public int getAvailableQuantityInDistributor() {
        return availableQuantityInDistributor;
    }

    public void setAvailableQuantityInDistributor(int availableQuantityInDistributor) {
        this.availableQuantityInDistributor = availableQuantityInDistributor;
    }




    
    

    @Override
    public String toString () {
        return batchId;
    }

}

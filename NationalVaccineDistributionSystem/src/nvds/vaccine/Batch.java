package nvds.vaccine;

import nvds.organization.Manufacturer;

public class Batch {

    private Vaccine vaccine;
    private int quantity;
    private int priceForEachVaccine;
    private Manufacturer manufacturer;
    private String manufactureDate;
    private String expirationDate;
    private String batchId;
    private String paymentStatus;
    private int originalQuantity;


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

    public Batch ( Vaccine vaccine, String batchId, int quantity, Manufacturer manufacturer, String manufactureDate, String expirationDate ) {

        this.vaccine = vaccine;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.batchId = batchId;
    }

//    private void generateBatchId(int productionMonth , int productionYear , String manufacturerCode , int currentBatchNumber) {
//        
//        this.batchId = String.format(
//                "%02d%02d-%s-%05d" ,
//                productionMonth ,
//                productionYear ,
//                manufacturerCode ,
//                currentBatchNumber
//        );
//    }
//    private boolean isValidDate(String date) {
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        try {
//            dateFormat.parse(date);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }
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

    @Override
    public String toString () {
        return batchId;
    }

}

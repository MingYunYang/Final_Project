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
    private int productionMonth;
    private int productionYear;
    private String manufacturerCode;
    private int currentBatchNumber;

    public Batch(Vaccine vaccine, int quantity, int priceForEachVaccine, Manufacturer manufacturer, String manufactureDate, String expirationDate, String batchId) { 
        
        this.vaccine = vaccine;
        this.quantity = quantity;
        this.priceForEachVaccine = priceForEachVaccine;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.batchId = batchId;
        
//        this.productionMonth = productionMonth;
//        this.productionYear = productionYear;
//        this.manufacturerCode = manufacturerCode;
//        this.currentBatchNumber = currentBatchNumber;
//        generateBatchId(productionMonth, productionYear, manufacturerCode, currentBatchNumber);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getProductionMonth() {
        return productionMonth;
    }

    public void setProductionMonth(int productionMonth) {
        this.productionMonth = productionMonth;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public int getCurrentBatchNumber() {
        return currentBatchNumber;
    }

    public void setCurrentBatchNumber(int currentBatchNumber) {
        this.currentBatchNumber = currentBatchNumber;
    }

    public int getPriceForEachVaccine() {
        return priceForEachVaccine;
    }

    public void setPriceForEachVaccine(int priceForEachVaccine) {
        this.priceForEachVaccine = priceForEachVaccine;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }
    
    


    
    

    
    
    


}

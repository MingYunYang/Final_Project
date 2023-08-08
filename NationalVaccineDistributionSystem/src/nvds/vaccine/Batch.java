package nvds.vaccine;

public class Batch {

    private String batchId;
    
    private int quantity;

    private int productionMonth;

    private int productionYear;

    private String manufacturerCode;

    private int currentBatchNumber;

    public Batch(int productionMonth , int productionYear , String manufacturerCode , int currentBatchNumber, int quantity) {
        this.productionMonth = productionMonth;
        this.productionYear = productionYear;
        this.manufacturerCode = manufacturerCode;
        this.currentBatchNumber = currentBatchNumber;
        this.quantity = quantity;
        generateBatchId();
    }

    private void generateBatchId() {
        this.batchId = String.format(
                "%02d%02d-%s-%05d" ,
                productionMonth ,
                productionYear ,
                manufacturerCode ,
                currentBatchNumber
        );
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }


    public String getBatchId() {
        return this.batchId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    


}

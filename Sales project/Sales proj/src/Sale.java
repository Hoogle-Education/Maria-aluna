import java.math.BigDecimal;
import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

public class Sale {

    private String number;
    private LocalDate saleDate;
    private LocalDate deliveryDate;
    private String region;
    private String estate;
    private String manager;
    private String seller;
    private String department;
    private String paymentMethod;
    private BigDecimal value;
    private Status status;

    public enum Status {

      COMPLETED, CANCELLED;

      public static Sale.Status statusByValue(String value) {
          return switch (value) {
              case "Concluída" -> COMPLETED;
              case "Cancelada" -> CANCELLED;
              default -> throw new IllegalArgumentException("Can't parse " + value);
          };
      }

    }

    public boolean isCompleted() {
        return this.status == Status.COMPLETED;
    }

    public boolean isCancelled() {
        return this.status == Status.CANCELLED;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

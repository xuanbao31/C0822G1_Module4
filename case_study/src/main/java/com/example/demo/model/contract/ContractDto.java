package com.example.demo.model.contract;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class ContractDto implements Validator {
    private int id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Set<ContractDetail> contractDetails;
    private Customer customer;
    private Facility facility;
    private Double totalPrice;

    public ContractDto() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void getTotalcost(){
        this.totalPrice = this.facility.getCost();
        if (this.contractDetails != null) {
            for (ContractDetail contractDetail : this.contractDetails){
                this.totalPrice += contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}

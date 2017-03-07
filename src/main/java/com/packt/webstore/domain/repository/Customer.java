package com.packt.webstore.domain.repository;

/**
 * Created by Cyprian on 2017-03-04.
 */
public class Customer {

    private String customerId;
    private String name;
    private String adress;
    private String noOfOrdersMade;

    public Customer(String customerId, String name, String adress, String noOfOrdersMade) {
        this.customerId = customerId;
        this.name = name;
        this.adress = adress;
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(String noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (name == null) {
            if (other.customerId != null)
                return false;
        } else if (!name.equals(other.customerId))
            return false;
        return true;
    }

}

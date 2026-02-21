package com.glo.TransportLogisticDomainCapstoneProject.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id;
    private String cust_name;
    private Long cust_contact;
    private String cust_add;

    public Customer(int cust_id, String cust_name, Long cust_contact, String cust_add) {
        super();
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_contact = cust_contact;
        this.cust_add = cust_add;
    }

    public Customer() {
        super();
    }

    public int getCust_id() {
        return cust_id;
    }
    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public Long getCust_contact() {
        return cust_contact;
    }
    public void setCust_contact(Long cust_contact) {
        this.cust_contact = cust_contact;
    }
    public String getCust_add() {
        return cust_add;
    }
    public void setCust_add(String cust_add) {
        this.cust_add = cust_add;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Customer{");
        sb.append("id='").append(cust_id);
        sb.append(", name='").append(cust_name);
        sb.append(", contact='").append(cust_contact);
        sb.append(", address='").append(cust_add);
        sb.append("}");
        return sb.toString();
    }
}

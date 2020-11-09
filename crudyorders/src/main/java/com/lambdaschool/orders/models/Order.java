package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the orders table.
 */
@Entity
@Table(name = "orders")
public class Order
{
    /**
     * The primary key number (long) of the order's table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    /**
     * The order amount (double) for this order.
     */
    private double ordamount;

    /**
     * The amount (double) prepaid for this order.
     */
    private double advanceamount;

    /**
     * The description of this order (String).
     */
    private String orderdescription;

    /**
     * Creates a join table joining Orders and Payments in a Many-To-Many relations.
     * Contains a list of Payment objects used by this order.
     */
    @ManyToMany()
    @JoinTable(name = "orderspayments",
        joinColumns = @JoinColumn(name = "ordnum"),
        inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties("orders")
    Set<Payment> payments = new HashSet<>();

    /**
     * A foreign key to the customer table.
     * Forms a Many-To-One relation with the customer table. Many orders to one customer.
     * Contains an object pointer to the full customer object.
     */
    @ManyToOne
    @JoinColumn(name = "custcode",
        nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    /**
     * Default constructor used primarily by the JPA.
     */
    public Order()
    {
    }

    /**
     * Given the params, create a new order object.
     * <p>
     * ordnum is autogeneration
     *
     * @param ordamount        The order amount (double) for this order.
     * @param advanceamount    The amount (double) prepaid for this order.
     * @param customer         The customer object assigned to this order
     * @param orderdescription The description of this order (String).
     *                         payments are added outside of this constructor.
     */
    public Order(
        double ordamount,
        double advanceamount,
        Customer customer,
        String orderdescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    /**
     * Getter for ordnum.
     *
     * @return The primary key number (long) of the order's table.
     */
    public long getOrdnum()
    {
        return ordnum;
    }

    /**
     * Setter for ordnum - used primarily when seeding data.
     *
     * @param ordnum The new primary key number (long) of the order's table.
     */
    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    /**
     * Getter for ordamount.
     *
     * @return The order amount (double) for this order.
     */
    public double getOrdamount()
    {
        return ordamount;
    }

    /**
     * Setter for ordamount.
     *
     * @param ordamount The new order amount (double) for this order.
     */
    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    /**
     * Getter for advanceamount.
     *
     * @return The amount (double) prepaid for this order.
     */
    public double getAdvanceamount()
    {
        return advanceamount;
    }

    /**
     * Setter for advanceamount.
     *
     * @param advanceamount The new amount (double) prepaid for this order.
     */
    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    /**
     * Getter for order description.
     *
     * @return The description of this order (String).
     */
    public String getOrderdescription()
    {
        return orderdescription;
    }

    /**
     * Setter for order description.
     *
     * @param orderdescription The new description of this order (String).
     */
    public void setOrderdescription(String orderdescription)
    {
        this.orderdescription = orderdescription;
    }

    /**
     * Getter for customer.
     *
     * @return The customer object assigned to this order.
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Setter for customer.
     *
     * @param customer Assigning a new customer object to this order.
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * Getter for payments.
     *
     * @return A list of the payments used by this order.
     */
    public Set<Payment> getPayments()
    {
        return payments;
    }

    /**
     * Setter for payments.
     *
     * @param payments A new list of payments used by this order.
     */
    public void setPayments(Set<Payment> payments)
    {
        this.payments = payments;
    }
}

package com.lambdaschool.orders.services;


import com.lambdaschool.orders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the PaymentService Interface.
 */
@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl
        implements PaymentService
{
    /**
     * Connects this service to the payments table.
     */
    @Autowired
    PaymentRepository paymentrepos;
}

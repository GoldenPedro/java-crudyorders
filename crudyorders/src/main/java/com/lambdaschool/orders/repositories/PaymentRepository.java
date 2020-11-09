package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Payment to rest of the application.
 */
public interface PaymentRepository
    extends CrudRepository<Payment, Long>
{
}

package org.projects.WebSpring.repositories;

import org.projects.WebSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>
{

}

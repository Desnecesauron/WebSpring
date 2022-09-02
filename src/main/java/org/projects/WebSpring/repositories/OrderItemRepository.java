package org.projects.WebSpring.repositories;

import org.projects.WebSpring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{

}

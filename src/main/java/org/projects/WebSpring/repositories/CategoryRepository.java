package org.projects.WebSpring.repositories;

import org.projects.WebSpring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}

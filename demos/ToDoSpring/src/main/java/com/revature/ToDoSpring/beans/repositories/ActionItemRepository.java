package com.revature.ToDoSpring.beans.repositories;

import com.revature.ToDoSpring.beans.models.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionItemRepository extends JpaRepository<ActionItem, Integer> {
    /*
    We get a bunch of free concrete methods when spring instantiates a bean from this repository

    Extending the CrudRepository, PagingAndSortingRepository, JpaRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */
}

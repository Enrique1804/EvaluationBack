package com.evaluation.backend.dao;

import com.evaluation.backend.item.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Item getItemById(int theId) {
        return entityManager.find(Item.class,theId);
    }

    @Override
    public List<Item> getItemsByState(String theState) {
        TypedQuery<Item> theQuery = entityManager.createQuery("FROM Item WHERE state=:theData", Item.class);
        theQuery.setParameter("theData", theState);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Item postItem(Item theItem) {
        entityManager.merge(theItem);
        return theItem;
    }

    @Override
    @Transactional
    public void deleteItemById(int theId) {
        Item tempItem = entityManager.find(Item.class,theId);
        entityManager.remove(tempItem);
    }
}

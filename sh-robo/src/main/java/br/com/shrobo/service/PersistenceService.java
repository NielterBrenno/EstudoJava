package br.com.shrobo.service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistenceService<T, ID extends Serializable, E extends Exception, DAO extends JpaRepository<T, ID>> {

    DAO getDAO();

    default void delete(T model) throws E {
        getDAO().delete(model);
    }

    default void delete(ID id) throws Exception { 
    	getDAO().delete(id);
    }
    
    default void delete() throws Exception { }
    
    default void save(T model) throws E {
        getDAO().saveAndFlush(model);
    }
    default void save() throws Exception { }

    default List<T> findAll() throws E {
        return getDAO().findAll();
    }

    default Object[] getItems() {
        List<Object> l = new LinkedList<>();
        l.add("Selecione");
        l.addAll(getDAO().findAll());
        return l.toArray();
    }

    default T getOne(ID id) throws E {
        return getDAO().getOne(id);
    }
}

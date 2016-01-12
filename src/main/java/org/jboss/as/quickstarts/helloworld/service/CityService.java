package org.jboss.as.quickstarts.helloworld.service;

import org.hibernate.Session;
import org.jboss.as.quickstarts.helloworld.model.City;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by fpagetti on 27/11/2015.
 */

public class CityService {

   // @PersistenceContext(unitName = "MySQL", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<City> findAll(){
        Query query = em.createQuery("SELECT e FROM City e");
        return (List<City>) query.getResultList();
    }

}

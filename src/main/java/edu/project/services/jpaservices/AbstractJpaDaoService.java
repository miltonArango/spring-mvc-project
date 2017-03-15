package edu.project.services.jpaservices;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by Marango on 11/03/2017.
 */
public class AbstractJpaDaoService {

    protected EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}

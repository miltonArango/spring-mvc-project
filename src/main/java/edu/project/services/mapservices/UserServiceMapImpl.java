package edu.project.services.mapservices;

import edu.project.domain.DomainObject;
import edu.project.domain.User;
import edu.project.services.UserService;

import java.util.List;

/**
 * Created by Marango on 11/03/2017.
 *
 */
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {

    }
}

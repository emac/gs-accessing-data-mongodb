package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Emac
 * @since 2016-05-01
 */
@Service
public class CustomerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void deleteAll() {
        mongoTemplate.dropCollection(Customer.class);
    }

    public void save(Customer customer) {
        mongoTemplate.save(customer);
    }

    public List<Customer> findAll() {
        return mongoTemplate.findAll(Customer.class);
    }

    public Customer findByFirstName(String firstName) {
        return mongoTemplate.findOne(query(where("firstName").is(firstName)), Customer.class);
    }

    public List<Customer> findByLastName(String lastName) {
        return mongoTemplate.find(query(where("lastName").is(lastName)), Customer.class);
    }

}

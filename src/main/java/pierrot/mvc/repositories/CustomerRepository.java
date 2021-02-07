package pierrot.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pierrot.mvc.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

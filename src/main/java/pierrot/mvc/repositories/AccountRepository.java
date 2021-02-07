package pierrot.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pierrot.mvc.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}

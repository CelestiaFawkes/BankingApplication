package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}

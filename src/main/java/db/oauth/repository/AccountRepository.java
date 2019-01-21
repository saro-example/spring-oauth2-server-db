package db.oauth.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import db.oauth.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long>
{
    @EntityGraph("roles")
    @Query("SELECT a FROM account a WHERE account = :account")
    Optional<Account> findByAccount(@Param("account") String account);
}
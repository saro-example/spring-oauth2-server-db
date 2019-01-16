package db.oauth.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import db.oauth.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long>
{
    @Query("SELECT a FROM account a WHERE ac = :ac")
    Optional<Account> findByAc(@Param("ac") String ac);
}
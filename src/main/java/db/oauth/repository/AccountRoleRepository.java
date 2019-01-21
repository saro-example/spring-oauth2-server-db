package db.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import db.oauth.entity.AccountRole;

public interface AccountRoleRepository extends CrudRepository<AccountRole, AccountRole.Key> {
    @Query("SELECT r FROM account_role r WHERE no = :no")
    List<AccountRole> findByNo(@Param("no") long no);
}
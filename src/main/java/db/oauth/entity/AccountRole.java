package db.oauth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import db.oauth.entity.AccountRole.Key;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 테이블
 */
@Entity(name="account_role")
@Table(name="account_role")
@IdClass(Key.class)
@Data @AllArgsConstructor @NoArgsConstructor
public class AccountRole implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="no", nullable=false)
	long no;

	@Id
	@Column(name="role", nullable=false, length=64, unique=true)
	String role;
	
	@Data @AllArgsConstructor @NoArgsConstructor
    public static class Key implements Serializable {
        private static final long serialVersionUID = 1L;
        long no;
        String role;
    }
}

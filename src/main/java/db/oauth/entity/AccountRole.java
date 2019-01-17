package db.oauth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import db.oauth.entity.AccountRole.Key;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 테이블
 */
@Entity(name="users")
@Table(name="users")
@IdClass(Key.class)
@Data @AllArgsConstructor @NoArgsConstructor
@SequenceGenerator(name = "users_no_seq", sequenceName = "users_no_seq", allocationSize = 1)
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
        String type;
    }
}

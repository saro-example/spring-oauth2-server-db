# spring-oauth-server
spring oauth server

## create data (account)
```
CREATE TABLE account (
	no bigserial NOT NULL,
	account varchar(64) NOT NULL,
	password varchar(512) NOT NULL,
	CONSTRAINT account_pk PRIMARY KEY (no)
);

CREATE UNIQUE INDEX account_account ON account USING btree (account);

CREATE TABLE account_role (
	no bigint NOT NULL,
	role varchar(64) NOT NULL,
	CONSTRAINT account_role_pk PRIMARY KEY (no, role)
);

-- test data
insert into account values (nextval('account_no_seq'), 'saro', 'd760688da522b4dc3350e6fb68961b0934f911c7d0ff337438cabf4608789ba94ce70b6601d7e08a279ef088716c4b1913b984513fea4c557d404d0598d4f2f1'); -- hash is sha3_512(1234)

insert into account_role values (currval('account_no_seq'), 'master');
insert into account_role values (currval('account_no_seq'), 'admin');
```

## create data (token)
```
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(256), authentication bytea
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
```
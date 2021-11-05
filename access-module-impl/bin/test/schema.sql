CREATE TABLE module (
  id varchar(100) NOT NULL,
  code varchar(100),
  name varchar(200),
  module_group varchar(100),
  note varchar(250),
  is_enabled char(5),
  created_by varchar(100),
  created_date timestamp,
  last_updated_by varchar(100),
  last_updated_date timestamp,
  version bigint(20) DEFAULT 0,
  organization varchar(250),
  PRIMARY KEY (id)
);
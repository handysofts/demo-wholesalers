CREATE TABLE IF NOT EXISTS rebate_agreements (
  id_ BIGINT,
  name_ varchar(250) NOT NULL,
  desc_ varchar(512) NOT NULL,
  status int DEFAULT 1,
  ins_time timestamp DEFAULT current_timestamp(),
  upd_time timestamp,
  PRIMARY KEY (id_)
);

ALTER TABLE rebate_agreements ADD CONSTRAINT uq_rebate_agreements_name UNIQUE(name_);
COMMENT ON COLUMN rebate_agreements.desc_ IS 'Description of agreement what is it for';
COMMENT ON COLUMN rebate_agreements.status IS '0-Deactivated, 1-Active';
CREATE TABLE IF NOT EXISTS customers (
  id_ IDENTITY,
  name_ varchar(250) NOT NULL,
  rebate_agreement_id bigint ,
  status int DEFAULT 1,
  ins_time timestamp DEFAULT current_timestamp(),
  upd_time timestamp,
  PRIMARY KEY (id_)
);

ALTER TABLE customers ADD CONSTRAINT uq_customers_name UNIQUE(name_);
ALTER TABLE customers ADD CONSTRAINT fk_customers_rebate_agreement_id FOREIGN KEY (rebate_agreement_id) references rebate_agreements (id_);
COMMENT ON COLUMN customers.status IS '0-Deactivated, 1-Active';
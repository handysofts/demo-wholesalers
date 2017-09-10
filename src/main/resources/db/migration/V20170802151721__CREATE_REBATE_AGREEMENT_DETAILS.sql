CREATE TABLE IF NOT EXISTS rebate_agreement_details (
  id_ IDENTITY,
  rebate_agreement_id bigint,
  key_ varchar(250) NOT NULL,
  value_ varchar(250) NOT NULL,
  status int DEFAULT 1,
  ins_time timestamp DEFAULT current_timestamp(),
  upd_time timestamp,
  PRIMARY KEY (id_)
);

ALTER TABLE rebate_agreement_details ADD CONSTRAINT uq_rebate_agreement_details_key UNIQUE(rebate_agreement_id, key_);
ALTER TABLE rebate_agreement_details ADD CONSTRAINT fk_rebate_agreement_details_rebate_agreement_id FOREIGN KEY (rebate_agreement_id) references rebate_agreements (id_);
COMMENT ON COLUMN rebate_agreement_details.status IS '0-Deactivated, 1-Active';
CREATE TABLE IF NOT EXISTS products (
  id_ IDENTITY,
  name_ varchar(250) NOT NULL,
  price DECIMAL,
  status int DEFAULT 1,
  ins_time timestamp DEFAULT current_timestamp(),
  upd_time timestamp,
  PRIMARY KEY (id_)
);

ALTER TABLE products ADD CONSTRAINT uq_products_name UNIQUE(name_);
COMMENT ON COLUMN products.status IS '0-Deactivated, 1-Active';
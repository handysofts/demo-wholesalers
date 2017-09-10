INSERT INTO rebate_agreements(id_, name_, desc_) VALUES (1, 'rebate-agreement-fixed-percentage', 'Calculates discount price based on fixed percentage as 35%');
INSERT INTO rebate_agreement_details(rebate_agreement_id, key_, value_) VALUES (1, 'percentage', '35');

INSERT INTO rebate_agreements(id_, name_, desc_) VALUES (2, 'rebate-agreement-quantity-thresholds', 'Calculates discount based on quantity ranges example 0,100 - 10$');
INSERT INTO rebate_agreement_details(rebate_agreement_id, key_, value_) VALUES (2, '0,100', '1');
INSERT INTO rebate_agreement_details(rebate_agreement_id, key_, value_) VALUES (2, '100,500', '13');
INSERT INTO rebate_agreement_details(rebate_agreement_id, key_, value_) VALUES (2, '500,1000', '113');
INSERT INTO rebate_agreement_details(rebate_agreement_id, key_, value_) VALUES (2, '1000,9999999', '950');
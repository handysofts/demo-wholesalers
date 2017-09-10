# demo-wholesalers
Demo app for below task (creating rebate agreements):

>Assume you are working for a software house producing applications for a
wholesales retailers specialized in office furniture. Your clients needs software to
support the process of importing goods and sell these to shops and chains. It is
common to give rebates to customers based on various criteria like how much they
sell, time of year, special deals etc.

>Make a simple application containing products with standard prices and customers
with rebate agreements. Given a customer, a product and the quantity purchased
the program calculates the discount and the price. Use two or more types of rebate
agreements, for example one with a fixed percentage and one with some volume
discount logic based on quantity thresholds.

&nbsp;

Used technologies are below:
- Maven
- Java 8
- Spring boot
- Spring data
- H2 in-memory Database
- Flyway
- Lombok
- Logback
- Thymeleaf
- Jquery
- Bootstrap
- JS
- HTML
- CSS

**NOTE:** If lombok plugin not installed to your IDE please install before import project source

&nbsp;

H2 db used for simplicity, you can use any db configuring datasource from `application.properties`.

Flyway used for auto migration/creation of DB. So you can simply create and use your own DB to start the project.

&nbsp;

If you want to define new kind of rebate agreement, do it as below in 3 steps:

1. Insert new agreement and details (values as percentage and etc. which used during discount calculation) to DB using insert sql files under resources/db/migration
2. Create new Component (@Component) which implements `RebateAgreementComponent` interface and has name/id as defined on rebate_agreements table's name_ column (like as rebate-agreement-fixed-percentage)
3. That is all, 
Now you are free to assign this agreement to any customer. It should work like a charm.
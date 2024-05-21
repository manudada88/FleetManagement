INSERT INTO CUSTOMERS (cUSTOMER_ID, EMAIL, FULL_NAME, PHONE_NUMBER) VALUES
(101, 'manu.shrivastava@mail.ru', 'Manu Shrivastava', '9959098655');
INSERT INTO CUSTOMERS (cUSTOMER_ID, EMAIL, FULL_NAME, PHONE_NUMBER) VALUES
(102, 'sunnyjeka@gmail.com', 'Evgeniia Zalovkova', '9959098655');
INSERT INTO CUSTOMERS (cUSTOMER_ID, EMAIL, FULL_NAME, PHONE_NUMBER) VALUES
(103, 'getsupriya@gmail.com', 'Supriya Shrivastava', '9959098655');

insert into CARS (unique_Number, assembly_Date, customer_id)
values('03TXA','2023-05-05', 101);
insert into CARS (unique_Number, assembly_Date, customer_id)
values('03AXA','2014-05-05', 102);

insert into dealers (dealer_ID, EMAIL, NAME, REPRESENTATIVE_FULL_NAME) values
(1001, 'rahulMahajan@pegusagro.com', 'Pegas-agro', 'Rahul Mahajan');

insert into CUSTOMERS_DEALERS_ASSIGNED  (CUSTOMERS_LIST_CUSTOMER_ID, DEALERS_ASSIGNED_DEALER_ID)
values (101,1001);
insert into CUSTOMERS_DEALERS_ASSIGNED  (CUSTOMERS_LIST_CUSTOMER_ID, DEALERS_ASSIGNED_DEALER_ID)
values (102,1001);

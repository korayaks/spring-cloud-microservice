CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE emp(
    emp_id int PRIMARY KEY ,
    emp_name text
);

select * from emp
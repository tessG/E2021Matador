CREATE DATABASE IF NOT EXISTS Matador21 DEFAULT CHARSET = utf8mb4;
use Matador21;

create table Field( 
field_id tinyint primary key auto_increment, 
field_type varchar(255),
label varchar(255),
cost smallint,
income smallint,
series_id tinyint
)










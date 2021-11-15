CREATE DATABASE IF NOT EXISTS Matador DEFAULT CHARSET = utf8mb4;
use Matador;

SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS Field;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Deed;
SET FOREIGN_KEY_CHECKS=1; 

create table Field( 
id tinyint primary key auto_increment, 
field_type ENUM("Start", "Plot", "Tax", "ShippingLine", "Chance", "Visit", "Brewery", "Bonus", "Prison"),
label varchar(255),
cost smallint,
income smallint,
series_id tinyint
)ENGINE = InnoDB;


INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Start", "Start", 0, 4000, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Rødovrevej", 1200, 50, 1);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv Lykken", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Hvidovrevej", 1200, 50, 1 );
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Tax", "IndkomstSkat", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("ShippingLine", "Scandlines", 4000, 500, 2 );
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Roskildevej", 2000, 100, 3);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv Lykken", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Valby Langgade", 2000, 100, 3);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Allégade", 2400, 150, 3);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Visit", "På besøg", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Frederiksberg Alle", 2800, 200, 4);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Brewery", "Squash", 3000, 100, 5);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Bülowsvej", 2800, 200, 4);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "GL.Kongevej", 3200, 250, 4);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("ShippingLine", "Mols-Linjen", 4000, 500, 2);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Bernstorffsvej", 3600, 300, 6);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv lykken", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Hellerupvej", 3600, 300, 6);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Strandvejen", 4000, 350, 6);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Bonus", "Parkering", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Trianglen", 4400, 350, 7);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv Lykken", 0 , 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Østerbrogade", 4400, 350, 7);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Grønningen", 4800, 400, 7);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("ShippingLine", "Molslinjen A/S", 4000, 500, 2);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Bredgade", 5200, 450, 8);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Kgs. Nytorv", 5200, 450, 8);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Brewery", "Faxe Bryggeri", 3000, 100, 5);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Østergade", 5600, 500, 8);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Prison", "Fængsel", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Amagertorv", 6000, 550, 9);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Vimmelskaftet", 6000, 550, 9);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv Lykken", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Nygade", 6400, 600, 9);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("ShippingLine", "Scandlines", 4000, 500, 2);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Chance", "Prøv Lykken", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Frederiksberggade", 7000, 700, 10);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Tax", "Statsskat", 0, 0, 0);
INSERT INTO Field (field_type, label, cost, income, series_id) VALUES ("Plot", "Rådhuspladsen", 8000, 1000, 10);


create table Player(
	id tinyint primary key auto_increment, 
    player_name varchar(255),
    balance int
)ENGINE = InnoDB;


create table Deed(
     deed_id tinyint,
     player_id tinyint, 
     field_id tinyint,
     foreign key (player_id) references Player(id),
     foreign key (field_id) references Field(id),
	CONSTRAINT ownershipID PRIMARY KEY (field_id,player_id)
)ENGINE = InnoDB;




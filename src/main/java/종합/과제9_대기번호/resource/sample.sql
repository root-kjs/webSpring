drop database if exists waitingDB_9;
create database waitingDB_9;
use waitingDB_9;

create table waiting(
	wno int auto_increment,
    wphone varchar(13) not null,
    wcount int default 1,
    constraint primary key(wno)
);

insert into waiting (wphone, wcount) values ("010-0000-0000", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1234-5678", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-2345-6789", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-3456-7890", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-4567-8901", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-5678-9012", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-6789-0123", 5);
INSERT INTO waiting (wphone, wcount) VALUES ("010-7890-1234", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-8901-2345", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-9012-3456", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-0123-4567", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1111-2222", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-2222-3333", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-3333-4444", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-4444-5555", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-5555-6666", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-6666-7777", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-7777-8888", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-8888-9999", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-9999-0000", 5);
INSERT INTO waiting (wphone, wcount) VALUES ("010-0000-1111", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1212-3434", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-2323-4545", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-3434-5656", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-4545-6767", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-5656-7878", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-6767-8989", 5);
INSERT INTO waiting (wphone, wcount) VALUES ("010-7878-9090", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-8989-0101", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-9090-1212", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-0101-2323", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1313-3535", 4);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1414-4646", 3);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1515-5757", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1616-6868", 1);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1717-7979", 5);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1818-8080", 2);
INSERT INTO waiting (wphone, wcount) VALUES ("010-1919-9191", 3);

select * from waiting;


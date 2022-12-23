create database camping;
use camping;

create table `account` (
	account_id int primary key auto_increment,
    username varchar(255) primary key,
    `password` varchar(100)
);


create table `role`(
	role_id int primary key auto_increment,
	role_name nvarchar(255)
);

create table account_role (
	account_role_id int primary key auto_increment,
    username int,
    role_id int,
    foreign key (username) references `account`(username),
    foreign key (role_id) references `role` (role_id)
);

create table attach_service(
	attach_service_id  int primary key auto_increment,
	attach_service_name nvarchar(255),
	attach_service_image nvarchar(255),
	attach_service_cost double
);

create table service (
	service_id int primary key auto_increment,
	service_name nvarchar(255),
	service_image nvarchar(255),
	service_area int,
	service_cost double,
    service_max_people int,
	service_description nvarchar(255),
	attach_service_id int,
	foreign key (attach_service_id) references attach_service (attach_service_id)
);

create table `user` (
	user_id int primary key auto_increment,
	user_name nvarchar(255),
	user_birthday nvarchar(255),
	user_id_card int,
	user_phone int,
	user_email varchar(255),
	user_address varchar(255),
    username varchar(100), 
	foreign key (username) references `account`(username)
);

create table contract (
	contract_id int primary key auto_increment,
	user_id int,
	service_id int,
	contract_total_money double,
	foreign key (user_id) references `user` (user_id),
	foreign key (service_id) references service(service_id)
);

insert into `account` (username, `password`) values ('minhcanh', '123123'), 
													('hami', '123123');
                                                    
insert into `role` (role_name) values ('ROLE_ADMIN'),
									  ('ROLE_CUSTOMER');
                                      
insert into account_role (account_id, role_id) values (1, 1),
													  (2, 2);

insert into attach_service (attach_service_name, attach_service_image, attach_service_cost) 
values ('Buffet buổi sáng', 'https://www.slagerijveugen.nl/uploads/asset/data/56317/Hapjesbuffet_naturel.jpg', 150000),
	   ('Buffet buổi trưa', 'https://www.lafermedabondance.be/wp-content/uploads/2016/05/restaurant_buffets_a_volonte_30.jpg', 150000),
       ('Buffet buổi tối', 'http://blog-sap.com/analytics/files/2016/10/10.3.buffet.jpg', 200000);
       
                                                                            
insert into service (service_name, service_image, service_area, service_cost, service_description, service_max_people, attach_service_id)
values ('High Camping Package', 'http://cudeecolodge.com/upload/sanpham/69315_530x280.jpg', '10m', 800000, '- Không gian riêng tư
																											- Lều trại: bao gồm: chăn, giường, gối, nệm, quạt,…
																											- Đèn trang trí ngoài trời, ổ cắm điện', '4', '1'),
	   ('Underground Camping Package', 'http://cudeecolodge.com/upload/sanpham/236819_530x280.jpg', '50m', 600000, '- Không gian riêng tư
																													- Lều trại: bao gồm: chăn, giường, gối, nệm, quạt,…
																													- Đèn trang trí ngoài trời, ổ cắm điện', '10', '2'),
	   ('Glamping', 'https://tse1.mm.bing.net/th?id=OIP.H7_KeLzQBjS7EphIwlYR3AHaDt&pid=Api&P=0', '10m', '1000000', '- Không gian riêng tư
																													- Đèn trang trí ngoài trời, ổ cắm điện
																													- Tiện nghi đầy đủ', '6', '3');
                                            
insert into `user` (user_name, user_birthday, user_id_card, user_phone, user_email, user_address, account_id)   
values ('Nguyễn Minh Cảnh', '1992-08-12', '123456789', '0905111111', 'minhcanh@gmail.com', 'Đà Nẵng', 1),                                         
	   ('Đỗ Hà Mi', '1992-05-04', '987654321', '0905222222', 'hami@gmail.com', 'Hà Nội', 2);       
       
insert into contract (user_id, service_id, contract_total_money) values ('1', '1', 950000),
																		('2', '2', 750000);

-- Создать таблицу друзей с использованием механизма валидации данных в SQL

create table friends (
id int primary key auto_increment,
created_at timestamp not null default current_timestamp,
friend1_id int not null,
friend2_id int not null,

foreign key (friend1_id) references users(id),
foreign key (friend2_id) references users(id)
);

-- Добавить в таблицу друзей несколько записей

insert into friends (friend1_id, friend2_id)
values
(1, 3),
(2, 3);

-- Вывести сумму всех транзакций отдельно по каждой валюте (в упорядоченном виде)

SELECT sum(txs.amount) as total_sum,
	accounts.currency as acurrency
FROM txs
join accounts on txs.sender_account_id = accounts.author_id
group by accounts.currency
order by total_sum DESC
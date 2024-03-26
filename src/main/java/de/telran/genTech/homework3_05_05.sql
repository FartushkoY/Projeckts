-- Задача 1.Вывести данные о товарах не из категорий 2 и 4 и не от поставщиков 2 и 3
-- с ценой от 20 до 90 EUR (проекция: название, цена с наценкой_6%)

SELECT
	ProductName,
    Price * 1.06 AS Price_higher_6percent
FROM Products
WHERE
	NOT CategoryID IN (2, 4)
	AND
    NOT SupplierID IN (2, 3)
    AND
    Price BETWEEN 20 AND 90


-- Задача 2. Вывести клиентов не из Germany, имена которых не заканчиваются на букву t

SELECT *
FROM Customers
WHERE
	NOT Country = 'Germany'
    AND
    NOT CustomerName LIKE '%t'


-- Задача 3. Вывести два самых дешевых товара с ценой от 10 EUR и более (проекция: название, цена со скидкой_20%)

SELECT
	ProductName,
    Price*.8 AS Price_discount_20

FROM Products
WHERE
	Price > 10
ORDER BY Price ASC
LIMIT 2
-- Задача 1. Вывести компании-перевозчиков, которые доставили клиентам более 250 заказов (проекция: название_компании, ко-во заказов)
SELECT
	Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders
JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
GROUP BY Orders.ShipperID
HAVING total_orders > 250


-- Задача 2. Вывести заказы, где ко-во товаров 3 и более (проекция: номерзаказа, ко-вотовароввзаказе)

-- если я правильно поняла, что ко-во товаров - это имеется ввиду количество наименований товаров (ProductID),
-- a не quantity
SELECT
	OrderID,
    COUNT(*) AS quantity_products
FROM OrderDetails
GROUP BY OrderID
HAVING quantity_products >=3
ORDER BY quantity_products ASC


-- Задача 3. Вывести минимальную стоимость товара для каждой категории, кроме категории 2 (проекция: названиекатегории, минстоимость_товара)
SELECT
	Categories.CategoryName,
    MIN(Products.Price) AS min_price
FROM Products
JOIN Categories ON Products.CategoryID = Categories.CategoryID
WHERE Products.CategoryID != 2
GROUP BY Products.CategoryID


-- Задача 4. Вывести менеджера, который находится на 4 месте по ко-ву созданных заказов (проекция: фамилияменеджера, к-восозданных_заказов)
SELECT
	Employees.LastName,
    COUNT(OrderID) AS total
FROM Orders
JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
GROUP BY Orders.EmployeeID
ORDER BY total DESC
LIMIT 1 OFFSET 3


-- Задача 5. Вывести данные о товарах от поставщиков 4 и 8 (проекция: всеимеющиесяполя, ценасоскидкой1.5процента, ценаснаценкой0.5процента)
SELECT *,
	Price * .985 AS discount_price,
    Price * 1.005 AS higher_price
FROM Products
WHERE SupplierID IN (4, 8)
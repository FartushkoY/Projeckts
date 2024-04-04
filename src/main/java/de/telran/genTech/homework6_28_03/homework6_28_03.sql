-- Задача 1. Вывести стоимость заказа 10258

SELECT
	SUM(OrderDetails.Quantity * Products.Price) AS total_order_10258
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID
WHERE OrderDetails.OrderID = 10258

-- Задача 2. Вывести кол/распределение заказов по клиентам (проекция: имяклиента, ко-возаказов)

SELECT
    CustomerName,
    COUNT(OrderID) AS number_of_orders
FROM Orders

JOIN 	Customers ON Orders.CustomerID	= Customers.CustomerID
GROUP BY Orders.CustomerID

-- Задача 3. Вывести кол/распределение заказов по менеджерам (проекция: фамилияменеджера, ко-возаказов)

SELECT
Employees.LastName,
COUNT(Orders.EmployeeID) AS total_manager_orders
FROM Orders

JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
GROUP BY Orders.EmployeeID

-- Задача 4. Вывести минимальную стоимость товаров для каждой категории
-- (проекция: названиекатегории, минстоимость_товаров)

SELECT
	Categories.CategoryName,
    MIN(Products.Price)
FROM Products

JOIN Categories ON Products.CategoryID = Categories.CategoryID
GROUP BY Products.CategoryID

-- Задача 5. Вывести данные о заказах (проекция: номерзаказа, стоимостьзаказа)

SELECT
	OrderDetails.OrderID,
	SUM(OrderDetails.Quantity * Products.Price) AS orders_sum
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID
GROUP BY OrderDetails.OrderID

-- Задача 6. Вывести доход каждого менеджера за весь период,
-- исходя из ставки в 5% от суммы его заказов (проекция: фамилия_менеджера, доход)

SELECT
	Employees.LastName,
	SUM(OrderDetails.Quantity * Products.Price) * .05 AS managers_income
FROM OrderDetails
JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
JOIN Products ON OrderDetails.ProductID = Products.ProductID
GROUP BY Employees.EmployeeID


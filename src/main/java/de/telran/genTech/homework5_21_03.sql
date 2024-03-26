-- Задача 1. Вывести ко-во поставщиков не из UK и не из China

SELECT
COUNT(*) AS Suppliers_quantity
FROM Suppliers
WHERE
	NOT Country IN ('UK', 'China')

-- Задача 2. Вывести среднюю/MAX/MIN стоимости и ко-во товаров из категорий 3 и 5

SELECT
	MAX(Price) AS Max_price,
    MIN(Price) AS Min_price,
    AVG(Price) AS Avg_price
FROM Products
WHERE
	CategoryID IN (3, 5)

-- Задача 3. Вывести общую сумму проданных товаров

SELECT
SUM(Quantity * Price) AS Amount_sold
FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID

-- Задача 4. Вывести данные о заказах (номерзаказа, имяклиента,
--странаклиента, фамилияменеджера, названиекомпанииперевозчика)

SELECT
	Orders.OrderID AS Order_numer,
	Customers.CustomerName AS Customer_name,
    Customers.Country AS Customer_country,
    Employees.LastName AS Manager_last_name,
	Shippers.ShipperName AS Shipper
FROM Orders
JOIN Customers ON Orders.CustomerID = Customers.CustomerID
JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID

-- Задача 5. Вывести сумму, на которую было отправлено товаров клиентам в Germany

SELECT
SUM(OrderDetails.Quantity * Products.Price) AS Sales_to_Germany
FROM OrderDetails
JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
JOIN Products ON OrderDetails.ProductID = Products.ProductID
JOIN Customers ON Orders.CustomerID = Customers.CustomerID
WHERE Customers.Country = 'Germany'
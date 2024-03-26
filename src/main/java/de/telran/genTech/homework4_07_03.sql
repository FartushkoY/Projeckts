-- Задача 1. Вывести данные о товарах (проекция: название товара, цена, название категории, название компании поставщика)

SELECT
	Products.ProductName,
    Products.Price,
    Categories.CategoryName,
    Suppliers.SupplierName

FROM Products

JOIN Categories ON Products.CategoryID = Categories.CategoryID
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID


-- Задача 2. Вывести заказы клиентов не из France  (номерзаказа, имя клиента, страна_клиента)

SELECT
	Orders.OrderID,
    Customers.CustomerName,
    Customers.Country
FROM Orders

JOIN Customers ON Orders.CustomerID = Customers.CustomerID

WHERE
	NOT Customers.Country = 'France'


-- Задача 3. Вывести название и стоимость в USD одного самого дорогого проданного товара

-- ?? Нужно ли здесь использовать SELECT DISTINCT или SELECT достаточно?
-- На промежуточном этапе, до уточнения проекции с SELECT DISTINCT нагляднее и понятнее
SELECT DISTINCT
	Products.ProductName,
    Products.Price * 1.09 AS Price_USD
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID
ORDER BY Products.Price DESC
LIMIT 1


-- Задача 4. Вывести список стран, которые поставляют морепродукты

SELECT DISTINCT
	Suppliers.Country AS Seafood_comes_from
FROM Products

JOIN Categories ON Products.CategoryID = Categories.CategoryID
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID

WHERE
	Categories.CategoryName = 'Seafood'


-- Задача 5. Вывести два самых дорогих товара из категории Beverages из USA

-- результат получается с погрешностью, т к всего 3 товара, и цена 2х более дешевых одинакова.
-- Полагаю, должны быть варианты решения такой ситуации?

SELECT *
FROM Products

JOIN Categories ON Products.CategoryID = Categories.CategoryID
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID

WHERE
	Suppliers.Country = 'USA'
    AND
    Categories.CategoryName = 'Beverages'

ORDER BY Products.Price DESC
LIMIT 2



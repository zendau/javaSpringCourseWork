-- №1
-- Получение названия товара и его цены
SELECT g.name, s1.price FROM goods g INNER JOIN storage s ON g.storageID = s.id INNER JOIN stockcontrolcard s1 ON s.SccId = s1.id

-- №2
-- Получение названия товара, поставщика и цены по накладной
SELECT g.name AS 'Товар', p.name AS 'Поставщик', w.price AS 'Цена' FROM goods g INNER JOIN waybill w ON g.id = w.itemId INNER JOIN providers p ON w.id = p.waybillId

-- №3
-- Получение названия товара и курьера
SELECT g.name, w.name FROM goods g INNER JOIN sales s ON g.id = s.itemId INNER JOIN workers w ON s.courier = w.workerId

-- №4
-- Получение самой минимальной и самой максимальной зарплаты сотрудников
SELECT MIN(w.salary), MAX(w.salary) FROM workers w

-- №5
-- Получение общего количества товаров на складе и общей стоимости товаров на складе
SELECT COUNT(s.id), SUM(s.price) FROM stockcontrolcard s

-- №6
-- Получение имени работников и их долженности у которых зарплата больше 5000
SELECT w.name, r.role, w.salary  FROM workers w INNER JOIN roles r ON w.role = r.role  WHERE w.salary > 5000

-- №7
-- Получение id, цены и места товаров на складе который ещё остались
SELECT s.id, s.price, s.place FROM stockcontrolcard s WHERE s.issueDate IS NULL

-- №8
-- Получение id, ценый, места на складе и имени товара которые были проданы
SELECT s.id, s.price, s.place, g.name FROM stockcontrolcard s INNER JOIN waybill w ON s.id = w.SccId INNER JOIN goods g ON w.itemId = g.id WHERE s.issueDate IS NOT NULL

-- №9
-- Получение имени товара которое начинается на ключевое слово и его категории
SELECT g.name, c.name FROM sales s INNER JOIN goods g ON s.itemId = g.id INNER JOIN categories c ON g.category = c.name WHERE g.name LIKE 'xiaomi%'

-- №10
-- Получение названия товара и цены. Цена находится в диапозоне 2000 и 5000. Сортировка от меньшего к большему
SELECT g.name, s2.price FROM sales s INNER JOIN goods g ON s.itemId = g.id INNER JOIN storage s1 ON g.storageID = s1.id INNER JOIN stockcontrolcard s2 ON s1.SccId = s2.id WHERE s2.price BETWEEN 2000 AND 5000 ORDER BY s2.price
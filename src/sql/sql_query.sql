-- 1) 3rd highest salary employee.
  SELECT * from (
	SELECT *,
               DENSE_RANK() OVER (
                   ORDER BY age DESC
               ) AS rnk
        FROM Customers
) t
where rnk = 3

-- 2) 3rd Highest Age Customer by Country
SELECT *
FROM (
    SELECT *,
           DENSE_RANK() OVER (
               PARTITION BY country
               ORDER BY age DESC
           ) AS rnk
    FROM Customers
) t
WHERE rnk = 3;

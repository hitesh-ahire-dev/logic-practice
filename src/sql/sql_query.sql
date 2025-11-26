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

-- 3) 3rd Highest Salary Employee by Department
  SELECT emp_id, emp_name, salary, dept_name
  FROM (
      SELECT e.emp_id,
             e.emp_name,
             e.salary,
             d.dept_name,
             DENSE_RANK() OVER (PARTITION BY e.dept_id ORDER BY e.salary DESC) AS rnk
      FROM employee e
      JOIN department d
        ON e.dept_id = d.dept_id
  ) t
  WHERE rnk = 3;

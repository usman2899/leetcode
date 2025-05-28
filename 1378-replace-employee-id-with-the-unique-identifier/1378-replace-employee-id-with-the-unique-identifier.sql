-- Write your PostgreSQL query statement below
SELECT emp_uni.unique_id, emp.name from EmployeeUNI emp_uni right join Employees emp on emp.id = emp_uni.id
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    WITH
      RankedEmployees AS (
        SELECT *, DENSE_RANK() OVER(ORDER BY salary DESC) AS `rank`
        FROM Employee
      )
    S
END
# Write your MySQL query statement below
WITH TotalUsers AS (
    SELECT COUNT(*) AS total FROM Users
)
SELECT 
    r.contest_id, 
    ROUND((COUNT(r.user_id) * 100.0) / t.total, 2) AS percentage
FROM Register r
CROSS JOIN TotalUsers t
GROUP BY r.contest_id, t.total
ORDER BY percentage DESC, contest_id ASC;

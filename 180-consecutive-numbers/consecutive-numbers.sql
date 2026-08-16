# Write your MySQL query statement below
select distinct b.num as ConsecutiveNums 
From Logs a join Logs b on b.id = a.id + 1
join Logs c on c.id = b.id + 1 
where a.num = b. num and b.num = c.num;
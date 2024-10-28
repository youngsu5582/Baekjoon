-- 코드를 작성해주세요

select CONVERT(diff_date,SIGNED) as YEAR,b.diff_max - size_of_colony as YEAR_DEV,ID
from ecoli_data a
join (
    SELECT MAX(SIZE_OF_COLONY) AS diff_max,
           DATE_FORMAT(DIFFERENTIATION_DATE, '%Y') AS diff_date
    FROM ecoli_data
    GROUP BY DATE_FORMAT(DIFFERENTIATION_DATE, '%Y')
) AS b
on DATE_FORMAT(a.DIFFERENTIATION_DATE,'%Y') = b.diff_date
ORDER BY YEAR ASC,YEAR_DEV ASC;
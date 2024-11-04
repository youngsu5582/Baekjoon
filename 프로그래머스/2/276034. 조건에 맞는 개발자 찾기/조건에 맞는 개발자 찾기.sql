-- 코드를 작성해주세요
select DISTINCT(ID),EMAIL,FIRST_NAME,LAST_NAME
from developers
join skillcodes
on skillcodes.code & developers.SKILL_CODE
where skillcodes.NAME = 'Python' or skillcodes.NAME = 'C#'
ORDER BY ID ASC;


# 256 ?
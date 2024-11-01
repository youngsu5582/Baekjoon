-- 코드를 작성해주세요
select id as ID ,ft.fish_name as FISH_NAME ,ft.max_length as LENGTH
from fish_info as fi
join (select fni.fish_type as fish_type ,fni.fish_name as fish_name ,max(fi.length) as max_length
from fish_info as fi
join fish_name_info as fni
on fi.fish_type = fni.fish_type
group by fni.fish_type,fni.fish_name) as ft
where fi.length = ft.max_length and ft.fish_type = fi.fish_type
ORDER BY id asc;

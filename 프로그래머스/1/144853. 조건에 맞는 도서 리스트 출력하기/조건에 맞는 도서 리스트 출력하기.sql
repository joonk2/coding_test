# 선택할 것
# BOOK_ID, PUBLISHED_DATE

# 조건
# - 인문, 출판일 asc

select BOOK_ID, PUBLISHED_DATE
from BOOK
where CATEGORY = '인문' and PUBLISHED_DATE like '2021%'
order by PUBLISHED_DATE asc;


select a.REST_ID, b.REST_NAME, b.FOOD_TYPE, b.FAVORITES, b.ADDRESS, round(avg(a.REVIEW_SCORE), 2) as SCORE
from REST_REVIEW a
join REST_INFO b on a.REST_ID = b.REST_ID
group by a.REST_ID
having b.ADDRESS like '서울%'
order by SCORE desc, b.FAVORITES desc;
# SELECT CAR_TYPE, COUNT(*) AS CARS
# FROM CAR_RENTAL_COMPANY_CAR
# WHERE OPTIONS LIKE '%통풍시트%'
#    OR OPTIONS LIKE '%열선시트%'
#    OR OPTIONS LIKE '%가죽시트%'
# GROUP BY CAR_TYPE
# ORDER BY CAR_TYPE;


select CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like "%통풍시트%" or OPTIONS like "%열선시트%" or OPTIONS like "%가죽시트%"
group by CAR_TYPE
order by CAR_TYPE;












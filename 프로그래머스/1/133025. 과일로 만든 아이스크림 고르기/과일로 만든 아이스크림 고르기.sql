# a, b 테이블
# FLAVOR 겹치는 컬럼

# 조건
# - 총 주문량 > 3000
# - 주성분 : 과일

# 최종적으로 예제실행 결과랑 내결과값 대조

select a.FLAVOR
from FIRST_HALF as a
left join ICECREAM_INFO as b
on a.FLAVOR = b.FLAVOR
where a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE like 'fruit_based'
order by a.TOTAL_ORDER desc;

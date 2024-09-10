
select a.FlAVOR FROM FIRST_HALF AS a
LEFT JOIN ICECREAM_INFO AS b
ON a.FLAVOR = b.FLAVOR
WHERE a.TOTAL_ORDER > 3000 AND b.INGREDIENT_TYPE LIKE 'fruit_based'
order by a.TOTAL_ORDER DESC;

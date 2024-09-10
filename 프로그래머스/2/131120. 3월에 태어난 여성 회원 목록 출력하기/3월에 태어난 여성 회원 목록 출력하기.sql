select MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
from MEMBER_PROFILE
where month(DATE_OF_BIRTH)=3 and GENDER = 'W' AND TLNO is not null
order by MEMBER_ID;
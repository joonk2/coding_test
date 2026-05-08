select c.ITEM_ID, c.ITEM_NAME, c.RARITY
from ITEM_INFO a

join ITEM_TREE b
on a.ITEM_ID = b.PARENT_ITEM_ID

join ITEM_INFO c
on c.ITEM_ID = b.ITEM_ID

where a.rarity = "RARE"
order by c.ITEM_ID desc;
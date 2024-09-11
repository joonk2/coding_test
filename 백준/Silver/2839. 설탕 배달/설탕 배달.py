# 설탕 배달 5 kg or 3 kg
# if 18kg --> 4봉지 5kg*3 + 3kg*1
# 설탕은 3KG 이상
# 3KG 미만이면 -1 반환


sugar = int(input())
bag = 0
while sugar >= 0:
  if sugar % 5 == 0:
    bag += (sugar // 5)
    print(bag)
    break
  
  sugar -= 3
  bag += 1

if sugar < 0:
  print(-1)

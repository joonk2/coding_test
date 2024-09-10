# 4//5 = 몫 0
# 4 % 5 = 나머지 4 
# break문이 실행 or 음수가 되서 더이상 뺄게 없다면 해당 while 루프 종료

sugar = int(input())
bag = 0

while sugar >= 0:
  if sugar % 5 == 0:
    bag += (sugar//5)
    print(bag)
    break

  sugar -= 3
  bag += 1

if sugar < 0:
  print(-1)

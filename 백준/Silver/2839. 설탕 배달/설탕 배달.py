sugar = int(input())
bag = 0

while sugar > 0:
  if sugar % 5 == 0:
    bag += (sugar // 5)
    print(bag)
    break

  sugar -= 3
  bag += 1

  if sugar == 0:
    print(bag)
    break
    
  elif sugar < 3:
    print(-1) 
    break

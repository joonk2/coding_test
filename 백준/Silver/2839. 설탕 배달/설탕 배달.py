# sugar % 5  --> 나머지가 0이면 가방갯수 세고 몫인 sugar // 5 만큼 가방갯수를 bag에 저장
# sugar가 0이상일 때 까지는 5로 나눠지지 않는다면 3kg 차감을 통해 가방 갯수 가산(5의 배수가 될 때까지 반복수행)
# sugar가 음수가 되는 순간부터 -1 반환

sugar = int(input())
bag = 0
while sugar >= 0:
  if sugar % 5 == 0:
    bag += (sugar // 5)
    print(bag)
    break
  
  sugar -= 3
  bag += 1

if sugar < 0 :
  print(-1)

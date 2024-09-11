# 설탕 배달 5kg or 3kg
# if 18kg --> 4봉지 5kg*3 + 3kg*1
# 입력 설탕은 3kg 이상
# 더 이상 설탕을 봉지에 담을 수 없을 때 -1

# option 1) 양수일 때만 담을 수 있으며 5로 나눠질 때 가방 수 몫만큼
# option 2)   // 5로 나눠지지 않는다면 3만큼 빼주고 가방수 채우자
# option 3) 그리고 다시 option 1,2를 반복하다가 음수가 된다면 -1로 반환

N = int(input())
bag = 0
while N >= 0:
  if N % 5 == 0:
    bag += (N // 5)
    print(bag)
    break

  N -= 3
  bag += 1

if N < 0:
  print(-1)

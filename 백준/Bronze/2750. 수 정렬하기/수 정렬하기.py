# 중복은 112 이렇게 적을 때 해당되고 한 줄로 적을 때는 중복된게 있어도 중복된게 아니다

N = int(input())
box = []

for i in range(N):
  box.append(int(input()))

answer = sorted(box, reverse=False)
for a in answer:
  print(a)
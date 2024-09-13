# A*B*C를 한 값에서 0부터 9까지 각각의 숫자가 몇번 쓰였는지 계산한다

A = int(input())
B = int(input())
C = int(input())

100 <= A < 1000 and 100 <= B < 1000 and 100 <= C < 1000
answer = str(A*B*C)
for i in range(10):
  print(answer.count(str(i)))

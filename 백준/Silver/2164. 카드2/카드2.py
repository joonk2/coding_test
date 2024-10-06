# 문제 풀기 전 필요할 만한 것들
# 1. queue가 필요할 듯?
# 2. 조건이 있는 무한 루프


import sys 
from collections import deque
input = sys.stdin.readline

N = int(input())
q = deque([])

for i in range(1, N+1):
    q.append(i)

# print(q)     디버깅 ㅇㅋ --> 1,2,3,4,5,6 잘 들어간거 확인함

# 맨앞꺼 빼고 그다음꺼를 맨뒤로 넘기네
# 4가 나오려면 덱 길이 1개니까 전체길이가 2일떄까지만 반복진행하면되나?
while len(q) >= 2:
    q.popleft()
    q.append(q.popleft())

print(q[0])
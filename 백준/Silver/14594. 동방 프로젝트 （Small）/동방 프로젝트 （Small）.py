# 맨 왼쪽과 오른쪽 벽은 허물지 않는다. --> 즉 건물 외벽과 연결된 벽은 안 부숴
# 아래는 동방이 5개일때 연결된 벽($) 과 방(ㅁ)의 예시다

#   |ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ |
#   |                       |
#   $ ㅁ $ ㅁ $ ㅁ $ ㅁ $ ㅁ $ 
#   |                       |
#   |ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ |

import sys
input = sys.stdin.readline

N = int(input())  # 방의 개수
M = int(input())  # 빌런의 행동 횟수

# 초기 설정은 벽이 전부 연결이 안된 것으로 ㄱㄱ
wall = [1] * (N + 1)  

for _ in range(M):
    x, y = map(int, input().split())
    # 벽을 허물면서 방의 상태를 변경
    for j in range(x, y):
        wall[j] = 0  


# 방 갯수 cnt
cnt = 0
for d in range(1, N + 1):
    if wall[d] == 1:
        cnt += 1

print(cnt)  

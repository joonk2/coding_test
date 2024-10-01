# 1번 컴터랑 연결된 컴터들이 바이러스에 걸려서 총4대 도루묵
# 컴퓨터 갯수에 따른 위치 배치 --> 우린 보통 인덱스 1~7을 사용하지 인덱스 0은 버리걸랑
# 연결된 링크는 6개  (출발 s -> 끝 e      끝 e -> 출발 s)
# 연결된 링크 --> 마치 인접행렬?

# 첫 위치를 방문표시하고 바로 시작한다

# 2. dfs
def dfs(c):
    global ans
    ans += 1

    v[c] = 1

    for n in adj[c]:
        if not v[n]:
            dfs(n)

# 1.입출력 셋팅
import sys
input = sys.stdin.readline
N= int(input())
M = int(input())

# 컴퓨터 세팅 --> 인덱스 0~7, 근데 실제로는 1~7만 필요
# 링크 방문 노드 세팅
adj = [ [] for _ in range(N+1)]
v = [0] * (N+1)

for _ in range(M):
    s, e = list(map(int, input().split()))
    adj[s].append(e)
    adj[e].append(s)


ans = 0
dfs(1)
print(ans-1)

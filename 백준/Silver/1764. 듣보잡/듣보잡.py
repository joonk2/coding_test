# 1. 입출력 예제를 보면 알 수 있는데 듣지도 보지도 못한 놈 중복되면 당첨이다 이말이다
# 2. 듣보잡의 수와 그 명단을 사전순으로 출력한다.
N, M = list(map(int, input().split()))

a = set()
for i in range(N):
    a.add(input())

b = set()
for j in range(M):
    b.add(input())

res = sorted(list(a&b))  # 같은말이다  $$ a \cap b $$

print(len(res))
for r in res:
    print(r)
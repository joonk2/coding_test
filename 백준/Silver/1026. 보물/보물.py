# B의 큰 값들을 A의 최소값이랑 곱해주고 B의 큰 값 순서대로
# 제거하면서 결국 최소값의 합으로 만든다가 핵심이군

def converter(N, A, B):
    A.sort()

    sum = 0

    for i in range(N):
        x = A[i]
        y = max(B)
        B.remove(y)

        sum += x*y

    return sum


N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

ans = converter(N, A, B)
print(ans)
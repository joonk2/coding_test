

import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    dp_0 = [0] * 41
    dp_1 = [0] * 41

    dp_0[0] = 1
    dp_1[1] = 1

    N = int(input())

    for j in range(2, N+1):
        dp_0[j] = dp_0[j-1] + dp_0[j-2]
        dp_1[j] = dp_1[j-1] + dp_1[j-2]
    
    print(dp_0[N], dp_1[N])
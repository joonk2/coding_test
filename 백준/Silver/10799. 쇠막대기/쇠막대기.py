# https://hgk5722.tistory.com/48

import sys
input = sys.stdin.readline
s = input()
stack = []
cnt = 0

for i in range(len(s)):
    if s[i] == '(':
        stack.append(s[i])
    elif s[i] == ')':
        if s[i-1] == '(':
            cnt += len(stack)-1
            stack.pop()
        elif s[i-1] == ')':
            cnt += 1
            stack.pop()
print(cnt)

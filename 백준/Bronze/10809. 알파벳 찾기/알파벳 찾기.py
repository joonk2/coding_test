# 입력 단어에 대해서 각 알파벳이 나오는 위치순서를 인덱스로 매겨라, 없는 것은 -1 반환

import sys
input = sys.stdin.readline
S = input()
alphabet ='abcdefghijklmnopqrstuvwxyz'

for i in alphabet:
    if i in S:
        print(S.index(i), end=' ')
    else:
        print(-1, end=' ')

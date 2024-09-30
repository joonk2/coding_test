word = input()

dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
cnt = 0

for w in word:
    for i in dial:
        if w in i:
            cnt += dial.index(i) + 3

print(cnt)
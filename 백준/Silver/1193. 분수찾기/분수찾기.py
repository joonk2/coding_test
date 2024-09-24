# 1/1
# 1/2, 2/1
# 3/1, 2/2, 1/3
# 1/4, 2/3, 3/2, 4/1
# 5/1, 4/2, 3/3, 2/4, 1/5


X = int(input())
line = 1  
while X > line:
    X -= line  
    line += 1  

if line % 2 == 0:
    top = X
    bottom = line - X + 1
else:
    top = line - X + 1
    bottom = X

print(f'{top}/{bottom}')
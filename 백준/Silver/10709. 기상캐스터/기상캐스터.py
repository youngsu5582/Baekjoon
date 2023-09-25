n,m = map(int,input().split())
ary = [None] * n
for i in range(n):
    ary[i] = [-1] * m
for i in range(n):
    temp = input()
    for index,element in enumerate(temp):
        if element == 'c':
            ary[i][index] = 0
for i in range(n):
    for j in range(m):
        if ary[i][j]==0:
            continue
        elif ary[i][j] ==-1 and ary[i][j-1] != -1 and j-1>=0:
            ary[i][j] =ary[i][j-1] +1
        else:
            if ary[i][j]> ary[i][j-1]+1:
                ary[i][j] = ary[i][j-1]+1

for element in ary:
    for e in element:
        print(e,end=" ")
    print()


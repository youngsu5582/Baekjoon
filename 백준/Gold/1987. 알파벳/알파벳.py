from sys import stdin

input = stdin.readline

r,c = map(int,input().split())

ary = []


for _ in range(r):
    ary.append(list(input().strip()))
for i in range(r):
    for j in range(c):
        ary[i][j] = ord(ary[i][j]) -65

direction_x = [-1,1,0,0]
direction_y = [0,0,-1,1]



max_ary = [0]
def dfs(x,y,cnt):
    if(max_ary[-1]<cnt):
        max_ary[-1]=cnt
    index = ary[x][y]
    dct[index]=False
    for i in range(4):
        next_x = direction_x[i]+x
        next_y = direction_y[i]+y
        if 0<=next_x<r and 0<=next_y<c:
            element = ary[next_x][next_y]
            if dct[element]:
                dfs(next_x,next_y,cnt+1)
    dct[index]=True
dct = [True]*26
cnt = 0
dfs(0,0,cnt)
print(max_ary[0]+1)
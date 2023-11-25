import sys

input = sys.stdin.readline


n,m = map(int,input().split())
ary = []
direction_y = [-1,0,1]

# 좌표 , 점수 , 이전

for _ in range(n):
    ary.append(list(map(int,input().split())))

res = 10000
def dfs(x,y,point,prev):
    global res
    if x==n:
        res = min(res,point)
        return
    point +=ary[x][y]
    for j in range(3):
        if j ==prev:
            continue
        next_y = y+direction_y[j]
        if 0<=next_y<m:
            dfs(x+1,next_y,point,j)

for i in range(m):
    for j in range(3):
        dfs(0,i,0,j)

print(res)
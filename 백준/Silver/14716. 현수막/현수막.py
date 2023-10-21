from sys import stdin
from sys import setrecursionlimit

setrecursionlimit(10 ** 9)
input = stdin.readline
ary = []

n,m = map(int,input().split())
direction_x = [-1,-1,0,1,1,1,0,-1]
direction_y = [0,1,1,1,0,-1,-1,-1]



for _ in range(n):
    ary.append(list(map(int,input().split())))
visited = [[False]*m for _ in range(n)]
count = 0
def dfs(x,y):
    for i in range(8):
        next_x = x+direction_x[i]
        next_y = y+direction_y[i]
        if 0<= next_x <n and 0<=next_y < m:
            if ary[next_x][next_y] ==1 and visited[next_x][next_y] is False:
                visited[next_x][next_y]=True
                dfs(next_x,next_y)
    return
for i in range (n):
    for j in range(m):
        if ary[i][j]==0:
            continue
        if visited[i][j]==True:
            continue
        count+=1
        visited[i][j]=True
        dfs(i,j)


print(count) 
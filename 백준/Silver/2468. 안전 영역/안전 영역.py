import sys
n = int(input())
ary = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
min = 101
sys.setrecursionlimit(15000)
for i in ary:
    for j in i:
        if min>j:
            min = j
max_result = 0
def dfs(x,y,min):
    if x == -1 or y == -1 or x ==len(ary) or y==len(ary):
        return
    if ary[x][y] -min<=0:
        return
    if visited[x][y] == True:
        return
    visited[x][y] = True
    dfs(x-1,y,min)
    dfs(x+1,y,min)
    dfs(x,y+1,min)
    dfs(x,y-1,min)
min = 0
while True:
    count = 0
    visited = [[False for j in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == False and ary[i][j]-min>0:
                
                dfs(i,j,min)
                count +=1
    if(count == 0):
        break
    if count>max_result:
        max_result = count
    min +=1


print(max_result)

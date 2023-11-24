from sys import stdin
input = stdin.readline

n = int(input())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))



lt = [i for i in range(n//2)]


visited = [False for _ in range(n)]
res = 20*20*100
def dfs(x,y):
    global res
    if x == n//2:
        A = 0
        B = 0
        for i in range(n):
            for j in range(n):
                if visited[j] and visited[i]:
                 A+=ary[i][j]
                if not visited[i] and not visited[j]:
                 B+=ary[i][j]
            
        res = min(res,abs(A-B))
        return
    for i in range(y,n):
        visited[i]=True
        dfs(x+1,i+1)
        visited[i]=False
    pass


dfs(0,0)

print(res)
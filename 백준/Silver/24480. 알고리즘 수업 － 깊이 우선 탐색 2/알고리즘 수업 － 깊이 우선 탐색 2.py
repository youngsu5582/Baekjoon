import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n,m,r = map(int,input().split())
ary = [[] for _ in range(n+1)]
for _ in range(m):
    x,y = map(int,input().split())
    ary[x].append(y)
    ary[y].append(x)

for element in ary:
    element.sort(reverse=True)

visited = [0]*(n+1)
count = 1
def dfs(r):
    global count
    visited[r]=count
    count+=1
    for element in ary[r]:
        if visited[element]!=0:
            continue
        dfs(element)

dfs(r)
for index in range(1,n+1):
    print(visited[index])

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

n = int(input())
graph = [ [] for _ in range(n+1)]

for _ in range(n-1):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)


visited = [False] * (n+1)

def dfs(pos,count):
    if pos!=1 and len(graph[pos])==1:
        return count
    result = 0
    for element in graph[pos]:
        if visited[element] is False:
            visited[element]= True
            result += dfs(element,count+1)
    return result


visited[1]=True
result =dfs(1,0)
if result % 2==0:
    print("No")
else:
    print("Yes")

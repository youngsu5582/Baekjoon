import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n):
    temp = list(map(int,input().split()))
    index = temp.pop(0)
    for i in range((len(temp))//2):
        v,e = temp[i*2],temp[i*2+1]
        graph[index].append((v,e))
        graph[v].append((index,e))


def bfs(start):
    visited = [-1] *(n+1)
    max_graph = [0,0]
    queue = []
    queue.append(start)
    visited[start] = 0

    while queue:
        element = queue.pop(0)
        for v,e in graph[element]:
            if visited[v] ==-1:
                visited[v] = visited[element] + e
                queue.append(v)
                if max_graph[0]<visited[v]:
                    max_graph = visited[v],v

    return max_graph


distance,index = bfs(1)
result = bfs(index)
print(result[0])
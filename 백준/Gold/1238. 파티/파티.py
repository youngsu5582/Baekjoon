import sys
input = sys.stdin.readline
import heapq


n,m,x = map(int,input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s,e,t = map(int,input().split())
    graph[s].append((e,t))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for path,c in graph[now]:
            cost = dist +c
            if cost< distance[path]:
                distance[path] = cost
                heapq.heappush(q,(cost,path))
go_ary = [0]*(n+1)
for i in range(1,n+1):
    if i==x:
        continue
    distance = [float('inf')] * (n + 1)
    dijkstra(i)
    go_ary[i]=distance[x]
    

distance = [float('inf')] * (n + 1)
dijkstra(x)
back_ary = distance

result = 0
for index in range(1,n+1):
    if result < go_ary[index]+back_ary[index]:
        result = go_ary[index]+back_ary[index]
print(result)

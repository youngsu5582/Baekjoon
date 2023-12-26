import sys
input = sys.stdin.readline

V,E = map(int,input().split())
k = int(input())

ary = [[] for _ in range(V+1)]

for _ in range(E):
    u,v,w = map(int,input().split())
    ary[u].append((v,w))

visited = [False] * (V+1)
visited[k] = True
visited[0]= True
min_path = [float('inf') for _ in range (V+1)]

def find_min():
    min_index = 0
    for i in range(1,V+1):
        if visited[i] is False and min_path[i]<min_path[min_index]:
            min_index = i
    return min_index
for vertex,cost in ary[k]:
    min_path[vertex] = min(min_path[vertex],cost)

while True:
    index = find_min()
    if index == 0:
        break
    for vertex,cost in ary[index]:
        min_path[vertex] = min(min_path[vertex],min_path[index] + cost)
    visited[index] = True

min_path[k] = 0
for index in range(1,V+1):
    element = min_path[index]
    if element is float('inf'):
        print('INF')
    else:
        print(element)

from sys import stdin
from collections import deque
input = stdin.readline

n , m = map(int,input().split())
s , e = map(int,input().split())
telpo = [{} for _ in range(n+1)] 
for _ in range(m):
    x,y = map(int,input().split())
    telpo[x][y]=True
    telpo[y][x]= True

visited = [False] * (n+1)

queue = deque([])
queue.append(s)
count = -1
while queue:
    count +=1
    for _ in range(len(queue)):
        element = queue.popleft()
        if element == e:
            print(count)
            exit(0)
        if 1<= element <= n:
            if not visited[element]:
                visited[element]=True
                queue.append(element+1)
                queue.append(element-1)
                for next in telpo[element].keys():
                        queue.append(next)

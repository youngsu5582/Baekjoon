from sys import stdin
from collections import deque

input = stdin.readline

n= int(input())
m = int(input())

ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

plans = list(map(int,input().split()))

queue = deque([])
for i in range(n):
    ary[i][i]=1

for plan_index in range(1,len(plans)):
    queue.append(plans[plan_index-1]-1)
    visited = [False]*n
    sw = False
    while queue and  sw is False:
        
        element = queue.popleft()
        for index,city in enumerate(ary[element]):
            if index == plans[plan_index]-1 and city==1:
                sw = True
                break
            if city==1 and visited[index] is False:
                visited[index]=True
                queue.append(index)
    if sw:
        queue.clear()   
        continue
    print("NO")
    exit(0)


print("YES")

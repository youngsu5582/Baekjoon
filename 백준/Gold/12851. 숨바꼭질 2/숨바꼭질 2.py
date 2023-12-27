import sys
input = sys.stdin.readline
from collections import deque


n,k = map(int,input().split())
index = max(n,k)*2 +1
visited = [False] * index
max_ary = [float('inf')]
min_element = max_ary[-1]
min_count = 0
def bfs():
    if n==k:
        return 0,1
    queue = deque([n])
    count = 0
    min_element = float('inf')
    visited[n]= True
    min_count = 0
    while queue:
        if count>min_element:
            return min_element,min_count
        size = len(queue)
        for _ in range(size):
            element = queue.popleft()
            if element == k:
                min_element = count
                min_count +=1
                continue
            visited[element]= True
            if 0<=element-1 and visited[element-1] is False:
                queue.append(element-1)
            if element+1 < index and visited[element+1] is False:
                queue.append(element+1)
            if element*2 < index and visited[element*2] is False:
                queue.append(element*2)
        count +=1
    return min_element,min_count


    
min_element , min_count = bfs()
print(min_element)
print(min_count)
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

j,k = map(int,input().split())
max_number = max(j,k)*2+1
visited = [False]*(max_number)
max_count = 1000001

def bfs(n):
    queue = [n]
    count = 0
    visited[n]=True
    while queue:
        size =len(queue)
        for _ in range(size):
            element = queue.pop(0)
            if element==k:
                print(count)
                exit(0)
            if element-1>=0 and visited[element-1]==False:
                visited[element-1]=True
                queue.append(element-1)
            if element+1<=k and visited[element+1]==False:
                visited[element+1]=True
                queue.append(element+1)
            if element*2<=max_number and visited[element*2]==False:
                visited[element*2]=True
                queue.append(element*2)
        count+=1
def solution(j,k):
    global max_count
    if j>k:
        print(j-k)
    else:
        bfs(j)
solution(j,k)
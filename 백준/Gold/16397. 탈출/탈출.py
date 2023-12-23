import sys
input = sys.stdin.readline
n,t,g = map(int,input().split())

min_num = float('inf')
visited = [False] * 100000

def parse(n):
    temp = n
    num = 1
    while n>=10:
        n//=10
        num *=10
    return temp-num

def bfs(n):
    count = 0
    queue = []
    queue.append(n+1)
    if 0<n<50000:
        queue.append(parse(n*2))
    if n==g:
        return count    
    while queue:
        count+=1
        size = len(queue)

        for _ in range(size):

            element = queue.pop(0)
            if element==0:
                continue
            if element==g:
                return count
            
            if element<99999:
                if visited[element+1] is False:
                    visited[element+1]= True
                    queue.append(element+1)

            if 0<element<50000:
                temp = parse(element*2)
                if visited[temp] is False:
                    visited[temp] = True
                    queue.append(temp)
        if(count==t):
            return float('inf')
    return float('inf')

element = bfs(n)
if element == float('inf'):
    print("ANG")
else:
    print(element)
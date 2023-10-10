
import sys
sys.setrecursionlimit(10**6)
a,b,c,d = map(int,input().split())

visited = [None] * (a+1)
for i in range(a+1):
    visited[i] = {}

min_stack = []
min_stack.append(float('inf'))
def dfs(x,y,count):
    if x == c and y == d :
        if min_stack[-1]>count:
            min_stack.append(count)
        return
    if min_stack[-1]<=count:
        return
    
    if y in visited[x] and visited[x][y]<=count:
        return
    visited[x][y] = count
    count +=1
    dfs (x,0,count)
    dfs (0,y,count)
    dfs (x,b,count)
    dfs (a,y,count)
    # b-y가 남은공간
    if x < b-y:
        dfs(0,y+x,count)
    else:
        dfs(x- (b-y),b,count)
    if y<a-x:
        dfs(x+y,0,count)
    else:
        dfs(a,y-(a-x),count)


dfs(0,0,0)
if len(min_stack)==1:
    print("-1")
else:
    print(min_stack[-1])
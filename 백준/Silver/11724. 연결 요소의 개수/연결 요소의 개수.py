import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n,m = map(int,input().split())

ary = [[]for _ in range(n+1)]

for _ in range(m):
    x,y = map(int,input().split())
    ary[x].append(y)
    ary[y].append(x)

visited = [False]*(n+1)
def search(index):
    visited[index]=True
    for element in ary[index]:
        if visited[element]==False:
            visited[element]=True
            search(element)
count = 0
for i in range(1,n+1):
    if visited[i]:
        continue
    search(i)
    count+=1

print(count)
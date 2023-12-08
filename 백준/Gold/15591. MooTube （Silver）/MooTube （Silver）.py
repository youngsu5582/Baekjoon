import sys
from collections import deque
input = sys.stdin.readline


n,Q = map(int,input().split())
ary = [[]for _ in range(n+1)]

for _ in range(n-1):
    p,q,r = (map(int,input().split()))
    ary[p].append((q,r))
    ary[q].append((p,r))

for i in range(Q):
    k,v = map(int,input().split())
    visited=[False] * (n + 1)
    visited[v]=True
    count = 0
    queue = deque([(v, float('inf'))])
    while queue:
        pos,usado = queue.pop()

        for new_pos,new_usado in ary[pos]:
            new_usado = min(usado,new_usado)
            if new_usado>=k and not visited[new_pos]:
                count+=1
                queue.append((new_pos,new_usado))
                visited[new_pos]=True
    print(count)
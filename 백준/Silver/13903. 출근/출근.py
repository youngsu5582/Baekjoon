import sys
from collections import deque
input = sys.stdin.readline


r,c = map(int,input().split())

visited = [[False] * c for _ in range(r)]

board = []
for _ in range(r):
    board.append(list(map(int,input().split())))

n = int(input())
rule = []
for _ in range(n):
    rule.append(list(map(int,input().split())))

max_stack = [float('inf')]

queue = deque()


for i in range(c):
    if board[0][i] ==1:
        queue.append([0,i,0])


while queue:
    x,y,count= queue.popleft()
    if x==r-1:
        if max_stack[-1]>count:
            max_stack.append(count)
            break

    for element in rule:
        next_x = element[0]+x
        next_y = element[1]+y
        if 0<=next_x < r and 0<=next_y<c and visited[next_x][next_y]is False:
            visited[next_x][next_y]=True
            if board[next_x][next_y]==1:
                queue.append([next_x,next_y,count+1])

if len(max_stack)==1:
    print(-1)
else:
    print(max_stack[-1])
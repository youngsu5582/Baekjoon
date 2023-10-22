from sys import stdin
import math

input = stdin.readline


n,m,k = map(int,input().split())

board = []
for _ in range(n):
    board.append(list(map(int,input().split())))

visited = [[False]* n for _ in range (n)]


direction_x = [-1,0,1,0]
direction_y = [0,1,0,-1]
mushroom = []

for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            continue
        if visited[i][j]==True:
            continue
        queue = []
        queue.append([i,j])
        visited[i][j]=True
        count = 0
        while queue:
            element = queue.pop(0)
            x = element[0]
            y = element[1]
            count+=1
            for index in range(4):
                next_x = x+direction_x[index]
                next_y = y + direction_y[index]
                if 0<=next_x<n and 0<=next_y<n:
                    if board[next_x][next_y]==0:
                        if visited[next_x][next_y] is False:
                            visited[next_x][next_y] = True
                            queue.append([next_x,next_y])
        mushroom.append(count)

if len(mushroom)==0:
    print("IMPOSSIBLE")
    exit(0)

for element in mushroom:
    spore = math.ceil(element/k)
    if m>=spore:
        m-=spore
    else:
        print("IMPOSSIBLE")
        exit(0)
print("POSSIBLE")
print(m)
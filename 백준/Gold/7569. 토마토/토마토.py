import sys
from collections import deque


m,n,h = map(int,sys.stdin.readline().split())

nx = [1,-1,0,0,0,0]
ny =[0,0,1,-1,0,0]
nz = [0,0,0,0,1,-1]

ary = [[[] for _ in range(n)] for _ in range(h)]


queue = deque()
for i in range(h):
    for j in range(n):
        ary[i][j] = list(map(int,sys.stdin.readline().split()))
        for k in range(m):
            if ary[i][j][k] ==1:
                queue.append([i,j,k])
max_count = 0
count = 0
while (queue):
    count+=1

    current_queue = len(queue)
    for _ in range(current_queue):

        element = queue.popleft()
        i,j,k = element
        for index in range(6):
            pos_x =nx[index]+i
            pos_y = ny[index]+j
            pos_z = nz[index] + k
            if 0<=pos_x<h and 0<=pos_y<n and 0<=pos_z<m:
                if ary[pos_x][pos_y][pos_z]==0:
                    queue.append([pos_x,pos_y,pos_z])
                    ary[pos_x][pos_y][pos_z] = 1




for i in range(h):
    if max_count==-1:
        break
    for j in range(n):
        if max_count==-1:
            break
        for k in range(m):
            if ary[i][j][k] ==0:
                print(-1)
                sys.exit(0)
print(count-1)
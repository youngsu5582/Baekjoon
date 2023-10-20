from sys import stdin
input = stdin.readline


# 북 서 남 동
direction_x = [-1,0,1,0]
direction_y = [0,1,0,-1]

n,m = map(int,input().split())
r,c,d = map(int,input().split())
room = [[*map(int, input().split())] for _ in range(n)]
room[r][c]=2
count = 1
while room[r][c]!=1:
    forward = -1
    
    for _ in range (4):
        d = (d+3)%4
        next_x = direction_x[d]+r
        next_y = direction_y[d]+c
        if 0<=next_x<n and 0<=next_y<m:
            if room[next_x][next_y]==0:
                r,c =next_x,next_y
                room[r][c] = 2
                count+=1
                forward = 0
                break
    if forward ==-1:
        r -=direction_x[d]
        c -= direction_y[d]


print(count)
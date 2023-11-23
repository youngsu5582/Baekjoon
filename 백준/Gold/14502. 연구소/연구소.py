from sys import stdin
from copy import deepcopy
input = stdin.readline

n,m = map(int,input().split())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

lt = []
rus = []

next_x = [-1,0,1,0]
next_y = [0,1,0,-1]

space = 0
for i in range(n):
    for j in range(m):
        if ary[i][j]==1:
            continue
        if ary[i][j]==2:
            rus.append([i,j])
            continue
        space+=1
        lt.append([i,j])
# space 는 안전한 총 공간

max_count = [n*m]

def bfs(board):
    queue = rus.copy()
    count = 3
    while queue:
        if count>=max_count[-1]:
            return
        x,y = queue.pop()
        for i in range(4):
            n_x = next_x[i]+x
            n_y = next_y[i]+y
            if 0<=n_x<n and 0<=n_y<m:
                if board[n_x][n_y]==0:
                    board[n_x][n_y]=2
                    queue.append([n_x,n_y])
                    count+=1
    if count<max_count[-1]:
        max_count[-1]=count
    return


le = len(lt)
for x in range(le):
    for y in range(x+1,le):
        for z in range(y+1,le):
            board = deepcopy(ary)
            element = lt[x]
            board[element[0]][element[1]] = 1
            element = lt[y]
            board[element[0]][element[1]] = 1
            element = lt[z]
            board[element[0]][element[1]] = 1
            bfs(board)
print(space-max_count[-1])
#00 01 02 






board = []
for _ in range(5):
    board.append(list(map(int,input().split())))
direction_x = [-1,0,1,0]
direction_y = [0,1,0,-1]



r,c = map(int,input().split())

def dfs(x:int,y:int,ary:list[int]):
    if len(ary)==4:
        count = 0
        for element in ary:
            past_x = element[0]
            past_y = element[1]
            if board[past_x][past_y]==1:
                count+=1
        if count>1:
            print(1)
            exit(0)
        return
    for index in range(4):
        next_x = x+direction_x[index]
        next_y = y+direction_y[index]
        if 0<=next_x<5 and 0<=next_y<5:
            if board[next_x][next_y]!=-1 and [next_x,next_y] not in ary:
                ary.append([next_x,next_y])
                dfs(next_x,next_y,ary)
                ary.pop(-1)
                

ary=[]
ary.append([r,c])
dfs(r,c,ary)


print(0)
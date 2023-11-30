import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

direction_x = [1,0,-1,0]
direction_y = [0,-1,0,1]

n = int(input())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

def find_shark():
    for i in range(n):
        for j in range(n):
            if ary[i][j]==9:
                return [i,j]

shark_pos = find_shark()
shark_size = 2


def find_food():
    temp = []
    for i in range(n):
        for j in range(n):
            if 0<ary[i][j]<shark_size:
                temp.append([i,j])

    return temp

result = 0
shark_count = 0
ary[shark_pos[0]][shark_pos[1]]=0
while True:
    foods = find_food()
    if len(foods)==0:
        break
    def bfs(shark_pos):

        visited = [[False for _ in range(n)] for _ in range(n)]
        queue = []
        count =0 
        queue.append(shark_pos)
        temp = []
        while queue:
            size = len(queue)
            for _ in range(size):
                x,y = queue.pop(0)
                if 0<ary[x][y]<shark_size:
                    temp.append([x,y])
                for i in range(4):
                    next_x = x+direction_x[i]
                    next_y = y+direction_y[i]
                    if 0<=next_x<n and 0<=next_y<n:
                        if visited[next_x][next_y] == False and ary[next_x][next_y]<=shark_size:
                            visited[next_x][next_y]=True
                            queue.append([next_x,next_y])
            if len(temp)!=0:
                temp.sort()
                x,y = temp[0]
                return [x,y,count]
            else:
                count+=1

        return [-1,-1,-1]
    distance = bfs(shark_pos)
    if distance[2]==-1:
        break
    result+=distance[2]
    x,y = distance[0],distance[1]
    shark_pos = [x,y]
    ary[x][y]=0
    shark_count+=1
    if(shark_count==shark_size):
        shark_count=0
        shark_size+=1


print(result)


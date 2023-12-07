import sys
input = sys.stdin.readline

direction_x = [-2,-1,1,2,2,1,-1,-2]
direction_y= [1,2,2,1,-1,-2,-2,-1]


t = int(input())
result = []
for _ in range(t):
    l =int(input())
    pos = list(map(int,input().split()))
    arrive = list(map(int,input().split()))
    queue = [pos]
    count = 0
    visited = [[False for _ in range(l)] for _ in range(l)]
    visited[pos[0]][pos[1]]=True
    while queue:
        size = len(queue)
        for _ in range(size):
            element = queue.pop(0)
            if element==arrive:
                result.append(count)
                queue.clear()
                break
            x,y = element
            for i in range(8):
                next_x = x+direction_x[i]
                next_y = y+direction_y[i]
                if 0<=next_x<l and 0<=next_y<l:
                    if visited[next_x][next_y]==False:
                        visited[next_x][next_y]=True
                        queue.append([next_x,next_y])
        count+=1
                
            

for element in result:
    print(element)
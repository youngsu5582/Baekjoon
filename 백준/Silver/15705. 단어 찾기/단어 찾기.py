nx = [-1 ,-1 ,0 ,1 ,1 ,1 ,0 , -1]
ny = [0 ,1 ,1 ,1 ,0 ,-1 ,-1 , -1]

string = input()
n,m = map(int,input().split())
ary = []
for i in range(n):
    ary.append(input())
stack = []
for i in range(n):
    for j in range(m):
        if ary[i][j]==string[0]:
            stack.append([i,j])
if len(string)==1 and len(stack)!=0:
    print(1)
    exit(0)

def dfs(x,y,direction,count):
    # if count ==len(string):
    #     return
    if count ==len(string):
         if ary[x][y]==string[-1]:
            print(1)
            exit(0)
         return
    next_x = x+nx[direction]
    next_y = y+ny[direction]
    if 0<=next_x<n and 0<=next_y<m and ary[next_x][next_y]==string[count]:
        dfs(next_x,next_y,direction,count+1)
    return
for element in stack:
    x,y = element
    for i in range(len(nx)):
        next_x = x+nx[i]
        next_y = y+ny[i]
        if 0<=next_x<n and 0<=next_y<m:
            if ary[next_x][next_y]==string[1]:
                dfs(next_x,next_y,i,2)

print(0)



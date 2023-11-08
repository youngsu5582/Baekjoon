from sys import stdin
input = stdin.readline


n,m = map(int,input().split())

ary = []

for _ in range(2):
    ary.append(list(map(int,input().split())))
# 그 전 , 날짜 , 임계치
result = []
def dfs(past,day,thresh):

    if day==n:
        if thresh>=m:
            result.append(0)
        return

    for i in range(3):
        for j in range(2):
            if i==past:
                dfs(i,day+1,thresh+ary[j][i]//2)
            else:
                dfs(i,day+1,thresh+ary[j][i])
dfs(-1,0,0)
print(len(result))
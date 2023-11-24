import sys

input = sys.stdin.readline

n,k = map(int,input().split())

ary = []
for _ in range(n):
    ary.append(tuple(map(int,input().split())))
dp = [0]*(k+1)
for x,y in ary:
    # x-1인 이유? : 두번째 문은 값이 되면 종료 ( -1 을 해야 전부 순회 )
    for i in range(k,x-1,-1):
        dp[i]=max(dp[i],dp[i-x]+y)


print(dp[k])
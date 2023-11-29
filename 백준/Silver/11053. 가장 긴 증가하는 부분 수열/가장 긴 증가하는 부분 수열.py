import sys
input = sys.stdin.readline
n = int(input())
ary = list(map(int,input().split()))
dp = [0]*n
dp[n-1]=1

for i in range(n-1,-1,-1):
    max_index = float('inf')
    for j in range(i+1,n,1):
        if ary[i]>=ary[j]:
            continue
        if max_index==float('inf'):
            max_index = j
            continue
        if ary[max_index]>ary[j]:
            if dp[max_index]>dp[j]:
                continue
            max_index=j
    if max_index==float('inf'):
        dp[i]=1
    else:
        dp[i]=dp[max_index]+1
print(max(dp))
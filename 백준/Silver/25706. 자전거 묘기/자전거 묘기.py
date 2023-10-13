n = int(input())
ary=  list(map(int,input().split()))
dp = [0]*(n)
dp[-1]=1
for i in range(n-1,-1,-1):
    index = min(i+ary[i] + 1,n)
    if index==n:
        dp[i]=1
        continue
    dp[i] = dp[index]+1
for element in dp:
    print(element,end=' ')
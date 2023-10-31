n = int(input())

dp = [float('inf')]*(n+1)
dp[0]=0
if n ==1 or n==3:
    print(-1)
    exit(0)
dp[2] = 1
if n>4:
    dp[5] = 1

for i in range(4,n+1):
    dp[i] = min ( dp[i-2]+1 , dp[i-5]+1 if i >=5 else float('inf')  ) 
if dp[n]==float('inf'):
    print(-1)
else:
    print(dp[n])
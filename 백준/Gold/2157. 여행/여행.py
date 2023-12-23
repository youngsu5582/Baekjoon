import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

n,m,k = map(int,input().split())

ary = [[0 for _ in range(n+1)] for _ in range(n+1)]
if n==1:
    print(0)
    exit(0)

for _ in range(k):
    a,b,c = map(int,input().split())
    if a>=b:
        continue

    ary[a][b] =max(ary[a][b],c)

result = 0
dp = [[0 for _ in range(m)] for _ in range(n+1)]
for index in range(n+1):
    dp[index][1] = ary[1][index]


for index in range(1,n+1):
    for j in range(index+1,n+1):
        if ary[index][j]==0:
            continue
        for dp_pos in range(m-1):
            if dp[index][dp_pos]==0:
                continue
            dp[j][dp_pos+1] = max(dp[j][dp_pos+1],ary[index][j]+dp[index][dp_pos])
print(max(dp[n]))
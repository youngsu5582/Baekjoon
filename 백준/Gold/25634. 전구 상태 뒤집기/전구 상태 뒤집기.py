from sys import stdin
input = stdin.readline
n = int(input())

dp = [0] * (n+1)
ary = list(map(int,input().split()))
switch = list(map(int,input().split()))

if n==1:
    if switch[0]:
        print(0)
    else:
        print(ary[0])
    exit(0)

dp[0] = ary[0] if switch[0] != 1 else 0

for i in range(1,n):
    # 반전이 되지 않음
    if dp[i-1] ==0:
        if switch[i]:
            dp[i]=0
        else:
            dp[i]=ary[i]
    else:
        if switch[i]:
            dp[i] = dp[i-1]-ary[i] if dp[i-1]-ary[i]>0 else 0
        else:
            dp[i] = dp[i-1]+ary[i]

max_number = max(dp)
max_index = dp.index(max_number)
if max_number==0:
    switch[ary.index(min(ary))] = 0 if switch[i]==1 else 1
for i in range (max_index,-1,-1):
    if dp[i]==0:
        break
    switch[i] = 0 if switch[i]==1 else 1
number=  0
for i in range(n):
    if switch[i]:
        number+=ary[i]

print(number)
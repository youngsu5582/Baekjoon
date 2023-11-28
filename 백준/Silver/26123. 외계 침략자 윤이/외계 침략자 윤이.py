import sys
input = sys.stdin.readline

n,d = map(int,input().split())

ary = list(map(int,input().split()))
max_index = max(ary)
dp = [0]*(max_index+1)
for element in ary:
    dp[element]+=1

count = 0
for i in range(max_index,max(max_index-d,0),-1):
    dp[i-1] +=dp[i]
    count = count + dp[i]
print(count)
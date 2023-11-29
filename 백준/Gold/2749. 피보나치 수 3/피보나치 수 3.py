import sys
input = sys.stdin.readline
MOD = 1000000
RES = 1500000
n = int(input())

mod_n = n
first = 0
second = 1
temp = 0
dp = [0,1]
for _ in range(2,min(n+1,1500000)):
    temp = (first%MOD+second%MOD)%MOD
    dp.append(temp)
    first,second = second,temp
    
def calc(n):
    if n<1500000:
        return dp[n]%MOD
    return dp[n%RES]


print(calc(n))
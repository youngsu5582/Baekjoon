import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
maps = map(int,input().split())


n,k = maps
unit = 1000000007
A = 1
B = 1
for i in range(n,n-k,-1):
    A = (A*i) %unit


for i in range(1,k+1):
    B = (B*i)%unit
def pow(k,b):
    if b==0:
        return 1
    temp = pow(k,b//2)%unit
    if b%2==1:
        return (temp * temp % unit) * (k%unit)
    return (temp*temp)%unit



result = (A%unit*pow(B,unit-2)%unit)%unit
print(result)


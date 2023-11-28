import sys
input = sys.stdin.readline
m = int(input())
unit = 1000000007

def pow(n,k):
    if k ==0:
        return 1
    if k==1:
        return n
    temp = pow(n,k//2)%unit
    element = (temp*temp)%unit
    if k%2==1:
        return element * n
    return element
facto = [0]*(4000005)
def create_facto():
    facto[0]=1
    for i in range(1,len(facto)):
        facto[i] = facto[i-1]*i%unit
def calc(n,k):
    A = facto[n]
    B = facto[n-k]*facto[k]
    return (A%unit)*(pow(B,unit-2)%unit)%unit
result = []
create_facto()
for _ in range(m):
    n,k = map(int,input().split())
    result.append(calc(n,k))
for element in result:
    print(element)
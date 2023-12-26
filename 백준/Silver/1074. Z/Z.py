import sys
input = sys.stdin.readline

n,r,c = map(int,input().split())
result = 0

while n!=0:
    thresh = 2**(n-1)
    cache = thresh * thresh
    
    result += 2 * ( r // thresh) * cache
    result += ( c // thresh ) * cache
    r %= thresh
    c %= thresh
    n-=1

print(result)
import sys
input = sys.stdin.readline

n,k = map(int,input().split())

ary = [0]*(1000000)
max_index = 0
for _ in range(n):
    g,x = map(int,input().split())
    max_index = max(x,max_index)
    ary[x] = g
temp = sum(ary[:k*2+1])
max_result = temp
for i in range(k+1,max_index-k+1):
    temp -= ary[i-k-1]
    temp += ary[i+k]
    max_result = max(temp,max_result)

print(max_result)
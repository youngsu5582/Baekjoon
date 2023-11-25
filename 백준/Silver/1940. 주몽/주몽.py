import sys

input = sys.stdin.readline


n = int(input())
m = int(input())

ary = list(map(int,input().split()))

ary.sort()


start = 0
end = n-1
count = 0
while start<end:
    element = ary[start]+ary[end]
    if element==m:
        count+=1
        start+=1
        end-=1
    elif element<m:
        start+=1
    else:
        end-=1

print(count)
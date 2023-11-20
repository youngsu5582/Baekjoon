from sys import stdin
input = stdin.readline

x,y = map(int,input().split())

answer = int(y*100/x)

left = 0
right = 10000000000000

while left<=right:
    mid = (left+right)//2
    temp = int((y+mid)*100/(x+mid))
    if temp>answer:
        right = mid-1
    else:
        left = mid +1
if mid == 10000000000000:
    print(-1)
else:
    print(right+1)
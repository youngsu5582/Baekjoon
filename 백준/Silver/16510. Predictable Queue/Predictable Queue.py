import sys

n,m = map(int,input().split())
ary = list(map(int,sys.stdin.readline().split()))

dp=[]
count = 0
prev_count = 0

t = 0
for index in range(1,len(ary)):
    ary[index] +=ary[index-1]
result = []
for _ in range(m):
    case = int(input())
    left = 0
    right = len(ary)-1
    while left<=right:
        mid = int((left+right)/2)
        if ary[mid]<=case:
            left = mid+1
        else:
            right = mid-1
    result.append(left)


for element in result:
    print(element)
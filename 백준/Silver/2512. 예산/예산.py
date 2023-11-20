from sys import stdin
input = stdin.readline


n = int(input())
ary = list(map(int,input().split()))
amount = int(input())

if sum(ary)<=amount:
    print(max(ary))
    exit(0)

left = 0
right = 1000000000
while left<=right:
    mid = (left+right)//2
    temp = 0
    for element in ary:
        if element<=mid:
            temp+=element
        else:
            temp+=mid
    if temp<=amount:
        left = mid +1

    else:
        right = mid -1


print(right)
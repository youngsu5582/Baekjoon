from sys import stdin

input = stdin.readline

n,k,d = map(int,input().split())

rule = []
for _ in range (k):
    rule.append(list(map(int,input().split())))


left = 1
right = n
while left<=right:
    mid = (left+right)//2
    cnt = 0
    for element in rule:
        if element[0]>mid:
            continue
        if element[1]<mid:
            cnt+=(element[1]-element[0])//element[2]+1
        else:
            cnt+=(mid-element[0])//element[2]+1
        if cnt>=d:
            right = mid-1
            break
    if cnt<d:
        left=mid+1
print(left)
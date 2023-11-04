from sys import stdin
input = stdin.readline
n = int(input())
ary = list(map(int,input().split()))

max_number = max(ary)
max_pos = ary.index(max_number)

last_pos = max_pos
for i in range(max_pos+1,n):
    if ary[i]==max_number:
        last_pos = i




if last_pos ==max_pos:
    if max_pos > n-max_pos-1:
        print("B")
    elif max_pos<n-max_pos-1:
        print("R")
    else:
        print("X")
else:
    if max_pos > n-last_pos-1:
        print("B")
    elif max_pos<n-last_pos-1:
        print("R")
    else:
        print("X")



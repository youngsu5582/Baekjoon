import sys
input = sys.stdin.readline

n = int(input())
ary= []
for i in range(n):
    ary.append(list(map(int,input().split())))
ary.sort(key=lambda x:x[0])
all = 0
for i in range(n):
    all += ary[i][1]
count = 0
for i in range(n):
    count += ary[i] [1]
    if count >= all/2:
        print (ary[i][0])
        break
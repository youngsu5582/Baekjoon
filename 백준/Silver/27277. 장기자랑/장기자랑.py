n = int(input())
ary = list(map(int,input().split()))
if len(ary)==1:
    print(ary[0])
    exit(0)

ary.sort()

high = n-1
low = 0

sum = ary[high]
high-=1
while low<high:
    last = ary[low]
    sum+=ary[high]-last
    low+=1
    high-=1

print(sum)
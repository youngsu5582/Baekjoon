count = int(input())

data = list(map(int,input().split()))


left = 0
right = len(data)-1
min = 2000000000
ary = []
while left<right:
    result = data[left]+data[right]
    if abs(result)<min:
        ary = [data[left],data[right]]
        min = abs(result)
    if result >0:
        right -=1
    else:
        left +=1

print(ary[0],ary[1])
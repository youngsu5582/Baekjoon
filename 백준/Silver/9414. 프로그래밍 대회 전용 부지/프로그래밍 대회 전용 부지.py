t = int(input())
result = []
max_number = 5*10**6
for i in range(t):
    element =-1
    stack=[]
    while element!=0:
        element = int(input())
        stack.append(element)
    stack.sort(reverse=True)
    count = 1
    sum = 0
    for element in stack:
        sum+=2*(element**count)
        if sum>max_number:
            sum=-1
            break
        count+=1
    result.append(sum)

for element in result:
    if element==-1:
        print("Too expensive")
    else:
        print(element)
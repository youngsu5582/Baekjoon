
result = []
while True:
    n = int(input())
    count = 0
    dict = {}
    if n==0:
        break
    for _ in range(n):
        angel,people = map(str,input().split())

        if angel not in dict:
            dict[angel] = people
        # else:
        #     dict[angel].append(people)

    for key in dict.keys():
        next = dict[key]
        while next in dict:
            next = dict[next]
            if next=="":
                break
            if next==key:
                #print(count)
                dict[key] = ""
                count+=1
                break
    result.append(count)


for index,element in enumerate(result):
    print(index+1,element,end=" ")
    print()
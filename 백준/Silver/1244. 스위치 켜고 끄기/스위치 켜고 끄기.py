

n = int(input())
sw = list(map(int,input().split()))
sw.insert(0,0)
student = int(input())
for i in range (student):
    gender , num = map(int,input().split())
    if gender ==1:
        count = 1
        while count*num <=n:
            sw[count*num] = 0 if sw[count*num]==1 else 1
            count+=1
    else:
        count = 0
        while True:
            if num-count <1 or num+count>n:
                break
            if count == 0:
                sw[num] = 1 if sw[num]==0 else 0
                count+=1
                continue
            if sw[num+count] == sw[num-count]:
                sw[num+count] = 1 if sw[num+count]==0 else 0
                sw[num-count] = 1 if sw[num-count]==0 else 0
                count+=1
            else:
                break
for index,element in enumerate(sw[1:]):
    print(element)
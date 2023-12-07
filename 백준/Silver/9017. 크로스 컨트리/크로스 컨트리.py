import sys
from collections import Counter

input = sys.stdin.readline


t = int(input())
for _ in range(t):
    n = int(input())
    dct = {}
    ary =list(map(int,input().split()))
    counter = Counter(ary)
    result_ary = []
    for key,value in counter.items():
        if value>=6:
            dct[key]=[]
            
    count = 1
    result = []
    for element in ary:
        if element in dct:
            dct.get(element).append(count)
            count+=1
    for key,value in dct.items():
        
        result.append([key,sum(value[:4])])
    result.sort(key=lambda x:x[1])
    max_number = result[0][1]
    max_index = result[0][0]
    for i in range(1,len(result)):
        if result[i][1]==max_number:
            index = result[i][0]
            if dct.get(index)[4]<dct.get(max_index)[4]:
                max_index = index
        else:
            break
    print(max_index)

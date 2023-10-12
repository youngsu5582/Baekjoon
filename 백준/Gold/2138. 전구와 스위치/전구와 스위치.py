n = int(input())
current = []
result = []
first = input()
second = input()
for element in first:
    current.append(int(element))

for element in second:
    result.append(int(element))

def greedy(current):
    count = 0
    for i in range (1,n):
        if current[i-1]==result[i-1]:
            continue
        if i ==n-1:
                current[i-1] ,current[i] = 1- current[i-1] , 1- current[i]
                count+=1
                break
        current[i-1] ,current[i] ,current[i+1] = 1 - current[i-1] , 1- current[i],1- current[i+1]
        count+=1
    if current==result:
         return count
    else:
         return float('inf')

not_first_count = greedy(current.copy())
current[0] = 1-current[0]
current[1] = 1-current[1]
first_count = greedy(current.copy())+1
count = min(not_first_count,first_count)
if count==float('inf'):
     print(-1)
else:
     print(count)

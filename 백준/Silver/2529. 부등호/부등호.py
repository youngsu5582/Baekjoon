k = int(input())
op = list(map(str,input().split()))
min_ary = [0]*(k+1)
max_ary = [9]*(k+1)

if op[0]=='<':
    min_ary[0] ,min_ary[1] = 0,1
    max_ary[0],max_ary[1] = 8,9
else:
    min_ary[1] ,min_ary[0] = 0,1
    max_ary[1],max_ary[0] = 8,9

for i in range(1,len(op)):
    if op[i]=='<':
        min_number = min(max_ary)-1
        min_ary[i+1]=max(min_ary)+1
        j = i
        while j!=-1 and op[j]!='>':
            max_ary[j+1]=max_ary[j]
            j-=1
        max_ary[j+1] = min_number
    else:
        max_number = max(min_ary)+1
        max_ary[i+1] = min(max_ary)-1
        j = i
        while j!=-1 and op[j]!='<':
            min_ary[j+1]=min_ary[j]
            j-=1
        min_ary[j+1] = max_number
max_result =""
min_result=""
for element in max_ary:
    max_result+=str(element)
for element in min_ary:
    min_result +=str(element)

print(max_result)
print(min_result)
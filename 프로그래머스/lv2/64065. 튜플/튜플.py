import re
def solution(s):
    answer = []
    s = s[1:-1]
    ary = s.split('{}')
    index = 0 
    result = re.split(r'\},\{', s)
    for i in result:
        if i[0]=='{':
            i = i[1:]
        if i[-1]=='}':
            i = i[:-1]
    ary = []
    for i in result:
        temp = i.strip('{}')
        ary.append(temp)
    nums = []
    for i in ary:
        nums.append(i.split(","))
    
    count = 1
    stack = []
    for i in range(len(nums)):
        for j in range(len(nums)):
            if len(nums[j])==count:
                count+=1
                for element in nums[j]:
                    if element not in stack:
                        stack.append(element)
                        break
                break
    for i in range(len(stack)):
        stack[i] = int(stack[i])

    return stack
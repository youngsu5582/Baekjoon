string = input()
alpha = [0]*26
stack = []
for element in string:
    alpha[ord(element)-ord("A")]+=1
last_str = ""

for index in range(len(alpha)):
    if alpha[index]==0:
        continue
    if alpha[index]%2!=0:
        if len(last_str)!=0:
            stack=[]
            break
        else:
            element = chr(index+ord("A"))*int(alpha[index]/2)
            stack.append(element)
            last_str = chr(index+ord("A"))
    else:
        element = chr(index+ord("A"))*int(alpha[index]/2)
        stack.append(element)

result = ""
if len(stack)!=0:
    for element in stack:
        result+=element
    result+=last_str
    for element in reversed(stack):
        result+=element
else:
    result = "I'm Sorry Hansoo"
print(result)
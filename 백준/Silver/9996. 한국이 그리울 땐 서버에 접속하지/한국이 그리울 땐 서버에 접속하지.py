n = int(input())
pattern=input()
ary= []
for i in range(n):
    string = input()
    sw = 0
    for i in range(len(string)):
        if pattern[i] == "*":
            for j in range(-1,i-len(pattern),-1):    
                if string[j] == pattern[j]:
                    continue
                else:
                    sw = 1
                    break
            break
        if string[i]==pattern[i]:
            continue
        sw = 1
        break
    if sw ==0 and len(pattern)<=len(string)+1:
        ary.append("DA")
    else:
        ary.append("NE")

for elemnt in ary:
    print(elemnt)

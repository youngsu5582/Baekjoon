str = input()
ary = str.split('.')
    

answer = ""
for element in ary:
    size = len(element)
    if size%2 !=0:
        answer ="-11"
        break
    while size>=4:
        answer +="AAAA"
        size-=4
    if size>=2:
        answer +="BB"
    answer +="."
print(answer[:-1])
str = input()
Set = set()
for index in range(len(str)):
    temp = ""
    for j in range(index, len(str)):
        temp += str[j]
        Set.add(temp)

print(len(Set))

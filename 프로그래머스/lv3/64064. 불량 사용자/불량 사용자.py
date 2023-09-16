def solution(user_id, banned_id):
    answer = 0
    
    bann_list = [None] * len(banned_id)
    for i in range(len(bann_list)):
        bann_list[i] = []
    count = 0
    for element in banned_id:
        for user in user_id:
            if len(user)!=len(element):
                continue
            sc = True
            for i in range(len(user)):
                if user[i] == element[i] or element[i]=="*":
                    continue
                sc = False
                break
            if sc== True:
                bann_list[count].append(user)
        count+=1
    ary = []
    def dfs(bann_list,prev,count):
        if len(prev)==len(bann_list):
            prev = sorted(prev)
            if prev not in ary:
                ary.append(prev)
            return
    
        for i in range(len(bann_list[count])):
            if bann_list[count][i] in prev:
                continue
            prev.append(bann_list[count][i])
            dfs(bann_list,prev,count+1)
            prev.pop()

    for i in range(len(bann_list[0])):
        prev = []
        prev.append(bann_list[0][i])
        dfs(bann_list,prev,1)
    return len(ary)
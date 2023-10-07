n = int(input())
ary = []
for i in range(n):
    f, c = map(int,input().split())
    ary.append([f,c])
ary.sort(key=lambda x:x[1])

result = []

m = int(input())
for i in range(m):
    v,t = map(int,input().split())
    min_stack = []
    min_stack.append(float("inf"))
    def dfs(sum_ary:list[int],cost_ary:list[int],j):
        if j==len(ary)+1:
            return
        if sum(cost_ary)>min_stack[-1]:
            return
        if sum(sum_ary) * t > v:
            if sum(cost_ary) < min_stack[-1]:
                min_stack.append(sum(cost_ary))
            return

        for index in range(j,len(ary)):
            sum_ary.append(ary[index][0])
            cost_ary.append(ary[index][1])
            dfs(sum_ary,cost_ary,index+1)
            sum_ary.pop()
            cost_ary.pop()
    sum_ary = []
    cost_ary = []
    for i in range(0,len(ary)):
        sum_ary.append(ary[i][0])
        cost_ary.append(ary[i][1])
        dfs(sum_ary,cost_ary,i+1)
        sum_ary.pop()
        cost_ary.pop()
    result.append(min_stack[-1])
for index,element in enumerate(result):
    if element != float("inf"):
        print("Case "+str(index+1)+": "+str(element))
    else:
        print ("Case "+str(index+1)+": IMPOSSIBLE")





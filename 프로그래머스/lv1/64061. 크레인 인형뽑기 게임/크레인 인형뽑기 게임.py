def solution(board, moves):
    answer = 0
    ary = [None] * len(board)
    for i in range(len(board)):
        ary[i] = []
    for i in range(len(board)):
        for j in range(len(board)):
            if(board[i][j]==0):
                continue
            ary[j].append(board[i][j])
    stack = []
    for i in moves:
        i -=1
        if len(ary[i])==0 or ary[i]==0:
            continue
        if len(stack)==0:
            stack.append(ary[i].pop(0))
            continue
        if stack[-1]==ary[i][0]:
            answer +=2
            stack.pop(-1)
            ary[i].pop(0)
            continue
        num = ary[i].pop(0)
        stack.append(num)
    return answer
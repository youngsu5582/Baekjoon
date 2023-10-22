### 문제 링크
https://www.acmicpc.net/problem/26169

### 문제 해석
- 5*5 크기의 보드가 있다.
- 이 보드에는 사과가 있는 칸이 있고 , 해당 칸으로 이동하면 사과를 1개 먹는다.
- 학생이 자나간 칸은 즉시 장매울이 있는 칸으로 변경된다.
- 세 번 이하의 이동으로 사과를 2개 이상 먹으면 1을 출력 , 아니면 0을 출력하자.

### 문제 해결
-  dfs 로 계속 선회하자
- 길이가 4일때 사과가 있는 칸이 2개 이상이면 1출력
- 아니면 계속 선회
### 슈도 코드
``` Text
ary = []
ary 에 [r,c] 추가

dfs(r,c,ary)

function dfs(x:int,y:int,ary:list[int])
	if ary 의 길이가 4라면
		count = 0
		for ary 에서 element 분해
			if board[element[0]][element[1]]==1 이라면  - 사과 있는곳
				count++
			if count>1:
				print 1을 출력
				종료
	for index in range(4)  -  4방향 순회
		next = 다음 향할 곳
		if next 가 0에서 5 사이라면
			if board[next] 가 -1이 아니고 next 가 ary 내에 없다면 - 방문한 적 없으며 , 장애물이 없는 곳
				ary 에 next 추가
				dfs(next,ary)
				ary 에 next 다시 제거 : 순열

print 0 출력
```

### 제출 코드
``` python
board = []
for _ in range(5):
    board.append(list(map(int,input().split())))
direction_x = [-1,0,1,0]
direction_y = [0,1,0,-1]



r,c = map(int,input().split())

def dfs(x:int,y:int,ary:list[int]):
    if len(ary)==4:
        count = 0
        for element in ary:
            past_x = element[0]
            past_y = element[1]
            if board[past_x][past_y]==1:
                count+=1
        if count>1:
            print(1)
            exit(0)
        return
    for index in range(4):
        next_x = x+direction_x[index]
        next_y = y+direction_y[index]
        if 0<=next_x<5 and 0<=next_y<5:
            if board[next_x][next_y]!=-1 and [next_x,next_y] not in ary:
                ary.append([next_x,next_y])
                dfs(next_x,next_y,ary)
                ary.pop(-1)
                

ary=[]
ary.append([r,c])
dfs(r,c,ary)


print(0)
```

### 사담
- 조건이 있는 dfs
- 이런 문제를 풀때마다 느끼는 것은 파이선이 문제를 정말 쉽게 해주는 거 같다.

##### Writed By Obisidan

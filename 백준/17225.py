"""아이디어
입력 : 각각 포장하는 시간 ,손님의 수( 주문 시각, 포장지색,선물개수)
두사람이 동시에 선물포장할때는 상민이부터
상민 - B
지수 - R
현재 남아있는 선물 중 가장 앞에 있는 선물부터 -- queue
반복문을 현재 남아있는 선물로 판단
시간이 계속 흐른다.
--
주문한 시간이 되면 작업공간에 선물개수만큼 공간에 추가
작업시간 a,b시간 지나면 popleft
상민이의 작업 공간 queue
지수의 작업 공간 queue

"""
##백점짜리...
import sys
from _collections import deque
a,b,n=map(int,sys.stdin.readline().split())
space=deque([])
gift=0
cntnum=1
#포장할 선물 번호 붙히고 작업장에 올림
for _ in range(n):
    t,c,m=sys.stdin.readline().split()
    t=int(t)
    for _ in range(int(m)):
        space.append([t,c,cntnum])
        if c=='B':
            t+=a
        else:
            t+=b
        cntnum+=1
print(space)
time=1
sang=deque([])
ji=deque([])
while space:
    while space and space[0][0]==time:
        t,c,gn=space.popleft()
        if c=='B':
            sang.append(gn)
        else:
            ji.append(gn)
    time+=1
print(len(sang))
for i in range(len(sang)):
    print(sang[i],end=" ")
print(len(ji))
for i in range(len(ji)):
    print(ji[i],end=" ")
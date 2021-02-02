import sys
from _collections import deque
# https://rubiks-cube-solver.com/fr/ 큐브 시뮬레이션
# https://www.acmicpc.net/problem/5373
t=int(sys.stdin.readline())
for _ in range(t):
    #위 U-> 흰 아 D->노 앞 F->빨 뒤 B->오  왼L -> 초 오R->파
    cube=[[['r']*3]*3,[['g']*3]*3,[['b']*3]*3,[['w']*3]*3,[['y']*3]*3,[['o']*3]*3]
    L,R,U,D,F,B=0,1,2,3,4,5
    rotate=[
        #시계방향기준
            #왼쪽
            deque([0,3,6,40,43,46,58,55,52,30,33,36]),
            #오른쪽
            deque([8,5,2,38,35,32,52,55,58,48,45,42]),
            #위쪽
            deque([2,1,0,12,11,10,52,51,50,22,21,20]),
            #아래쪽
            deque([6,7,8,26,27,28,56,57,58,16,17,18]),
            #앞쪽
            deque([20,23,26,42,41,40,18,15,12,36,37,38]),
            #뒤쪽
            deque([28,25,22,32,31,30,10,13,16,46,47,48])
            ]
    #print(cube)
    n=int(sys.stdin.readline())
    d=list(sys.stdin.readline().split())
    for i in range(n):
        direction=0
        if d[i][0]=='L':
            direction=L
            if d[i][1]=='-':
                rotate[direction].rotate(3)
            elif d[i][1]=='+':
                rotate[direction].rotate(-3)
        elif d[i][0] == 'R':
            direction=R
            if d[i][1] == '-':
                rotate[direction].rotate(3)
            elif d[i][1] == '+':
                rotate[direction].rotate(-3)
        elif d[i][0] == 'F':
            direction=F
            if d[i][1] == '-':
                rotate[direction].rotate(3)
            elif d[i][1] == '+':
                rotate[direction].rotate(-3)
        elif d[i][0] == 'B':
            direction=B
            if d[i][1] == '-':
                rotate[direction].rotate(3)
            elif d[i][1] == '+':
                rotate[direction].rotate(-3)
        elif d[i][0] == 'U':
            direction=U
            if d[i][1] == '-':
                rotate[direction].rotate(3)
            elif d[i][1] == '+':
                rotate[direction].rotate(-3)
        elif d[i][0] == 'D':
            direction=D
            if d[i][1] == '-':
                rotate[direction].rotate(3)
            elif d[i][1] == '+':
                rotate[direction].rotate(-3)
        print(rotate[direction])
        #큐브돌리기

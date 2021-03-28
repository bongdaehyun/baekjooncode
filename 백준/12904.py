import sys
from _collections import deque
#t 의 문자에서 s로 만들기
#t의 문자열의 끝이 A이면 A제거 B이면 B제거 후 역순

s=sys.stdin.readline().rstrip()
t=[i for i in sys.stdin.readline().rstrip()]

while True:
    if len(s)==len(t):
        break
    if t[-1]=='A':
        t.pop()
    elif t[-1]=='B':
        t.pop()
        t.reverse()

result=""
for i in t:
    result+=i
if result==s:
    print(1)
else:
    print(0)

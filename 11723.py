#비트마스크
import sys
a=int(sys.stdin.readline())
s=0
for _ in range(a):
    strcode=sys.stdin.readline()
    code=strcode.split()[0]
    if code =="add":
        s |= 1<<int(strcode.split()[1])
    elif code=="remove":
        s &= ~(1<<int(strcode.split()[1]))
    elif code=="check":
        if s &(1<<int(strcode.split()[1])):
            print(1)
        else:
            print(0)
    elif code=="toggle":
        s ^=(1<<int(strcode.split()[1]))
    elif code=="all":
        s=(1<<21)-1
    elif code=="empty":
        s=0
import sys

#2진수 표현 방법 bin() or int(A, 몇 진수)
#0b1011 -> b를 없애기위해선 format(A,b)
A=[int(i) for i in sys.stdin.readline().rstrip()]
B=[int(i) for i in sys.stdin.readline().rstrip()]

#A & B
res=""
for i in range(len(A)):
    res+=str(A[i] & B[i])
print(res)
#A | B
res=""
for i in range(len(A)):
    res+=str(A[i] | B[i])
print(res)
#A ^ B
res=""
for i in range(len(A)):
    res+=str(0) if A[i] == B[i] else str(1)
print(res)
#~A
res=""
for i in range(len(A)):
    res+=str(0) if A[i]==1 else str(1)
print(res)
#~B
res=""
for i in range(len(B)):
    res+=str(0) if B[i]==1 else str(1)
print(res)
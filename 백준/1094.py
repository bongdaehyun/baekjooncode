import sys

x=int(sys.stdin.readline())
bar=bin(x)
#print(sum(list(map(int,bar[2:]))))
res=[int(i) for i in bar[2:]]
print(res.count(1))
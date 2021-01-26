import sys

N=int(sys.stdin.readline())
maps=[]
for _ in range(N):
    maps.append(list(map(int, sys.stdin.readline().split())))
print(maps)


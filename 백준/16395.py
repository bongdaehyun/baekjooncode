#파스칼 삼각형!!! 조합론
import sys

n,k=map(int,sys.stdin.readline().split())
dp=[[1]*(i+1) for i in range(n)]
for i in range(2,n):
    for j in range(len(dp[i])):
        if j==0 or j==len(dp[i])-1:
            continue
        dp[i][j]=dp[i-1][j-1]+dp[i-1][j]


print(dp[n-1][k-1])
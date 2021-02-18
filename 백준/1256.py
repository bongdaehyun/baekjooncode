import sys
n,m,k=map(int,sys.stdin.readline().split())

# 문자열의 개수가 K보다 작으면 -1을 출력한다.
#파스칼 삼각형으로 조합 개수 파악
dp=[[1]*(i+1) for i in range(n+m+1)]
for i in range(2,len(dp)):
    for j in range(len(dp[i])):
        if j==0 or j==len(dp[i])-1:
            continue
        dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
#a,z N-1 , M +N-1, M-1 개수의 합과 같다. = N,M개로 만드는 개수
if dp[n][m]<=k:
    print(-1)
else:
    print(dp)
    print(dp[n-1][m])


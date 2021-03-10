import sys

dp=[0]*101
dp[1]=dp[2]=dp[3]=1
#dp[4]=dp[2]+d[1] ->dp[i]=dp[i-2]+dp[i-3]
def spiral(n):
    if n<=3:
        return 1
    dp[n]=spiral(n-2)+spiral(n-3)
    return dp[n]

t=int(sys.stdin.readline())
for i in range(t):
    n=int(sys.stdin.readline())
    # for j in range(4,n+1):
    #     if dp[j]:
    #         continue
    #     dp[j]=dp[j-2]+dp[j-3]
    spiral(n)
    print(dp[n])
import sys
Max= 1000001
dp=[0]*Max


n=int(sys.stdin.readline())
dp[1]=1
dp[2]=2

#값이 int값을 초과하기 때문에 n = 1000000 일 경우 엄청나게 많은 메모리를 차지하게 된다

for i in range(3,n+1):
    dp[i]=(dp[i-1]+dp[i-2])%15746
print(dp[n])
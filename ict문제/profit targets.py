def stockPairs(stocksProfit, target):
    stocksProfit.sort()
    count = 0
    left = 0
    right = len(stocksProfit) - 1
    result=[]
    while True:
        if left >= right:
            break
        else:

            if stocksProfit[left] + stocksProfit[right] == target:
                result.append((stocksProfit[left],stocksProfit[right]))
                left += 1
                right -= 1
            elif stocksProfit[left] + stocksProfit[right] < target:
                left += 1
            elif stocksProfit[left] + stocksProfit[right] > target:
                right -= 1
    result=list(set(result))
    count=len(result)
    return count


if __name__ == '__main__':
    print(stockPairs([6,6,3,9,3,5,1,9],12))
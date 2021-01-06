#그래프의 노드개수 세는 문제
import math

def connectedSum(n, edges):
    parent = [-1 for _ in range(n + 1)]

    def find(idx):
        val = parent[idx]
        if val < 0:
            return idx
        return find(val)

    def union(x, y):
        x = find(x)
        y = find(y)

        if x == y:
            return
        if parent[x] < parent[y]:
            parent[x] += parent[y]
            parent[y] = x
        else:
            parent[y] += parent[x]
            parent[x] = y

    for edge in edges:
        a, b = map(int, edge.split())
        union(a, b)
    parent = parent[1:]
    res = []
    for i in parent:
        if i < 0:
            res.append(abs(i))
    result = []
    for i in res:
        result.append(math.ceil(math.sqrt(i)))
    return sum(result)


if __name__ == '__main__':

def countGroups(related):
    # Write your code here
    parent = [-1 for _ in range(len(related))]
    maps = []
    for i in related:
        a = [int(j) for j in i]
        maps.append(a)
    visit = [[False] * len(related) for _ in range(len(related))]

    ds = []
    for x in range(len(related)):
        if maps[x][x] == 1 and visit[x][x] == False:
            visit[x][x] = True
            ds.append([x, x])
        for y in range(len(related)):
            if visit[x][y] == False and maps[x][y] == 1:
                visit[x][y] = True
                if maps[y][x] == 1 and visit[y][x] == False:
                    visit[y][x] = True
                    ds.append([x, y])

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

    for x, y in ds:
        union(x, y)
    count = 0
    for k in parent:
        if k < 0:
            count += 1
    return count


if __name__ == '__main__':
    print()
def commonSubstring(a, b):
    # Write your code here

    for i in range(len(a)):
        check = True
        for j in range(len(a[i])):
            if a[i][j] in b[i]:
                print('YES')
                check = False
                break
        if check:
            print("NO")
    return 0


if __name__ == '__main__':
    print()
def countStudents(height):
    # Write your code here
    a=sorted(height)
    count=0
    for i in range(len(height)):
        if a[i] !=height[i]:
            count+=1
    return count

if __name__ == '__main__':
    print()
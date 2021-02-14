
# Example of O(1):
'''
This algorithm will always execute in the same time (or space) regardless of the size of the input
data set. Therefore it is an algorithm that runs in constant time O(1).
'''
print('COMPARE FIRST ELEMENT IN array')

def IfFirstElementNull(strings):
    if strings[0] == None:
        return True
    return False

test = ['a', 'b', 'c']
print(IfFirstElementNull(test))
test[0] = None
print(IfFirstElementNull(test))

# Example of O(n)
'''
print('SUM AN ARRAY')

To look at a simple example, consider the problem of adding up all the numbers in an array. The
problem size, n, is the length of the array. Using A as the name of the array, the algorithm can be
expressed in Java as:
'''
A = [1, 2, 3, 4, 5]
n = 5
total = 0;
for i in range(n):
    total = total + A[i]
print(total)


# Example O(n^2)
'''
Classic bubble sort algorithm
'''

print('BUBBLE SORT')

def simpleBubbleSort(A, n):
    for i in range(n):
        for j in range(n-1):
            if A[j] > A[j+1]:
                temp = A[j]
                A[j] = A[j+1]
                A[j+1] = temp

    return A
A = [5, 4, 3, 2, 1]
n = 5
print(A)
simpleBubbleSort(A, n)
print(A)

# Example O(log n)
'''
Classic binary search algorithm
'''
print('BINARY SEARCH')

def binary_search(A, key, imin, imax):
    while imax >= imin:
        imid = int(imin + (imax - imin) / 2)
        if A[imid] == key:
            return imid # position of the element
        if A[imid] < key:
            imin = imid + 1
        if A[imid] > key:
            imax = imid - 1
    
    print("KEY_NOT_FOUND")
    return None

A = [2, 4, 6, 8, 10]
key = 4
imin = 0
imax = 4
print(binary_search(A, key, imin, imax))
key = 5
print(binary_search(A, key, imin, imax))

# EXAMPLE: O(n^2)
'''
Ignore the first for loop that isn't nested - That is a lower order opreation that the nested for loops == n^2
'''
print('EG_SORT')

def eg_sort(inArr):
    N = len(inArr)
    outArr = [0 for i in range(N)]

    for i in range(N):
        outArr[i] = inArr[i]

    for i in range(N):
        for j in range (i+1, N):
            if outArr[i] > outArr[j]:
                tmp = outArr[i]
                outArr[i] = outArr[j]
                outArr[j] = tmp

    return outArr

inArr = [2, 3, 5, 4, 1]
print(eg_sort(inArr))
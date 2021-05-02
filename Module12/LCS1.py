
def lcslength(A,B):
    m = len(A)
    n = len(B)

    arr = [[0] * n for i in range(m)] #initialize array of 0's
    prev = [[0] * n for i in range(m)] #initialize array of 0's

    for i in range(m):
        for j in range(n):
            if A[i] == B[j]:
                arr[i][j] = arr[i-1][j-1] + 1
                prev[i][j] = A[i]
            elif arr[i-1][j] > arr[i][j-1]:
                arr[i][j] = arr[i-1][j]
            else:
                arr[i][j] = arr[i][j-1]

    print(arr)
    
    longest = ""

    # need to rewrite this
    for i in range(m):
        for j in range(n):
            if i == j and prev[i][j] != 0:
                longest = longest + prev[i][j]

    print(longest)
        
A = "ALGORITHM"
B = "ALIGNMENT"
lcslength(A,B)
def selectionSort(A):
    for i in range (0,(len(A) - 1)):
        minIndex = i
        for j in range (i+1, len(A)):
            if A[j] < A[minIndex]:
                minIndex = j    
        
        if minIndex != i:
            A[i], A[minIndex] = A[minIndex], A[i]
    
    return A

print(selectionSort([45,32,6,78,9,43,1,2,2,100]))

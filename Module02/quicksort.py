def quickSort(A):
    return quickSort2(A, 0, len(A) - 1) # A, start index, low index

def quickSort2(A, low, high):
    print("quickSort2 A:{}, low: {}, high: {}".format(A,low,high))
    if low < high: # more than one item to sort
         p = partition(A, low, high) # returns the pivot
         quickSort2(A, low, p-1) # call recursive
         quickSort2(A, p + 1, high) # call recursive
    
    return A

def getPivot(A, low, high):
    print("getPivot A:{}, low: {}, high: {}".format(A,low,high))
    mid = ((high + low) // 2) # floor average

    print("mid: {}".format(mid))
    
    pivot = high
    if (A[low] < A[mid]):
        if (A[mid] < A[high]):
            pivot = mid
    elif (A[low] < A[high]):
        pivot = low
    
    return pivot

def partition(A, low, high):
    print("partition A:{}, low: {}, high: {}".format(A,low,high))
    pivotIndex = getPivot(A, low, high)
    pivotValue = A[pivotIndex]
    A[pivotIndex], A[low] = A[low], A[pivotIndex] #s swap pivot value with low value
    border = low

    for i in range(low, high+1):
        if (A[i] < pivotValue):
            border += 1
            A[i], A[border] = A[border], A[i]

    A[low], A[border] = A[border], A[low]

    return(border)


print(quickSort([78,5,46,90,3,2,67,101]))
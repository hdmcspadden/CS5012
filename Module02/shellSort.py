# Shell Sort is based on insertion sort, but tries to optimize the problem of a large number of shifts
# https://www.geeksforgeeks.org/shellsort/

'''
 In insertion sort, we move elements only one position ahead. 
 When an element has to be moved far ahead, many movements are involved. 
 
 The idea of shellSort is to allow exchange of far items. 
 In shellSort, we make the array h-sorted for a large value of h. 
 We keep reducing the value of h until it becomes 1. 
 An array is said to be h-sorted if all sublists of every h’th element is sorted.
'''

def shellSort(A):
    # start with big gap
    n = len(A)
    gap = n // 2 # half of the length of the array

    while gap > 0:
        for i in range(gap,n): # this works on the right side of the array
            tempValue = A[i]

            j = i

            while j >= gap and A[(j-gap)] > tempValue:
                A[j] = A[j-gap]
                j -= gap # j = j - gap

            A[j] = tempValue

        gap //= 2 # (floor divide, so when less than 1, it == 0)
    
    return(A)

print(shellSort([34,65,2,3,798,0,43,12,6,78]))
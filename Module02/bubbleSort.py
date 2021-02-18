def bubbleSort(A):
	for i in range(0, (len(A) - 1)):
		for j in range(0, (len(A) - 1 - i)):
			if A[j] > A[j+1]:
				A[j], A[j+1] = A[j+1], A[j] # basic swapping
	return(A)
    


print(bubbleSort([101,3,4,56,78,32,98,7,12]))

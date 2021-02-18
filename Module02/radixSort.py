# https://www.geeksforgeeks.org/radix-sort/
# https://brilliant.org/wiki/radix-sort/
# http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap09.htm

# Example with Base 10: https://big-o.io/algorithms/non-comparison/radix-sort/

# THE CODE DOES NOT YET WORK
'''
Radix sort is an integer sorting algorithm that sorts data with integer keys by grouping the keys by individual digits 
that share the same significant position and value (place value). Radix sort uses counting sort as a subroutine to sort an 
array of numbers. 

Because integers can be used to represent strings (by hashing the strings to integers), radix sort works on data types other 
than just integers. 

Because radix sort is not comparison based, it is not bounded by \Omega(n \log n)Ω(nlogn) for running time — in fact, 
radix sort can perform in linear time.


Radix sort takes in a list of nn integers which are in base bb (the radix) and so each number has at most dd digits where 
d = \lfloor(\log_b(k) +1)

floord=⌊(log b (k)+1)⌋ and k is the largest number in the list. 

For example, three digits are needed to represent decimal 104 (in base 10). 
It is important that radix sort can work with any base since the running time of the algorithm, O(d(n+b))O(d(n+b)), 
depends on the base it uses. 

The algorithm runs in linear time when b and n are of the same size magnitude, 
so knowing n, b can be manipulated​ to optimize the running time of the algorithm.
'''

import math 

def counting_Sort(A, digit, radix):
    #"A" is a list to be sorted, radix is the base of the number system, digit is the digit
    #we want to sort by

    #create a list B which will be the sorted list
    B = [0]*len(A)
    C = [0]*int(radix)

    #counts the number of occurences of each digit in A 
    for i in range(0, len(A)):
        digit_of_Ai = ((A[i]/radix)**digit)%radix
        C[digit_of_Ai] = C[digit_of_Ai] + 1 
        #now C[i] is the value of the number of elements in A equal to i

    #this FOR loop changes C to show the cumulative # of digits up to that index of C
    for j in range(1,radix):
        C[j] = C[j] + C[j-1]
        #here C is modifed to have the number of elements <= i

    for m in range(len(A)-1, -1, -1): #to count down (go through A backwards)
        digit_of_Ai = (A[m]/radix**digit)%radix
        C[digit_of_Ai] = C[digit_of_Ai] -1
        B[C[digit_of_Ai]] = A[m]

    return B

alist = [9,3,1,4,5,7,7,2,2]
print(counting_Sort(alist,0,10))

def radix_sort(A, radix):
    #radix is the base of the number system
    #k is the largest number in the list
    k = max(A)
    #output is the result list we will build
    output = A
    #compute the number of digits needed to represent k
    digits = int(math.floor(math.log(k, radix)+1))
    for i in range(digits):
        output = counting_Sort(output,i,radix)

    return output

#A = [9,3,1,4,5,7,7,2,20,55]
#A = [10,1,100,8]
#print(radix_sort(A,10))
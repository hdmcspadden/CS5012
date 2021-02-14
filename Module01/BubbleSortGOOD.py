import random
import time

print("*** Running Bubble Sort ***")

n = int(input("Input a number 5000 to 500000\n"))

myArray = list(range(500002))
min = 1
max = 999

for j in range(n + 1):

	myArray[j] = (max - min) * random.random() + min
	
	if j < 20:
	
		print(myArray[j]),
		print(", "),
	
	if j == 50:
	
		print
		
	if j >= n - 19:
	
		print(myArray[j]),
		print(", "),
	
print("\n* * * * * Above is a sample of unsorted random numbers"),
print(" * * * * * * * * * *\n")

startTime = time.perf_counter()

for c in range(n-1):
	for d in range(n-c):
	
		if myArray[d] > myArray[d + 1]:
		
			swap = myArray[d]
			myArray[d] = myArray[d + 1]
			myArray[d + 1] = swap
	
stopTime = time.perf_counter()
elapsedTime = stopTime - startTime

print("After sorting:")

for i in range(n+1):

	if i <= 19:
	
		print(myArray[i]),
		print(","),
		
	if i == 50:
	
		print
		
	if i >= n - 19:
	
		print(myArray[i]),
		print(","),
		
print("\n* * * * * Above is a sample of SORTED numbers"),
print(" * * * * * * * * * *\n")

print("===========================")
print("Elapsed Time (ms) = "),
print(elapsedTime)
print("===========================")
def floyd(A):
    n = len(A)

    # update the distance matrix with the shortest distance from row vertex to column vertex
    for k in range(n):
        for i in range(n):
            for j in range(n):
                # choose the shortest (i.e. minimum) of the current item of interest, or other items in row + other items in rows
                A[i][j] = min(A[i][j], (A[i][k] + A[k][j])) 

    return A
 
# This is the initial distance matrix for a weighted, directed graph.
# 0 indicates that the vertex is traveling from iteself to itself, thus distance is 0
# positive infinity means that you cannot go from the row vertex to the column vertex in one step
# all other numbers in the initial distance matrix indicate the weight (i.e. distance) in one step from the row vertex to the column vertex
adjMatrix = [[0,2,5,float('inf'),float('inf'),float('inf')], \
    [float('inf'),0,7,1,float('inf'),8], \
        [float('inf'),float('inf'),0,4,float('inf'),float('inf')], \
            [float('inf'),float('inf'),float('inf'),0,3,float('inf')], \
                [float('inf'),float('inf'),2,float('inf'),0,3], \
                    [float('inf'),5,float('inf'),2,4,0]]

print("Starting Matrix Representing the Weighted Directed Graph: ")
print(adjMatrix)

print("Ending Matrix Of Shortest Path Lengths: ")
distanceMatrix = floyd(adjMatrix)
print(distanceMatrix)

print("The Shortest Path Is: ")
shortest = ""

n = len(distanceMatrix)

for i in range(n):
    for j in range(n):
        distance = distanceMatrix[i][j]
        if(str(distance) == "inf"):
            distance = "UNREACHABLE"
        print("The shortest path from {0} to {1} is distance {2}".format(i,j, distance))


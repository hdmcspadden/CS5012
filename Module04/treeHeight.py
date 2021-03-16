"""
Activity: MOE 4.3: Building a Binary Tree
Name: H. Diana McSpadden
UID: hdm5s
"""

class BinaryTree:

     # Methods of BinaryTree class below, including the constructor
    def __init__(self, root=None):
        self.root = root # identifying the root of the tree

    def getHeight(self, rootToUse):
        if (rootToUse == None):
            return 0

        if rootToUse.right and rootToUse.left:
             # get height of left node
            leftHeight = self.getHeight(rootToUse.left)
            # get height of right node
            rightHeight = self.getHeight(rootToUse.right)
            if (leftHeight > rightHeight):
                return (1 + leftHeight)
            else:
                return (1 + rightHeight)
        elif rootToUse.left:
            return (1 + self.getHeight(rootToUse.left))
        elif rootToUse.right:
            return (1 + self.getHeight(rootToUse.right))
        else:
            # height is 1 at a leaf, i.e. no children
            return 1 
    
    

    ''' 
    Internal Class Node
    Used to hold properties of each node
    '''
    class Node: # Node class, internal to BinaryTree
        def __init__(self, val, left=None, right=None):
            self.val = val # data item
            self.left = left # left child
            self.right = right # right child
        
        def getVal(self):
            return self.val
        
        def setVal(self,newval):
            self.val = newval
        
        def setLeft(self,newleft):
            self.left = newleft
        def setRight(self,newright):
            self.right = newright

        def getLeft(self):
            return self.left
        
        def getRight(self):
            return self.right

        # find function to determine if a value exists in a node or its subtree
        def find(self, target):
            if (self.val == target):
                return True
            elif(self.left == None and self.right == None):
                # no children return False
                return False
            elif (target > self.val):
                if (self.right):
                    # go right
                    return self.right.find(target)
                else:
                    return False
            else:
                if (self.left):
                    # go left
                    return self.left.find(target)
                else:
                    return False
            # default return Flase
            return False

        
  
    
# create a bunch of nodes with integer values
theRoot = BinaryTree.Node(30) # root node with value 3
n20 = BinaryTree.Node(20)
n10 = BinaryTree.Node(10)
n25 = BinaryTree.Node(25)
n23 = BinaryTree.Node(23)
n27 = BinaryTree.Node(27)
n40 = BinaryTree.Node(40)
n33 = BinaryTree.Node(33)
# create a binary tree called 'myTree'
myTree = BinaryTree(theRoot) # create a tree 'myTree' with root = 3
# connect the tree wihtout n33
myTree.root.setLeft(n20)
myTree.root.setRight(n40)
n20.setLeft(n10)
n20.setRight(n25)
n25.setLeft(n23)
n25.setRight(n27)


# test getHeight
#height = myTree.getHeight(theRoot)
#print(height)

# test find
print(theRoot.find(33))


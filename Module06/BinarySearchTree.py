# -*- coding: utf-8 -*-
"""
H. Diana McSpadden (hdm5s)
Binary Search Tree
Plus tree traversal methods
"""

class Node:

      def __init__(self, data): # Constructor of Node class
            # A node has a data value, a left child node and a right child node
          self.data = data  #data item
          self.left = None  #left child, initially empty
          self.right = None #right child, initially empty


      def __str__(self): # Printing a node

          return str(self.data) #return as string
      
      # find function to determine if a value exists in a node or its subtree
      def find(self, target):
            if (self.data == target):
                return True
            elif(self.left == None and self.right == None):
                # no children return False
                return False
            elif (target > self.data):
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

# ===================================================================
# ===================================================================

class BinarySearchTree:

      def __init__(self): # Constructor of BinarySearchTree class

          self.root = None  # Initially, an empty root node

# ===================================================================
      def buildBST(self, val):  # Build ("create") a binary search tree 

          if self.root == None:

             self.root = Node(val)

          else:

             current = self.root

             while 1:

                 if val < current.data:

                   if current.left:
                      current = current.left  # Go left...
                   else:
                      current.left = Node(val)  # Left child is empty; place value here
                      break;      

                 elif val > current.data:
                 
                    if current.right:
                       current = current.right  # Go right...
                    else:
                       current.right = Node(val)  # Right child is empty; place value here
                       break;      

                 else:             
                    break 


# ===================================================================
      
      def find(self, target):  # Find a node with the 'target' value in the BST
            if (self.root != None):
                  if(self.root.data == target):
                        return True            
                  else:
                        return self.root.find(target)
            else:
                  return False
    

# ===================================================================
      def size(self, node):  # Counts the number of nodes in the BST
            if (node == None):
                  return -1
            elif (node.left and node.right):
                  return 1 + self.size(node.left) + self.size(node.right)
            elif (node.left):
                  return 1 + self.size(node.left)
            elif (node.right):
                   return 1 + self.size(node.right)
            else:
                  return 1

       

  
      def inorder(self, node):  # Performing in-order tree traversal
            if (node):
                  # go left first
                  self.inorder(node.left)
                  # print self value
                  print(node.data)
                  # go right second
                  self.inorder(node.right)

# ===================================================================
      def preorder(self, node):  # Performing pre-order tree traversal
            if (node):
                  # print self value
                  print(node.data)
                  # go left 
                  self.preorder(node.left)
                  # go right
                  self.preorder(node.right)

# ===================================================================
      def postorder(self, node):  # Performing post-order tree traversal
            if (node):
                  # go left 
                  self.postorder(node.left)
                  # go right
                  self.postorder(node.right)
                  # print self value
                  print(node.data)
              
# ===================================================================
                  
                  
##################                  
## Testing Code ##
##################                        
                        
tree = BinarySearchTree()    
treeEmpty = BinarySearchTree()  # Empty tree

arr = [8,3,1,6,4,7,10,14,13]    # Array of nodes (data items)
#arr = [4,5,67,32,100,99,3,8,11,50]
for i in arr:                   # For each data item, build the Binary Search Tree
    tree.buildBST(i)

print('What\'s the size of the tree?')
print(tree.size(tree.root))     # size method

print('What\'s the size of the tree?')
print(treeEmpty.size(treeEmpty.root))

print("") 
print ('In-order Tree Traversal:')
tree.inorder(tree.root)         # Perform in-order tree traversal, and print
 
print("") 
print ('Pre-order Tree Traversal:')
tree.preorder(tree.root)        # Perform pre-order tree traversal, and print

print("")
print ('Post-order Tree Traversal:')
tree.postorder(tree.root)       # Perform post-order tree traversal, and print

print("")
print ('Find 7:', end=" ")      # find method
print(tree.find(7))

print('Find 5:', end=" ")
print(tree.find(5))

print('Find 30:', end=" ")
print(tree.find(30))

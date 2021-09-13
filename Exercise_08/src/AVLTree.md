_references_:- 
https://stackoverflow.com/questions/11497955/why-is-it-important-that-a-binary-tree-b*e-balanced
https://www.crondose.com/2016/08/binary-search-trees-balanced/

Solution
---
1)Explain, what an AVL tree is! Why is it necessary to balance trees?

Ans)
Height balancing binary search tree. AVL tree checks the height of the left and the right sub-trees and assures that the difference is not more than 1. 
This difference is called the Balance Factor.
AVL tree permits difference (balance factor) to be only 1.
The key reason why a BST offers such great performance is because it allows us to ignore irrelevant values. 
Thus decreasing the number of comparisons a program has to perform to find a data element.
The balance of a binary tree is governed by the property called skewness. 
If a tree is more skewed, then the time complexity to access an element of a binary tree increases. 
Say a tree
    1
     \
      2
       \
        3  
         \
          4
           \
            5
             \
              6
               \
                7
The above is also a binary tree, but right skewed. 
It has 7 elements, so an ideal binary tree require O(log 7) = 3 lookups. 
Here you need to go one more level deep = 7 lookups in worst case O(7). 
Consider if the tree has thousands of nodes. The skewness will be even more considerable in that case. 
So it is important to keep the binary tree balanced.

**TODO** show what happens during the insertion of the numbers 14, 17,
19, 7, 5, 10 and 18 (in this order) into an AVL-Tree

step 1:-
14 is inserted
step 2:- add 17

14
  \
   17
   
step3: add 19

14 bf=0-2=-2 --> not balanced
  \
   17 bf =-1
    \
     19 bf=0

step 4 : rotate left to balance making 17 as root

          17 bf=1-1=0
         /  \
bf=0   14    19 bf=0

step 5 : add 7

              17 bf=2-1=1
             /  \
    bf=1   14    19 bf=0
          /
bf=0     7 

step 6 : add 5

                  17 
  (Not Balanced)/  \
    bf=2-0=2  14    19 bf=0
              /
      bf=1   7 
            /
    bf=0   5 
    
step 7 : rotate right to balance making 14 as root

                 14  bf =2-2=0
                /  \
    bf=1       7    17 bf=-1
              /      \
      bf=0   5        19 bf=0

step 8 : add 10

                 14  bf =2-2=0
                /  \
    bf=0       7    17 bf=-1
              / \     \
      bf=0   5   10    19 bf=0
      
step 9 : add 18

                 14  bf =2-2=0
                /  \
    bf=0       7    17 bf=0-2=-2   ----> not balanced
              / \     \
      bf=0   5   10    19 bf=1
                      /
                    18 bf=0
                    
step 10 : right rotation of making 18 parent of 19

                 14  bf =2-2=0
                /  \
    bf=0       7    17 bf=0-2=-2   ----> still not balanced
              / \     \
      bf=0   5   10    18 bf=-1
                        \
                         19 bf=0
                         
step 11 : left rotation of making 18 parent of 17 

                  14  bf =2-2=0
                /    \
    bf=0      7       18 bf=0  
             / \     /  \
      bf=0  5   10  17   19 bf=0

Now the tree is balanced
                         
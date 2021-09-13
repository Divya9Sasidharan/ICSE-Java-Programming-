Red-Black-Tree
---

**What is a red-black tree? Which properties does it have?**
A red–black tree is a special type of binary tree.The leaf nodes of red–black trees do not contain data. 
colors ensure that tree remains balanced during insertion and deletion operations.
Height of red-black tree is always O(log n). Here n is the number of nodes in the tree. 
properties:
    -Each node is  red or black.
    -The root is black.
    -No two adjacent red nodes.(ie a red node cannot have red parent or child)
    -leaves "NULL" are black.
    -If node is red, then its children are black.
    -Every path from a node to any of its descendant NULL nodes have the same number of black nodes.

**Insert the following sequence of number into a red-black tree:  
[6,7,3,4,2,1]! Als, show all important intermediate steps.**

step1:-
insert 6 with color black

step2:-
insert 7 with red color
    6(b)
     \
      7(r)
      
step3:-
insert 3 with red color
            6(b)
           /  \
        3(r)   7(r)

step4:-
insert 4 with red color
            6(b)
           /  \
        3(r)   7(r)
           \ ---> red-red violation
            4(r) 

step5:-
recolor red parent and red parent's sibling to black 3(r)   7(r)--> 3(b)   7(b)
            6(b)
           /  \
        3(b)   7(b)
           \
            4(r)  
            
step6:-
insert 2 with red color
            6(b)
           /  \
        3(b)   7(b)
       /   \
    2(r)   4(r)  
    
step7:-
insert 1 with red color
            6(b)
           /  \
        3(b)   7(b)
       /   \
    2(r)   4(r) 
    /  ---> red-red violation  
  1(r)  
  
step8a:-
recolor red parent and red parent's sibling to black 2(r)   4(r)  --> 2(b)   4(b)
            6(b)
           /  \
        3(b)   7(b)
       /   \
    2(b)   4(b) 
    /           ---> count of black nodes i each path violation  
  1(r)

step8b:-
recolor parent's parent node if not root node 3(b)-> 3(r)
            6(b)
           /  \
        3(r)   7(b)
       /   \
    2(b)   4(b) 
    /           
  1(r)
       
**When do red-red violation occur? How does the final tree look like?**
when two adjacent red nodes occurs.(ie a red node cannot have red parent or child).
            6(b)
           /  \
        3(r)   7(b)
       /   \
    2(b)   4(b) 
    /           
  1(r)


**For comparison, create an AVL tree from the same sequence of numbers: 
[6,7,3,4,2,1]Compare the two trees!**

The AVL trees are more balanced compared to Red-Black Trees, but have more rotations during insertion and deletion. 
If there are frequent insertions and deletions, then red-black trees should be preferred. 
If search is a more frequent operation, then AVL tree should be preferred.

step1:-
add 6

step2:-
add 7
 6 bf=0-1=-1
  \
   7 bf=0
   
step3:-
add 3
            6 bf=0 
           / \
          3   7 bf=0 
          
step4:-
insert 4 
                6 bf=2-1=1
               / \
   bf=0-1=-1  3   7 bf=0 
               \ 
                4 bf=0 
step5:-
insert 2 
                6 bf=2-1=1
               / \
   bf=1-1=0   3   7 bf=0 
             / \ 
            2    4 bf=0 

step6:-
insert 1 
                6 bf=3-1=2 ---> not allowed
               / \
   bf=2-1=1   3   7 bf=0 
             / \ 
 bf=1-0=1   2    4 bf=0 
           /
          1 bf=0
step7:-
right rotate
                3 bf=0 
               / \
   bf=1-1=0   2   6 bf=-1 
             / \   \
 bf=0       1   4   7 bf=0 
           

**(2,4)trees can be represented by red-black trees. What different (sub)structures correspond to each other?**
 2-3-4 tree  --------------------> red-black tree.

 a (2 node) tree ----------------> a (2 node) tree 
/ \                               / \

 a|b (3 node) ------------------->  a(b)   or    b(b)
/ | \                              / \           /  \
                                      b(r)     a(r) 
                                     / \       /  \

 a|b|c (4 node)  ----------------->    b(b)                                 
/ | | \                                /  \
                                     a(r) c(r)
                                     / \   / \
                                     
**Transform the red-black tree into its corresponding (2,4)tree!**
             6(b)
            /  \
         3(r)   7(b)
        /   \
     2(b)   4(b) 
     /           
   1(r)
           ||
           ||
           || 
           
 (2,4)tree of above red-black tree--> By merging every red node with its parent
         3 | 6        
        /  |  \
      1|2  4   7
   

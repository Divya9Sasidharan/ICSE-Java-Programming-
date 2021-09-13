Solution
---
**What is a (2,4) tree?**

Multi-way Search Trees
Each internal node of a multi-way search tree T:
- has at least two children
- stores a collection of items of the form (k, x), where k is a key and x is an element
- contains d - 1 items, where d is the number of children

Children of each internal node are “between” items
- all keys in the subtree rooted at the child fall between keys of those items

(2,4) Trees is Multi-way Search Tree
• At most 4 children
• All external nodes have same depth 
• Height h of (2,4) tree is O(logn).

**show what happens during the insertion of the numbers 3, 7,
5, 15, 17, 9, 13, 21, 11 and 19 (in this order) into an 2-3-4-Tree**

step 1:-
3 is inserted

step2:-
7 is inserted at parent
3|7

step3:-
5 is inserted at parent
3|5|7

step4:-
15 is inserted at parent
3|5|7|15 ---> this is not allowed

step5:-
7 is inserted as parent
                7
               / \
            3|5   15
            
step6:-
17 is inserted at leaf
                7
               / \
            3|5   15|17
            
step7:-
9 is inserted at leaf
                7
               / \
            3|5   9|15|17
            
step8:-
13 is inserted at leaf
                7
               / \
            3|5   9|13|15|17 ---> this is not allowed
            
step9:-
15 is inserted at parent
                7|15
               / |  \
              /  |   \
           3|5  9|13  17 

step10:-
12 is inserted at leaf
                7|15
               / |  \
              /  |   \
           3|5  9|13  17|21 
           
step11:-
11 is inserted at leaf
               7 | 15                
             /   |    \
            /    |     \
         3|5  9|11|13  17|21 
           
step12:-
19 is inserted at leaf
               7 | 15                
             /   |    \
            /    |     \
         3|5  9|11|13  17|19|21 

**show what happens during the insertion of the numbers 3, 5,
7, 9, 11, 13, 15, 17, 19 and 21 (in this order) into an 2-3-4-Tree**

step 1:-
3 is inserted

step2:-
5 is inserted at parent
3|5

step3:-
7 is inserted at parent
3|5|7

step4:-
9 is inserted at parent
3|5|7|9 ---> this is not allowed

step5:-
7 is inserted as parent
                7
               / \
            3|5   9

step6:-
11 is inserted at leaf
                7
               / \
            3|5   9|11
            
step7:-
13 is inserted at leaf
                7
               / \
            3|5   9|11|13
            
step8:-
15 is inserted at leaf
                7
               / \
            3|5   9|11|13|15 ---> this is not allowed
            
step9:-
13 is inserted at parent
                7|13
               / |  \
              /  |   \
           3|5  9|11  15
           
step10:-
17 is inserted at leaf
                7|13
               / |  \
              /  |   \
           3|5  9|11  15|17
           
           
step11:-
19 is inserted at leaf
                7|13
               / |  \
              /  |   \
           3|5  9|11  15|17|19
           
step12:-
21 is inserted at leaf
                7|13
               / |  \
              /  |   \
           3|5  9|11  15|17|19|21 ---> this is not allowed
           
step13:-
19 is inserted at parent
              7  | 13  |  19
              /  |     |   \
             /   |     |    \
           3|5  9|11  15|17  21 


**What differences to you see?**         
First order results in better case and takes less operations . 
In worst case (the tree is as high as possible) then all nodes are 2-nodes.
Best case is then all nodes are 4-nodes.
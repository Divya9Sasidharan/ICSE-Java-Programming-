*** file for solution ***

 
###### references:-
            
            https://medium.com/@sohailk1999/why-binary-search-is-preferred-over-ternary-search-4e554e91a92b            
            https://www.geeksforgeeks.org/binary-insertion-sort/
===============================================

1)Binary Search sub-divides a list of elements into two equal-sized parts. This leads to an overall complexity of O(log2n)
  . It is not unreasonable to think that dividing into three parts should lead to an overall complexity of O(log3n)
  . This algorithm would be called Ternary Search. However, it is almost never used. Why?
  
Answer)

    After each iteration Ternary Search neglects ⅓ part of the array and repeats the same operations on the remaining ⅔.
    If you apply binary search, you have log2(𝑛)+𝑂(1)many comparisons. 
    If you apply ternary search, you have 2⋅log3(𝑛)+𝑂(1) many comparisons, 
    as in each step, you need to perform 2 comparisons to cut the search space into three parts.
    
    2⋅log3(𝑛)+𝑂(1)=2⋅(log(2)/log(3))log2(𝑛)+𝑂(1).
    since 2⋅(log(2)/log(3))>1, we need more comparisons with ternary search.


2)Explain the two different sorting algorithms insertion sort and selection sort in your own words. Point out the differences.

Answer)

    insertion sort:-
     1) Given a list, take the current element and insert it at the appropriate position of the list, slidding over  the list every time you insert. 
     2) stable-it does not change the order of elements with equal keys.
     3) Has the O(n) time complexity in the best case.Hence very efficient with small dataset.
     
     In n elements array, initially, the element with index 0 exists in the sorted set. Remaining elements are assumed to be  as unsorted partition of the list.
     At the end of each iteration, the first element of the unsorted list is inserted it into the proper position in the sorted set.
    
    selection sort:-
     1) The Selection sort perform sorting by searching for the minimum value number and placing it into the first or last position according to the order (ascending or descending). 
     The process of searching the minimum key and placing it in the proper position is continued until the all the elements are placed at right position.
     2) unstable. Moves each element at most once.
     3) Has the O(n2) time complexity in the best case.
     
     Suppose we have an array of n elements .
     In the first pass, the smallest element is searched  and swapped with position 0 element. Therefore, array[0] is sorted.
     In the second pass, again the find  smallest value in the subarray of n-1 elements. Interchange the it with array[1].
     The same process is done to sort the n number of elements and will require n-1 passes.
     

3)Which of the two sorting algorithms is stable? Justify your answer.

Answer)     
        
    insertion is stable .It does not change the order of elements with equal keys.
    where as selection is unstable as it moves each element at most once.


4)Consider the following change of the insertion sort algorithm: 
How does the overall time complexity change if instead of searching for the place to insert an element by linear search we used binary search instead? Justify your answer!

Answer)

    Binary Search can reduce the number of comparisons.
    when using binary search we find the proper location to insert the selected item at each iteration.
    In normal insertion sort, it takes O(n) comparisons (at nth iteration) in the worst case. 
    We can reduce it to O(log n) by using binary search.
    
    


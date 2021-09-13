/*
* reference :- https://beginnersbook.com/2017/08/comparable-interface-in-java-with-example/
* reference:- https://www.javatpoint.com/Comparable-interface-in-collection-framework
* Comparable interface is mainly used to sort the arrays (or lists) of custom objects.
* Lists (and arrays) of objects that implement Comparable interface can be sorted automatically by Collections.sort
* (and Arrays.sort)
*
* */

import java.util.Arrays;

public class Food implements Comparable<Food> { // Interfaces AND Generics, OMG!
    int calories;
    String type;
    // Do not remove something from this array, but you may add to it...
    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};
    
    public Food(String type, int calories) {
        // TODO: only allow objects of types that are listed in TYPES
        this.calories=calories;
        this.type=type;

    }
    public String toString(){
         // TODO: return a String with the attributes
        return type + ":" + calories;
    }
    public int compareTo(Food o) {
        /*
        * Returns:
        * a negative integer, zero, or a positive integer
        * as this object is less than, equal to, or greater than
        * the specified object.
        *
        * */
        int value1=type.length()*calories;
        int value2=o.type.length()*o.calories;
        if(value1 == value2)
            return 0;
        else if (value1>value2)
            return 1;
        else
            return -1;
    }
    
    public String getType() {
        return type;
    }
    
    public int getCalories() {
        return calories;

    }
    public static int[] createRandom(int n) {
        int rand_number[] = new int[n];
        int max = 200;
        int min = 50;
        for (int i = 0; i < n; i++) {
            rand_number[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
        }
        System.out.println(Arrays.toString(rand_number));
        return rand_number;
    }
    
    public static Food[] createSortedRandomList(int n) {
        int[] calories= createRandom(TYPES.length);
        Food[] foodList= new Food[n];
        for (int i = 0; i < n ; i++) {
            int rand = (int) (TYPES.length * Math.random());
            foodList[i] = new Food(TYPES[rand],calories[rand]);
        }
        Arrays.sort(foodList);
        return foodList;
    }

    public static void main(String[] args) {
        Food[] newFoodList = Food.createSortedRandomList(9);
        for(Food f:newFoodList) {
            System.out.println(f.toString());

        }
    }

}

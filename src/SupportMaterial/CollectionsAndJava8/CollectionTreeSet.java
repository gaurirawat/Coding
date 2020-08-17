package SupportMaterial.CollectionsAndJava8;

import java.util.Iterator;
import java.util.TreeSet;

/*
add() - inserts the specified element to the set
addAll() - inserts all the elements of the specified collection to the set

remove() - removes the specified element from the set
removeAll() - removes all the elements from the set

first() - returns the first element of the set
last() - returns the last element of the set

higher(element) - Returns the lowest element among those elements that are greater than the specified element.
lower(element) - Returns the greatest element among those elements that are less than the specified element.
ceiling(element) - Returns the lowest element among those elements that are greater than the specified element. If the element passed exists in a tree set, it returns the element passed as an argument.
floor(element) - Returns the greatest element among those elements that are less than the specified element. If the element passed exists in a tree set, it returns the element passed as an argument.

pollFirst() - returns and removes the first element from the set
pollLast() - returns and removes the last element from the set

The headSet() method returns all the elements of a tree set before the specified element (which is passed as an argument). The booleanValue parameter is optional. Its default value is false.
The tailSet() method returns all the elements of a tree set after the specified element (which is passed as a parameter) including the specified element. The booleanValue parameter is optional. Its default value is true.

addAll()- To perform the union between two sets, we use the addAll() method.
retainAll()- To perform the intersection between two sets, we use the retainAll() method

clone()- Creates a copy of the TreeSet
contains()- Searches the TreeSet for the specified element and returns a boolean result
isEmpty()- Checks if the TreeSet is empty
size()- Returns the size of the TreeSet
clear()- Removes all the elements from the TreeSet

Both the TreeSet as well as the HashSet implements the Set interface. However, there exist some differences between them.
Unlike HashSet, elements in TreeSet are stored in some order. It is because TreeSet implements the SortedSet interface as well.
TreeSet provides some methods for easy navigation. For example, first(), last(), headSet(), tailSet(), etc. It is because TreeSet also implements the NavigableSet interface.
HashSet is faster than the TreeSet for basic operations like add, remove, contains and size.

*/

public class CollectionTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);

        // Calling iterator() method
        Iterator<Integer> iterate = numbers.iterator();
        System.out.print("TreeSet using Iterator: ");
        // Accessing elements
        while (iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
/*
    remove() - removes the specified element from the set
    removeAll() - removes all the elements from the set
 */
        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        // Using the removeAll() method
        boolean value2 = numbers.removeAll(numbers);
        System.out.println("Are all elements removed? " + value2);

/*
    first() - returns the first element of the set
    last() - returns the last element of the set
*/
        // Using the first() method
        int first = numbers.first();
        System.out.println("First Number: " + first);

        // Using the last() method
        int last = numbers.last();
        System.out.println("Last Number: " + last);

/*
    higher(element) - Returns the lowest element among those elements that are greater than the specified element.
    lower(element) - Returns the greatest element among those elements that are less than the specified element.
    ceiling(element) - Returns the lowest element among those elements that are greater than the specified element. If the element passed exists in a tree set, it returns the element passed as an argument.
    floor(element) - Returns the greatest element among those elements that are less than the specified element. If the element passed exists in a tree set, it returns the element passed as an argument.
*/
        // Using higher()
        System.out.println("Using higher: " + numbers.higher(4));

        // Using lower()
        System.out.println("Using lower: " + numbers.lower(4));

        // Using ceiling()
        System.out.println("Using ceiling: " + numbers.ceiling(4));

        // Using floor()
        System.out.println("Using floor: " + numbers.floor(3));

/*
    pollFirst() - returns and removes the first element from the set
    pollLast() - returns and removes the last element from the set
 */
        // Using pollFirst()
        System.out.println("Removed First Element: " + numbers.pollFirst());

        // Using pollLast()
        System.out.println("Removed Last Element: " + numbers.pollLast());

/*
    The headSet() method returns all the elements of a tree set before the specified element (which is passed as an argument). The booleanValue parameter is optional. Its default value is false.
    If true is passed as a booleanValue, the method returns all the elements before the specified element including the specified element.
 */
        // Using headSet() with default boolean value
        System.out.println("Using headSet without boolean value: " + numbers.headSet(5));

        // Using headSet() with specified boolean value
        System.out.println("Using headSet with boolean value: " + numbers.headSet(5, true));

        // Using tailSet() with default boolean value
        System.out.println("Using tailSet without boolean value: " + numbers.tailSet(4));

        // Using tailSet() with specified boolean value
        System.out.println("Using tailSet with boolean value: " + numbers.tailSet(4, false));

/*
    addAll()- To perform the union between two sets, we use the addAll() method.
    retainAll()- To perform the intersection between two sets, we use the retainAll() method
 */
        TreeSet<Integer> evenNumbers = new TreeSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("TreeSet1: " + evenNumbers);

        // Union of two sets
        numbers.addAll(evenNumbers);
        System.out.println("Union is: " + numbers);

        // Intersection of two sets
        numbers.retainAll(evenNumbers);
        System.out.println("Intersection is: " + numbers);

    }
}

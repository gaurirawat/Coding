package SupportMaterial.CollectionsAndJava8;

import java.util.*;
//https://www.programiz.com/java-programming/treemap

/*
    Access TreeMap Elements
    Using entrySet(), keySet() and values()
    entrySet() - returns a set of all the key/values mapping (entry) of a treemap
    keySet() - returns a set of all the keys of a tree map
    values() - returns a set of all the maps of a tree map

    get() - Returns the value associated with the specified key. Returns null if the key is not found.
    getOrDefault() - Returns the value associated with the specified key. Returns the specified default value if the key is not found.

    remove(key) - returns and removes the entry associated with the specified key from a TreeMap
    remove(key, value) - removes the entry from the map only if the specified key is associated with the specified value and returns a boolean value

    replace(key, value) - replaces the value mapped by the specified key with the new value
    replace(key, old, new) - replaces the old value with the new value only if the old value is already associated with the specified key
    replaceAll(function) - replaces each value of the map with the result of the specified function

    First and Last Methods
    firstKey() - returns the first key of the map
    firstEntry() - returns the key/value mapping of the first key of the map
    lastKey() - returns the last key of the map
    lastEntry() - returns the key/value mapping of the last key of the map

    higherKey() - Returns the lowest key among those keys that are greater than the specified key.
    higherEntry() - Returns an entry associated with a key that is lowest among all those keys greater than the specified key.
    lowerKey() - Returns the greatest key among all those keys that are less than the specified key.
    lowerEntry() - Returns an entry associated with a key that is greatest among all those keys that are less than the specified key.
    ceilingKey() - Returns the lowest key among those keys that are greater than the specified key. If the key passed as an argument is present in the map, it returns that key.
    ceilingEntry() - Returns an entry associated with a key that is lowest among those keys that are greater than the specified key. It an entry associated with the key passed an argument is present in the map, it returns the entry associated with that key.
    floorKey() - Returns the greatest key among those keys that are less than the specified key. If the key passed as an argument is present, it returns that key.
    floorEntry() - Returns an entry associated with a key that is greatest among those keys that are less than the specified key. If the key passed as argument is present, it returns that key.

    pollFirstEntry() and pollLastEntry() Methods
    pollFirstEntry() - returns and removes the entry associated with the first key of the map
    pollLastEntry() - returns and removes the entry associated with the last key of the map

    headMap(key, booleanValue)
    The headMap() method returns all the key/value pairs of a treemap before the specified key (which is passed as an argument).
    The booleanValue parameter is optional. Its default value is false.
    If true is passed as a booleanValue, the method also includes the key/value pair of the key which is passed as an argument.

    tailMap(key, booleanValue)
    The tailMap() method returns all the key/value pairs of a treemap starting from the specified key (which is passed as an argument).
    The booleanValue is an optional parameter. Its default value is true.
    If false is passed as a booleanValue, the method doesn't include the key/value pair of the specified key.

    subMap(k1, bV1, k2, bV2)
    The subMap() method returns all the entries associated with keys between k1 and k2 including the entry of k1.
    The bV1 and bV2 are optional boolean parameters. The default value of bV1 is true and the default value of bV2 is false.
    If false is passed as bV1, the method returns all the entries associated with keys between k1 and k2 without including the entry of k1.
    If true is passed as bV2, the method returns all the entries associated with keys between k1 and k2 including the entry of k2.

    clone(): Creates a copy of the TreeMap
    containsKey(): Searches the TreeMap for the specified key and returns a boolean result
    containsValue(): Searches the TreeMap for the specified value and returns a boolean result
    size(): Returns the size of the TreeMap
    clear(): Removes all the entries from the TreeMap

 */
public class CollectionTreeMap {
    public static void main(String[] args) {
        // Creating TreeMap of even numbers
        TreeMap<String, Integer> evenNumbers = new TreeMap<>();

        // Using put()
        evenNumbers.put("Two", 2);
        evenNumbers.put("Four", 4);

        // Using putIfAbsent()
        evenNumbers.putIfAbsent("Six", 6);
        System.out.println("TreeMap of even numbers: " + evenNumbers);

        //Creating TreeMap of numbers
        TreeMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("One", 1);

        // Using putAll()
        numbers.putAll(evenNumbers);

/*
    Access TreeMap Elements
    Using entrySet(), keySet() and values()
    entrySet() - returns a set of all the key/values mapping (entry) of a treemap
    keySet() - returns a set of all the keys of a tree map
    values() - returns a set of all the maps of a tree map
*/
        // Using entrySet()
        System.out.println("Key/Value mappings: " + numbers.entrySet());

        // Using keySet()
        System.out.println("Keys: " + numbers.keySet());

        // Using values()
        System.out.println("Values: " + numbers.values());
/*
    get() - Returns the value associated with the specified key. Returns null if the key is not found.
    getOrDefault() - Returns the value associated with the specified key. Returns the specified default value if the key is not found.
*/
        // Using get()
        int value1 = numbers.get("Three");
        System.out.println("Using get(): " + value1);

        // Using getOrDefault()
        int value2 = numbers.getOrDefault("Five", 5);
        System.out.println("Using getOrDefault(): " + value2);
/*
    remove(key) - returns and removes the entry associated with the specified key from a TreeMap
    remove(key, value) - removes the entry from the map only if the specified key is associated with the specified value and returns a boolean value
 */

        // remove method with single parameter
        int value = numbers.remove("Two");
        System.out.println("Removed value: " + value);

        // remove method with two parameters
        boolean result = numbers.remove("Three", 3);
        System.out.println("Is the entry {Three=3} removed? " + result);

/*
    replace(key, value) - replaces the value mapped by the specified key with the new value
    replace(key, old, new) - replaces the old value with the new value only if the old value is already associated with the specified key
    replaceAll(function) - replaces each value of the map with the result of the specified function

 */
        // Using replace()
        numbers.replace("Second", 22);
        numbers.replace("Third", 3, 33);
        System.out.println("TreeMap using replace: " + numbers);

        // Using replaceAll()
        numbers.replaceAll((key, oldValue) -> oldValue + 2);
        System.out.println("TreeMap using replaceAll: " + numbers);

/*
    First and Last Methods
    firstKey() - returns the first key of the map
    firstEntry() - returns the key/value mapping of the first key of the map
    lastKey() - returns the last key of the map
    lastEntry() - returns the key/value mapping of the last key of the map
 */
        // Using the firstKey() method
        String firstKey = numbers.firstKey();
        System.out.println("First Key: " + firstKey);

        // Using the lastKey() method
        String lastKey = numbers.lastKey();
        System.out.println("Last Key: " + lastKey);

        // Using firstEntry() method
        System.out.println("First Entry: " + numbers.firstEntry());

        // Using the lastEntry() method
        System.out.println("Last Entry: " + numbers.lastEntry());

/*
    higherKey() - Returns the lowest key among those keys that are greater than the specified key.
    higherEntry() - Returns an entry associated with a key that is lowest among all those keys greater than the specified key.
    lowerKey() - Returns the greatest key among all those keys that are less than the specified key.
    lowerEntry() - Returns an entry associated with a key that is greatest among all those keys that are less than the specified key.
    ceilingKey() - Returns the lowest key among those keys that are greater than the specified key. If the key passed as an argument is present in the map, it returns that key.
    ceilingEntry() - Returns an entry associated with a key that is lowest among those keys that are greater than the specified key. It an entry associated with the key passed an argument is present in the map, it returns the entry associated with that key.
    floorKey() - Returns the greatest key among those keys that are less than the specified key. If the key passed as an argument is present, it returns that key.
    floorEntry() - Returns an entry associated with a key that is greatest among those keys that are less than the specified key. If the key passed as argument is present, it returns that key.

    Result for the lower print statements
    TreeMap: {First=1, Fourth=6, Second=5, Third=4}
    Using higherKey(): Second
    Using higherEntry(): Second=5

    Using lowerKey(): First
    Using lowerEntry(): First=1

    Using ceilingKey(): Fourth
    Using ceilingEntry(): Fourth=6

    Using floorkey(): Fourth
    Using floorEntry(): Fourth=6
*/
        numbers = new TreeMap<>();
        numbers.put("First", 1);
        numbers.put("Second", 5);
        numbers.put("Third", 4);
        numbers.put("Fourth", 6);
        System.out.println("TreeMap: " + numbers);

        // Using higher()
        System.out.println("Using higherKey(): " + numbers.higherKey("Fourth"));
        System.out.println("Using higherEntry(): " + numbers.higherEntry("Fourth"));

        // Using lower()
        System.out.println("\nUsing lowerKey(): " + numbers.lowerKey("Fourth"));
        System.out.println("Using lowerEntry(): " + numbers.lowerEntry("Fourth"));

        // Using ceiling()
        System.out.println("\nUsing ceilingKey(): " + numbers.ceilingKey("Fourth"));
        System.out.println("Using ceilingEntry(): " + numbers.ceilingEntry("Fourth"));

        // Using floor()
        System.out.println("\nUsing floorKey(): " + numbers.floorKey("Fourth"));
        System.out.println("Using floorEntry(): " + numbers.floorEntry("Fourth"));

/*
    pollFirstEntry() and pollLastEntry() Methods
    pollFirstEntry() - returns and removes the entry associated with the first key of the map
    pollLastEntry() - returns and removes the entry associated with the last key of the map
 */
        //Using the pollFirstEntry() method
        System.out.println("Using pollFirstEntry(): " + numbers.pollFirstEntry());

        // Using the pollLastEntry() method
        System.out.println("Using pollLastEntry(): " + numbers.pollLastEntry());

        System.out.println("Updated TreeMap: " + numbers);

/*
    headMap(key, booleanValue)
    The headMap() method returns all the key/value pairs of a treemap before the specified key (which is passed as an argument).
    The booleanValue parameter is optional. Its default value is false.
    If true is passed as a booleanValue, the method also includes the key/value pair of the key which is passed as an argument.

    TreeMap: {First=1, Fourth=4, Second=2, Third=3}
    Using headMap() Method:
    Without boolean value: {First=1}
    With boolean value: {First=1, Fourth=4}
 */
        // Using headMap() with default booleanValue
        System.out.println("Without boolean value: " + numbers.headMap("Fourth"));

        // Using headMap() with specified booleanValue
        System.out.println("With boolean value: " + numbers.headMap("Fourth", true));

/*
    tailMap(key, booleanValue)
    The tailMap() method returns all the key/value pairs of a treemap starting from the specified key (which is passed as an argument).
    The booleanValue is an optional parameter. Its default value is true.
    If false is passed as a booleanValue, the method doesn't include the key/value pair of the specified key.

    Using tailMap() Method:
    Without boolean value: {Second=2, Third=3}
    With boolean value: {Third=3}
 */

        // Using tailMap() with default booleanValue
        System.out.println("Without boolean value: " + numbers.tailMap("Second"));

        // Using tailMap() with specified booleanValue
        System.out.println("With boolean value: " + numbers.tailMap("Second", false));

/*
    subMap(k1, bV1, k2, bV2)
    The subMap() method returns all the entries associated with keys between k1 and k2 including the entry of k1.
    The bV1 and bV2 are optional boolean parameters. The default value of bV1 is true and the default value of bV2 is false.
    If false is passed as bV1, the method returns all the entries associated with keys between k1 and k2 without including the entry of k1.
    If true is passed as bV2, the method returns all the entries associated with keys between k1 and k2 including the entry of k2.

    Using subMap() Method:
    Without boolean value: {Fourth=4, Second=2}
    With boolean value: {Second=2, Third=3}
*/
        // Using subMap() with default booleanValue
        System.out.println("Without boolean value: " + numbers.subMap("Fourth", "Third"));

        // Using subMap() with specified booleanValue
        System.out.println("With boolean value: " + numbers.subMap("Fourth", false, "Third", true));

/*
    MethodDescription
    clone(): Creates a copy of the TreeMap
    containsKey(): Searches the TreeMap for the specified key and returns a boolean result
    containsValue(): Searches the TreeMap for the specified value and returns a boolean result
    size(): Returns the size of the TreeMap
    clear(): Removes all the entries from the TreeMap
 */
    }
}

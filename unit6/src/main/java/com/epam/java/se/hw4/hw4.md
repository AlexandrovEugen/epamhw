|         |Base functionality                          |Examples of typical use                                         |
|--------:|-------------------------------------------:|---------------------------------------------------------------:| 
| Set<E>  | boolean contains(Object object);           | Useful for storing a collection of elements without duplicates.| 
|         | void add(E element); boolean isEmpty();    |                                                                |
|         | int size(); void remove(E elem);           |                                                                |
|         |                                            |                                                                | 
| List<E> | void add(E element); E get(int index);     | Useful for storing elements with fast access to them by index. |
|         | int size();                                | Elements are storing in order in which they were inserted to   |
|         |                                            | List.                                                          |
|         | boolean contains(Object); boolean isEmpty()| Most useful collection in java.                                |
|         |                                            |                                                                |
|         |                                            |                                                                |
| Queue<E>| void add(E element); E element();          |Useful in case of if you need to implement queue model:         |        |                                                                |
|         | boolean isEmpty(); E poll(); E remove();   |Access to elements realized in FIFO mode.                       |                                         |
|         |                                            |                                                                |
|         |                                            |                                                                |
| Map<K,V>| Set<K> keySet(); Collections<V> values();  |Useful collection for storing key-value pairs and provides quick|     
|         | put(K key,V value); V get(K key);          |access to value by their key.                                    |
|         | boolean isEmpty(); int size();             |                                                                |

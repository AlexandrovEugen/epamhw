|         |Base functionality                          |Examples of typical use                                         |
|--------:|-------------------------------------------:|---------------------------------------------------------------:| 
| Set<E>  | boolean contains(Object object);           | Useful for storing a collection of elements without duplicates.| 
|         | void add(E element); boolean isEmpty();    |
|         | int size(); void remove(E elem);           |
|         |                                            |
| List<E> | void add(E element); E get(int index);     | Useful for storing elements with fast access to them by index. |
|         | boolean contains(Object); boolean isEmpty()| It's dynamically|
|         | int size();                                ||
|         |                                            ||
|         |                                            ||
| Queue<E>| void add(E element); E element();          ||
|         | boolean isEmpty(); E poll(); E remove();   ||
|         |                                            ||
|         |                                            ||
| Map<K,V>| Set<K> keySet(); Collections<V> values();  || 
|         | put(K key,V value); V get(K key);          ||
|         | boolean isEmpty(); int size();             ||
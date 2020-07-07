package estructuraDatos;

public class HashTable<T>{
    
    public class LinkedHashEntry<T>{

      private int key;
      private T value;
      private LinkedHashEntry next;

      LinkedHashEntry(int key, T value) {

            this.key = key;
            this.value = value;
            this.next = null;
      }

      public T getValue() {
            return value;
      }

      public void setValue(T value) {
            this.value = value;
      }
 
      public int getKey() {
            return key;
      }

      public LinkedHashEntry getNext() {
            return next;
      }

      public void setNext(LinkedHashEntry next) {
            this.next = next;
      }

    }
    
    public class HashMap {
      public final static int TABLE_SIZE = 128;
      LinkedHashEntry[] table; 

      public HashMap() {
          table = new LinkedHashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
              table[i] = null;
      }

      public T get(int key) {
          
          Object temp = new Object();
          
          
            int hash = (key % TABLE_SIZE);
            if (table[hash] == null)          
                  return (T) temp;
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry == null)
                        return (T) temp;
                  else
                        return (T) entry.getValue();
            }
      }

      public void put(int key, T value) {
            int hash = (key % TABLE_SIZE);
            if (table[hash] == null)
                  table[hash] = new LinkedHashEntry(key, value);
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry.getNext() != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry.getKey() == key)
                        entry.setValue(value);
                  else
                        entry.setNext(new LinkedHashEntry(key, value));
            }
      }

      public void delete(int key) {
            int hash = (key % TABLE_SIZE);
            if (table[hash] != null) {
                  LinkedHashEntry prevEntry = null;
                  LinkedHashEntry entry = table[hash];
                  while (entry.getNext() != null && entry.getKey() != key) {
                        prevEntry = entry;
                        entry = entry.getNext();
                  }

                  if (entry.getKey() == key) {
                        if (prevEntry == null)
                             table[hash] = entry.getNext();
                        else
                             prevEntry.setNext(entry.getNext());
                  }
            } 
        }
    }    
}
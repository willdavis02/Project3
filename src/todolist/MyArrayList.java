package todolist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
	private T[] elements;
	private int size = 0; 
	private static final int DEFAULT_CAPACITY = 10;
	
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		elements = (T[])new Comparable[DEFAULT_CAPACITY];
		
	}
	private void doubleCapacity() {
		int newSize = elements.length*2;
		elements= Arrays.copyOf(elements, newSize);
		
	}
	public boolean add(T element) {
		if(elements.length == size) {
			doubleCapacity();
		}
		
		
		elements[size++]=element;
		return true;
	}
	@Override
	public String toString() {
		String s = "[";
		for(int i = 0; i<size; i++) {
			s+= elements[i];
			if(i<size -1) {
				s+= ", ";
			}
			
		}
		s+="]";
		return s;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T set(int index, T element) { 
		checkIndex(index);
		T oldValue = elements[index]; 
		elements[index] = element; 
		return oldValue;
	}
	 
	public T get(int index) {
		checkIndex(index);
		return elements[index];
	}
	private void checkIndex(int index) {
		if(index<0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	public boolean contains(T element) { 
		return indexOf(element) >= 0;
	}
    private int indexOf(T element) {
    	if (element == null) {
    		for (int i = 0; i < size; i++) {
    			if (elements[i] == null) {
    				return i;
                }
            }
         } 
        else {
        	for (int i = 0; i < size; i++)
        		if (element.equals(elements[i]))
        			return i;
        }
        return -1;
    }
    
    public boolean remove(int index) {
    	if(index<0||index>=size) {
    		return false;
    	}
    	
    	for(int i=index; i<size-1; i++) {
    		elements[i]= elements[i+1];
    	}
    	elements[size-1]= null;
    	size--;
    	return true;
    }
    public boolean remove(T element) {
    	int index=indexOf(element);
    	if (index == -1) {
    		return false;
    	}
    	for (int i = index; i < size - 1; i++) {
    		elements[i] = elements[i + 1];
    	}	
        elements[size - 1] = null;
        size--;
        return true;
    }	
    @Override
    public Iterator<T> iterator() {
    	return new MyIterator();
    }
    private class MyIterator implements Iterator<T> {
    	private int cursor = 0;

        @Override
        public boolean hasNext() {
        	return cursor < size;
        }

        @Override
        public T next() {
        	if (!hasNext()) {
            	throw new NoSuchElementException();
        	}
            return elements[cursor++];
        }
    }

}

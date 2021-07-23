
import java.util.Arrays;
/**
 * Resizeable array structure for integers. Internal array doubles at 
 * 100% capacity and halves at 25% capacity.
 * 
 * @author Cameron Bost
 *
 */
public class IntegerList {
	
	private int[] arr; 		// Internal array, holds contents of list
	private int capacity; 	// Actual number of cells in internal array*/
	private int size;		// Number of occupied cells in internal array*/
	private static final int MIN_CAPACITY = 2; 	// Minimum capacity allowed for internal array
	
	// Default constructor, initializes to default values.
	public IntegerList() {
		arr = new int[MIN_CAPACITY];
		capacity = MIN_CAPACITY;
		size = 0;
	}
	
	/**
	 * Explicit constructor, size of internal array is given.
	 * 
	 * @param _capacity number of cells desired in internal array
	 */
	public IntegerList(int _capacity) {
		if(_capacity>=MIN_CAPACITY) {
			// Size is valid
			arr = new int[_capacity];
			capacity = _capacity;
			size = 0;
		}
		else {
			// Size is invalid -> default values
			arr = new int[MIN_CAPACITY];
			capacity = MIN_CAPACITY;
			size = 0;
		}
	}
	
	/**
	 * Doubles the capacity of the internal array.
	 */
	private void doubleCapacity() {
		arr = Arrays.copyOf(arr, capacity *= 2); // These operators (+=, -=, *=, etc) return their value when used as expressions (i.e. without ";").
	}
	
	/**
	 * Halves the capacity of the internal array
	 */
	private void halveCapacity() {
		arr = Arrays.copyOf(arr, capacity /= 2); // These operators (+=, -=, *=, etc) return their value when used as expressions (i.e. without ";").
	}
	
	/**
	 * Places an element in the next available spot.
	 * 
	 * @param e element being added to the list
	 * @return always returns true
	 */
	public boolean add(int e) {
		// If at capacity, double it
		if(size == capacity) {
			doubleCapacity();
		}
		arr[size++] = e;
		return true;
	}
	
	/**
	 * Dictates whether an index is valid or not.
	 * 
	 * @param idx index to check
	 * @return true if index is valid else false
	 */
	private boolean isValidIndex(int idx) {
		return (idx >= 0) && (idx <= size);
	}
	
	/**
	 * Retrieves array data at specified index,
	 * if it exists, otherwise throws out of 
	 * bounds exception.
	 * 
	 * @param idx index to retrieve from
	 * @return data at index (if it exists)
	 */
	public int get(int idx) {
		if(isValidIndex(idx)) {
			return arr[idx];
		}
		else {
			/** It is worth noting that this else clause is unnecessary, since [] will throw the same exception*/
			throw new ArrayIndexOutOfBoundsException(idx);
		}
	}
	
	/**
	 * Add element at specific index.
	 * 
	 * @param idx index to place e into
	 * @param e element to place into [idx]
	 * @return false if invalid index else true
	 */
	protected boolean insert(int idx, int e) {
		if(isValidIndex(idx)) {
			// Check capacity
			if(size == capacity) {
				doubleCapacity();
			}
			
			// from [size] -> [idx + 1], move previous element forward one cell
			for(int i = size; i >= idx + 1; i--) {
				arr[i] = arr[i - 1];
			}
			
			// Add element at specified index
			arr[idx] = e;
			size++;
			return true;
		}
		// Invalid index
		return false;
	}
	
	/**
	 * Remove element from specified index.
	 * 
	 * @param idx index to remove at
	 * @return false if invalid index else true
	 */
	protected boolean removeAt(int idx) {
		if(isValidIndex(idx)) {
			// from [idx] -> [size-2], move next value back one cell
			for(int i = idx; i <= size-2; i++) {
				arr[i] = arr[i+1];
			}
			
			// "erase" last occupied cell
			arr[size-1] = 0;
			size--;
			
			// check capacity
			if(size*4 == capacity) {
				halveCapacity();
			}
			return true;
		}
		// Invalid index
		return false;
	}
	
	/**
	 * Gets the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}
	
	public String toString() {
		return Arrays.toString(Arrays.copyOf(arr, size));
	}
	
	/*******Student Methods*******************************************/
	
	/**
	 * Checks if an element exists in the list.
	 * 
	 * @param e element to search for
	 * @return true if element is in list else false
	 */
	public boolean contains(int e) 
	{
		boolean isInArray = false;
		int i = 0;
		
		
		// Test to see if int e is in the array
			while (i < this.size())
			{
				if (e == this.get(i) && isInArray != true)
				{
					isInArray =  true;
				}
				else if (isInArray != true)
				{
					isInArray =  false;
				}
				
				++i;
			}
		
		
		return isInArray;
	}
	
	/**
	 * Checks if the given list has the same contents as this one.
	 
	 * @param o other list to compare to
	 * @return true if lists have same contents else false
	 */
	public boolean equals(IntegerList o) 
	{
		boolean inxEquals = true;
		int i = 0;
		
		if (o.size() != this.size())
		{
			return false;
		}
		else
		{
			
			// Test to see if ArrayList1.get(i) == ArrayList2.get(i)
			while (i < this.size())
			{
				if (o.get(i) == this.get(i) && inxEquals != false)
				{
					inxEquals =  true;
				}
				else if (inxEquals != false)
				{
					inxEquals =  false;
				}
				
				++i;
			}	
			
			return inxEquals;
		}	
	}
}

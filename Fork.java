import java.lang.reflect.Array;
import java.util.Optional;

public class Fork<Key extends Comparable<Key>,Value> implements Bst<Key, Value>{
	
	// immutable fields: key, value, left, right
	private final Key key;
	private final Value value;
	private final Bst<Key, Value> left, right;
	
	/**
	 * Initialize fields
	 * @param key - the key of the root
	 * @param value - the value of the root
	 * @param left - left part of the tree
	 * @param right - right part of the tree
	 */
	public Fork(Key key, Value value, Bst<Key, Value> left, Bst<Key, Value> right){
		
		assert(left != null);
		assert(right != null);
		
		assert(left.smaller(key)); 
		assert(right.bigger(key)); 
		
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
		
	}

	/**
	 * Tree is empty in Fork
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Get the node with the largest key
	 */
	@Override
	public Optional<Entry<Key, Value>> largest() {
		// TODO Auto-generated method stub
		if (right.isEmpty())
		      return Optional.of(new Entry<Key, Value>(key, value));
		    else
		      return right.largest();
	}
	
	/**
	 * Get the node with the smallest key
	 */
	@Override
	public Optional<Entry<Key, Value>> smallest() {
		// TODO Auto-generated method stub
		if (left.isEmpty())
		      return Optional.of(new Entry<Key, Value>(key, value));
		    else
		      return left.smallest();
	}

	/**
	 * Check if the keys of all nodes are smaller than k
	 */
	@Override
	public boolean smaller(Key k) {
		return largest().get().getKey().compareTo(k) < 0;
	}

	/**
	 * Check if the keys of all nodes are bigger than k
	 */
	@Override
	public boolean bigger(Key k) {
		return smallest().get().getKey().compareTo(k) > 0;
	}

	/**
	 * Check if node with Key k exists in the tree
	 */
	@Override
	public boolean has(Key k) {
		// TODO Auto-generated method stub
		if(k.compareTo(key) == 0) // if exists return true
			return true; 
		else if(k.compareTo(key) < 0) // else makes recursive call 
			return left.has(k);
		else 
			return right.has(k);
	}

	/**
	 * Finds the value of the node with Key k
	 * @param k - the key that is being searched
	 */
	@Override
	public Optional<Value> find(Key k) {
		if(k.compareTo(key) == 0)
			return Optional.of(value);
		else if(k.compareTo(key) < 0)
			return left.find(k);
		else
			return right.find(k);
	}

	/**
	 * Put new node in the tree
	 * @param k - the key of the node that is being put in the tree
	 * @param v - the value of the node that is being put in the tree
	 */
	@Override
	public Bst<Key, Value> put(Key k, Value v) {
		// TODO Auto-generated method stub
		if(k.compareTo(key) == 0) // if node with the same key exists it replaces the node with the new one
			return new Fork<Key, Value>(k, v, left, right);
		else if(k.compareTo(key) < 0)
			return new Fork<Key, Value>(key , value, left.put(k, v), right); // else put the node in the left part of the tree
		else 
			return new Fork<Key, Value>(key, value, left, right.put(k, v)); // else put the node in the right part of the tree
	}

	/**
	 * Delete a node from the tree
	 * @param k - the key of the node that is being deleted from the tree
	 */
	@Override
	public Optional<Bst<Key, Value>> delete(Key k) {
		// TODO Auto-generated method stub
		if(has(k)){
			System.out.println("Hello");
			if(k.compareTo(key) == 0)
				if(left.isEmpty())
					return Optional.of(right);
				else if(right.isEmpty())
					return Optional.of(left);
				else 
					return Optional.of(new Fork<Key, Value>(left.largest().get().getKey(), left.largest().get().getValue(), left.deleteLargest().get(), right));
				
			else if(k.compareTo(key) < 0)
				return Optional.of(new Fork<Key, Value>(key, value, left.delete(k).get(), right));
			else 
				return Optional.of(new Fork<Key, Value>(key, value, left, right.delete(k).get()));	
		}else{
			return Optional.empty();
		}
	}

	/**
	 * Delete the node with smallest key
	 */
	@Override
	public Optional<Bst<Key, Value>> deleteSmallest() {
		// TODO Auto-generated method stub
		if (left.isEmpty()) 
		      return Optional.of(right);
		    else
		      return Optional.of(new Fork<Key,Value>(key, value, left.deleteSmallest().get(), right));
	}

	/**
	 * Delete the node with largest key
	 */
	@Override
	public Optional<Bst<Key, Value>> deleteLargest() {
		// TODO Auto-generated method stub
		if (right.isEmpty()) 
		      return Optional.of(left);
		    else
		      return Optional.of(new Fork<Key,Value>(key, value, left, right.deleteLargest().get()));
	}

	/**
	 * Print the tree in a fancy way using fancyToString(0)
	 */
	@Override
	public String fancyToString() {
		// TODO Auto-generated method stub
		 return "\n\n\n" + fancyToString(0) + "\n\n\n";
	}

	/**
	 * @param d - the depth of the tree from which we print the tree
	 */
	@Override
	public String fancyToString(int d) {
		// TODO Auto-generated method stub
		int step = 8;  // depth step
	    String l = left.fancyToString(d+step);
	    String r = right.fancyToString(d+step);
	    return r + spaces(d) + key + ", " + value + "\n" + l;
	}
	
	/**
	 * Print spaces for the fancyToString method
	 * @param n - number of spaces 
	 * @return spaces
	 */
	private String spaces(int n) { 
	    String s = "";
	    for (int i = 0; i < n; i++)
		s = s + " ";
	    return s;
	  }

	/**
	 * Get the size of the tree - number of nodes
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(left.isEmpty())
			return 1 + right.size();
		else if(right.isEmpty())
			return 1 + left.size();
		else 
			return 1 + left.size() + right.size();
	}

	/**
	 * Get the height of the tree
	 */
	@Override
	public int height() {
		// TODO Auto-generated method stub
		if(left.isEmpty())
			return 1 + right.height(); // return the height of the right part
		else if(right.isEmpty())
			return 1 + left.height(); // return the height of the left part
		else 
			return Math.max(1 + right.height(), 1 + left.height()); // return both the height of the left and right part
	}

	/**
	 * Print the tree in ascending order
	 */
	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub
		left.printInOrder();
		System.out.print("(" + key + ", " + value + ")");
		right.printInOrder();
		
	}

	/**
	 * Save the tree in ascending order
	 * @param a - array of entries which stores the elements
	 */
	@Override
	public void saveInOrder(Entry<Key, Value>[] a) {
		// TODO Auto-generated method stub
		this.saveInOrder(a, 0);
		
	}

	/**
	 * @param a - array of entries which stores the elements
	 * @param i - the index of the node
	 */
	@Override
	public int saveInOrder(Entry<Key, Value>[] a, int i) {
		// TODO Auto-generated method stub
		i = left.saveInOrder(a, i);
		a[i++]= new Entry<Key, Value>(key, value);
		i = right.saveInOrder(a, i);
		return i;
	}

	/**
	 * Transform a Bst tree into a balanced Bst tree
	 */
	public Bst<Key, Value> balanced() {
		// TODO Auto-generated method stub
		Entry<Key,Value> e = new Entry<>(key,value);
	    @SuppressWarnings("unchecked")
	    Entry<Key,Value>[] a = (Entry<Key,Value>[]) Array.newInstance(e.getClass(), size()); // initialize the array to store the elements
	    
	    this.saveInOrder(a); // store the elements in ascending order
	   
	    return helper(a, 0, a.length); 
	    
	}
	

	/**
	 * 
	 * @param a - array stores the elements 
	 * @param start - start of the new sub array
	 * @param stop - end of new sub array
	 * @return balanced tree
	 */
	private Bst<Key,Value> helper(Entry<Key,Value>[] a, int start, int stop){
		
		if(a.length!=0 && start < stop){ // check the length of the array and the start to be less than the stop
			
	    	Key mediumKey = a[(start + stop)/2].getKey(); // get the key of the medium node
		    Value mediumValue = a[(start + stop)/2].getValue(); // get the value of the medium node
		    int medium = (start + stop)/2; // get index of the medium node
		    
		    // create new tree with the medium values of the current array and left and right parts- recursive calls with the left and right sub arrays
		    Fork<Key, Value> balancedTree = new Fork<Key, Value>(mediumKey, mediumValue, helper(a, start, medium), helper(a, medium+1, stop));
		    
		    return balancedTree;
		    
	    }else{
	    	
	    	return new Empty<>();
	    }
	}

	/**
	 * Get the key of the current node
	 */
	@Override
	public Optional<Key> getKey() {
		// TODO Auto-generated method stub
		return Optional.of(key); 
	}

	/**
	 * Get the value of the current node
	 */
	@Override
	public Optional<Value> getValue() {
		// TODO Auto-generated method stub
		return Optional.of(value);
	}
	
	
	/**
	 * Get the left sub tree of the current tree
	 */
	@Override
	public Optional<Bst<Key, Value>> getLeft() {
		// TODO Auto-generated method stub
		return Optional.of(left);
	}

	/**
	 * Get the right sub tree of the current tree
	 */
	@Override
	public Optional<Bst<Key, Value>> getRight() {
		// TODO Auto-generated method stub
		return Optional.of(right);
	}
	
}

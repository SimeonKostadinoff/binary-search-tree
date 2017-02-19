import java.util.Optional;

public class Empty <Key extends Comparable<Key>,Value> implements Bst<Key, Value>{
	
	/**
	 * Constructor of Empty
	 */
	public Empty(){
		
	}
	
	/**
	 * The tree is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Every node's key is smaller than k
	 */
	@Override
	public boolean smaller(Key k) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Every node's key is bigger than k
	 */
	@Override
	public boolean bigger(Key k) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * The tree doesn't have node with key k
	 */
	@Override
	public boolean has(Key k) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Return Optional.empty() when there is no node with key k
	 */
	@Override
	public Optional<Value> find(Key k) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Put the node with key k and value v in an empty tree
	 */
	@Override
	public Bst<Key, Value> put(Key k, Value v) {
		// TODO Auto-generated method stub
		return new Fork<Key,Value>(k, v, new Empty<Key,Value>(), new Empty<Key,Value>());
	}

	/**
	 * Return 
	 */
	@Override
	public Optional<Bst<Key, Value>> delete(Key k) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Return Optional.empty() when there isn't a smallest element
	 */
	@Override
	public Optional<Entry<Key, Value>> smallest() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * 
	 */
	@Override
	public Optional<Bst<Key, Value>> deleteSmallest() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Return Optional.empty() when there isn't a largest element
	 */
	@Override
	public Optional<Entry<Key, Value>> largest() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * 
	 */
	@Override
	public Optional<Bst<Key, Value>> deleteLargest() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Return empty string
	 */
	@Override
	public String fancyToString() {
		// TODO Auto-generated method stub
		return "";
	}

	/**
	 * Return fancyToString method
	 */
	@Override
	public String fancyToString(int d) {
		// TODO Auto-generated method stub
		return fancyToString();
	}

	/**
	 * The size of the tree is 0 when the tree is empty
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * The height of the tree is -1 when the tree is empty
	 */
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return -1; 
	}

	/**
	 * Print empty string 
	 */
	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub
		System.out.print("");
	}

	/**
	 * Do nothing for empty tree
	 */
	@Override
	public void saveInOrder(Entry<Key, Value>[] a) {
		// TODO Auto-generated method stub
	}

	/**
	 * Return i when the tree is empty
	 */
	@Override
	public int saveInOrder(Entry<Key, Value>[] a, int i) {
		// TODO Auto-generated method stub
		return i;
	}

	/**
	 * Return the same tree when there is are no more nodes
	 */
	@Override
	public Bst<Key, Value> balanced() {
		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * Optional.empty() for empty tree - key
	 */
	@Override
	public Optional<Key> getKey() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	/**
	 * Optional.empty() for empty tree - value
	 */
	@Override
	public Optional<Value> getValue() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Optional.empty() for empty tree - left
	 */
	@Override
	public Optional<Bst<Key, Value>> getLeft() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Optional.empty() for empty tree - right
	 */
	@Override
	public Optional<Bst<Key, Value>> getRight() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}

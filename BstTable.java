import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BstTable<Key extends Comparable<Key>,Value>  implements Table<Key,Value> {
	
	// New tree
	private Bst<Key,Value> bst;

	/**
	 * Initialize new empty tree
	 */
	public BstTable(){
		this.bst = new Empty<Key, Value>();;
	}
	
	/**
	 * Check if the it contains node with key k
	 */
	@Override
	public boolean containsKey(Key v) {
		// TODO Auto-generated method stub
		return bst.has(v);
	}

	@Override
	public Optional<Value> get(Key k) {
		// TODO Auto-generated method stub
		return bst.find(k);
	}

	/**
	 * Check if empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bst.isEmpty();
	}

	/**
	 * Put the node with key k and value v
	 */
	@Override
	public Table<Key, Value> put(Key k, Value v) {
		// TODO Auto-generated method stub
		bst = bst.put(k, v);
		return this;
	}

	/**
	 * Remove node with key k
	 */
	@Override
	public Optional<Table<Key, Value>> remove(Key k) {
		// TODO Auto-generated method stub
		if(bst.has(k)){
			bst = bst.delete(k).get();
			return Optional.of(this);
		}else{
			return Optional.empty();
		}
		
	}

	/**
	 * Return number of nodes
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return bst.size();
	}

	/**
	 * Save all values of the nodes in an array list
	 */
	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		ArrayList<Value> values = new ArrayList<>();
		
		Entry<Key, Value> e = new Entry<>(bst.getKey().get(), bst.getValue().get());
		@SuppressWarnings("unchecked")
		Entry<Key, Value>[] arr = (Entry<Key, Value>[]) Array.newInstance(e.getClass(), this.size()); // new array
		
		bst.saveInOrder(arr); // save all nodes in array
		
		for(Entry<Key, Value> i : arr){
			values.add(i.getValue()); // save the elements' value from array arr into array values
		}
		
		return values;
	}
	
	/**
	 * Save all keys of the nodes in an array list
	 */
	@Override
	public Collection<Key> keys() {
		// TODO Auto-generated method stub
		ArrayList<Key> keys = new ArrayList<>();
		
		Entry<Key, Value> e = new Entry<>(bst.getKey().get(), bst.getValue().get());
		@SuppressWarnings("unchecked")
		Entry<Key, Value>[] arr = (Entry<Key, Value>[]) Array.newInstance(e.getClass(), this.size());
		
		bst.saveInOrder(arr); // save all nodes in array
		
		for(Entry<Key, Value> i : arr){
			keys.add(i.getKey()); // save the elements' key from array arr into array keys
		}
		
		return keys;
	}

}

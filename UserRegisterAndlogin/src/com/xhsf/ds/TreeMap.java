package com.xhsf.ds;


public class TreeMap<K, V> extends RedBlackTree<K, V> {

	/**
	 * 添加结点，如果key值存在则覆盖原value
	 * @param key
	 * @param value
	 */
	public void add(K key, V value) {
		if (super.getRoot() == null) {
			RBTNode<K, V> root = new RBTNode<K, V>(key, value, "Black");
			super.setRoot(root);
		} else {
			super.put(key, value);
		}
	}
	
	/**
	 * 删除结点
	 * 如果key不存在则返回false
	 * @param key
	 */
	/**
	 * 
	 * @param key
	 * @return Boolean
	 */
	public Boolean delete(K key) {
		RBTNode<K, V> p = super.getRBTNode(key);
		if (p == null) 
			return false;
		super.deleteRBTNode(p);
		return true;
	}
	
	/**
	 *通过key查询value
	 *不存在返回null
	 * @param key
	 * @return V value
	 */
	public V query(K key) {
		RBTNode<K, V> p = super.getRBTNode(key);
		if (p == null) 
			return null;
		return p.value;
	}
	
	/**
	 * 更新结点
	 * key不存在返回false
	 * @param map
	 * @return Boolean
	 */
	public Boolean upadate(K key, V value) {
		RBTNode<K, V> p = super.getRBTNode(key);
		if (p == null) 
			return false;
		super.put(key, value);
		return true;
	}
	
}

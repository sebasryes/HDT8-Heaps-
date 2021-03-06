/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Sebastian Reyes 21139
 * Clase publica Vector heap
 */

package com.example;
import java.util.Vector;


/**
 * Clase que define la prioridad de los pacientes.
 * La clase implemente PriorityQueue.
 * @param <E>
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueueI<E> {

	protected Vector<E> data; // the data, kept in heap order

	/**
	 * Constructor
	 */
	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	/**
	 * El metodo construye un nuevo priority queue de un vector desordenado (sin prioridad)
	 * @param v
	 */
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++) { // add elements to heap
			add(v.get(i));
		}
	}

	/**
	 * Retorna el padre de un nodo en la localidad i
	 * @param i
	 * @return padre del nodo
	 */
	protected static int parent(int i)
	
	{
		return (i - 1) / 2;
	}

	/**
	 * Retorna el indice del hijo izquierdo de un nodo en la posicion i
	 * @param i
	 * @return el indice del hijo izquierdo
	 */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2 * i + 1;
	}

	/**
	 * Retorna el indice del hijo derecho de un nodo en la posicion i
	 * @param i
	 * @return el indice del hijo derecho
	 */
	protected static int right(int i)
	
	{
		return (2 * i + 1) + 1;
	}

	/**
	 * Mueve el nodo en el indice de la hoja hasta la posicion apropiada
	 * @param leaf
	 */
	protected void percolateUp(int leaf)
	
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
				(value.compareTo(data.get(parent)) < 0)) {
			data.set(leaf, data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf, value);
	}

	/**
	 * Agrega un valor a la cola de prioridad
	 * @param value
	 */
	public void add(E value)
	{
		data.add(value);
		percolateUp(data.size() - 1);
	}

	/**
	 * Mueve el nodo al indice de la raiz de abajo hacia la posicion apropiada en el subarbol
	 * @param root
	 */
	protected void pushDownRoot(int root)

	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize) {
				if ((right(root) < heapSize) &&
						((data.get(childpos + 1)).compareTo
								(data.get(childpos)) < 0)) {
					childpos++;
				}
				
				if ((data.get(childpos)).compareTo
						(value) < 0) {
					data.set(root, data.get(childpos));
					root = childpos; 
				} else { 
					data.set(root, value);
					return;
				}
			} else { 
				data.set(root, value);
				return;
			}
		}
	}

	/**
	 * Elimina un valor (minimo) de la cola
	 * @return valor minimo
	 */
	public E remove()
	{
		E minVal = getFirst();
		data.set(0, data.get(data.size() - 1));
		data.setSize(data.size() - 1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	/**
	 * Captura el primer valor del vector
	 * @return primer valor
	 */
	public E getFirst() {
		return data.get(0);
	}

	/**
	 * Comprueba si el vector esta vacio
	 * @return verdadero o falso
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Retorna el tamanio del vector
	 * @return tamanio
	 */
	@Override
	public int size() {
		return data.size();
	}

	/**
	 * Elimina todos los datos del vector
	 */
	@Override
	public void clear() {
		data.clear();
	}
}
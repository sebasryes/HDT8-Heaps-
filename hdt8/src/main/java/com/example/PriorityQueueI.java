/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Sebastian Reyes 21139
 * Interfaz publica Prority Queue
 */
package com.example;
public interface PriorityQueueI<E extends Comparable<E>>
{
	public E getFirst();
	// pre: !isEmpty()
	// post: regresa el valor minimo de la priority queue
	
	public E remove();
	// pre: !isEmpty()
	// post: encuentra y retorna el valor minimo de la queue
	
	public void add(E value);
	// pre: es un valor que nos es nulo y se puede comparar
	// post: el valor es agregado a la priority queue
	
	public boolean isEmpty();
	// post: regresa un valor verdadero si la queue se encuentra vacia
	
	public int size();
	// post: regresa el numero de elementos que se encuentran en la queue
	
	public void clear();
	// post: limpia y retira todos los elmentos que se encuentran en la queue
}
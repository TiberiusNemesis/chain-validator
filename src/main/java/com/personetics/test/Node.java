package com.personetics.test;

/**
 * Blueprint interface for the Node class.
 *
 * @param <T> A String, or an Integer.
 */
public interface Node<T> {

  T getNodeData();

  Boolean isKeyValueNode();
}

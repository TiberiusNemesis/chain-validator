package com.personetics.test;

/**
 * A Node object containing an Integer.
 */
public class NumberNode implements Node<Integer> {

  Integer nodeData;

  NumberNode(int numberNodeValue) {
    this.nodeData = Integer.valueOf(numberNodeValue);
  }

  @Override
  public Integer getNodeData() {
    return this.nodeData;
  }

  @Override
  public Boolean isKeyValueNode() {
    return this.nodeData.toString().length() == 1;
  }
}

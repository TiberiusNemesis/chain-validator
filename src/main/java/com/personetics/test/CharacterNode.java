package com.personetics.test;

/**
 * A Node object containing a String.
 */
public class CharacterNode implements Node<String> {

  String nodeData;

  CharacterNode(String stringNodeValue) {
    this.nodeData = stringNodeValue;
  }

  @Override
  public String getNodeData() {
    return this.nodeData;
  }

  @Override
  public Boolean isKeyValueNode() {
    return this.nodeData.length() == 1;
  }
}

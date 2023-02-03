package com.personetics.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Contains methods to determine if a list of Nodes is valid.
 * A Node can be either:
 * a. A single lowercase character, a-z
 * b. A number with one digit, 0-9
 * (These are considered key nodes.)
 * c. A word with all-lowercase characters (max length not defined).
 * d. A number with two digits (00-99)
 */
public class ChainValidator {
  private List<Node> currentNodeList;
  private HashSet<Character> currentKeyNodeSet;

  /**
   * Checks if a list of Nodes is valid.
   * A Node with a single character (numerical or alphabetical) is considered a Key Node.
   * If a standard Node (a word, or a multiple-digit number) is formed solely by characters
   * present in key nodes, it is valid. Otherwise, it is invalid.
   * Example: The List of Nodes ["aba", "a", "b", "babbba"] is valid,
   * since both non-key nodes are formed only using "a" and "b".
   * Example 2: The List of Nodes [1, 12, 155, 1221, 5] is invalid,
   * since 2 is not a key node, making Nodes with values 12 and 1221 not meet the requirements.
   *
   * @param nodes A List object containing multiple Nodes.
   * @return True if the Nodes are valid according to the above conditions, false otherwise.
   */
  boolean validate(List<Node> nodes) {
    this.currentNodeList = new ArrayList<>();
    currentNodeList.addAll(nodes);

    HashSet<Character> keyValues = getKeyValueNodes(nodes);
    for (Node node : currentNodeList) {
      if (!isNodeValid(node, keyValues)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Given a HashSet of Key Nodes, checks if a single Node is valid.
   * A node with a single character (numerical or alphabetical) is considered a key node.
   * If a standard Node (a word, or a multiple-digit number) is formed solely by characters
   * present in key nodes, it is valid. Otherwise, it is invalid.
   *
   * @param node      A Node object containing a multiple-digit Integer or a multiple-character String.
   * @param keyValues A HashSet of key nodes.
   * @return True if the Node is only formed by characters present in the HashSet, False otherwise.
   */
  public Boolean isNodeValid(Node node, HashSet<Character> keyValues) {
    HashSet<Character> uniqueNodeCharacters = new HashSet<>();
    String nodeDataValue = node.getNodeData().toString();
    nodeDataValue.chars().forEach(character -> uniqueNodeCharacters.add((char) character));
    return keyValues.containsAll(uniqueNodeCharacters);
  }

  /**
   * Given a List of Nodes, generates a HashSet of the Key Nodes,
   * leaving only standard Nodes in the original List.
   *
   * @param nodes A list of Nodes containing both Key Nodes, and standard Nodes.
   * @return A HashSet containing unique Key Nodes.
   */
  public HashSet<Character> getKeyValueNodes(List<Node> nodes) {
    currentKeyNodeSet = new HashSet<>();
    for (Node node : nodes) {
      String currentNodeData = node.getNodeData().toString();
      if (node.isKeyValueNode()) {
        currentNodeData.chars().forEach(character -> currentKeyNodeSet.add((char) character));
        currentNodeList.remove(node);
      }
    }
    return currentKeyNodeSet;
  }
}
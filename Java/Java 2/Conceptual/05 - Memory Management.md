# Memory Management

## 8.1 Intro

* Problem: Inserting and getting can take a long time if something like ArrayList is too big
* Solution: Appending is much faster

## 8.2 A first linked list

* Linked list allows you to insert much faster
* Create a node to insert into a linked list so you don't have to append

```java
headObj = new IntNode(-1); // When the list is first created, no list items exists, so the head node's nextNodePtr pointer is null.

// Add nodeObj1 after headObj
nodeObj1 = new IntNode(555);
headObj.insertAfter(nodeObj1);
```

package edu.desu;

public class SinglyLinkedList<T> {

    private Node<T> headNode;

    public SinglyLinkedList(){
    }

    public void insertAtHead(T data){
        Node<T> previousNode = headNode;
        Node<T> node = new Node<>(data);
        node.setNextNode(previousNode);
        this.headNode = node;
    }

    public void insertAtEnd(T data){
        Node<T> previousNode = headNode;
        while(previousNode !=null && previousNode.hasNext()){
           Node<T> currentNode = previousNode.getNextNode();
           previousNode = currentNode;
        }
        Node<T> insertNode = new Node<>(data);
        previousNode.setNextNode(insertNode);
    }

    public Boolean insertAfter(T previous, T data){
        Node<T> currentNode = headNode;
        while (currentNode != null){
            T valueToCheck = currentNode.getData();
            Node<T> nextNode = currentNode.getNextNode();
            if(valueToCheck.equals(previous)){
                Node<T> insertedNode = new Node<>(data);
                insertedNode.setNextNode(nextNode);
                currentNode.setNextNode(insertedNode);
                return true;
            }
            currentNode= nextNode;
        }
        return false;
    }

    public Boolean delete(T data){
        Node<T> currentNode = headNode;
        T headValue = currentNode.getData();
        if(headValue.equals(data)){
            deleteAtHead();
            return true;
        }
        while(currentNode != null && currentNode.hasNext()){
            Node<T> nextNode = currentNode.getNextNode();
            T valueToCheck = nextNode.getData();
            if(valueToCheck.equals(data)){
                Node<T> swapNode = nextNode.getNextNode();
                currentNode.setNextNode(swapNode);
                nextNode = null;
                return true;
            }
            currentNode = nextNode;

        }
        return false;
    }

    public Boolean contains(T data){
        Node<T> currentNode = headNode;
        while (currentNode != null){
            T dataToCheck = currentNode.getData();
            if(dataToCheck.equals(data)){
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public void deleteAtHead(){
        Node<T> currentNode = headNode;
        if(currentNode !=null){
            headNode = currentNode.getNextNode();
        }
    }


    public String toString(){
        String data = "";
        Node<T> node = headNode;
        while(node != null){
            data += node.getData().toString();
            if(node.hasNext()){
                data += ",";
            }
            node = node.getNextNode();
        }
        return data;
    }
}

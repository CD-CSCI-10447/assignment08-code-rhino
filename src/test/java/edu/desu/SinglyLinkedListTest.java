package edu.desu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    public void insertAtHeadTest01(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("Test");

        String expected = "Test";
        String actual = linkedList.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void insertAtHeadTest02(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("Test 01");
        linkedList.insertAtHead("Test 02");
        String expected = "Test 02,Test 01";
        String actual = linkedList.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void insertAtEndTest01(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First Node");
        linkedList.insertAtEnd("Last Node");
        String expected = "First Node,Last Node";
        String actual = linkedList.toString();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void insertAtEndTest02(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First Node");
        linkedList.insertAtEnd("Almost Last Node");
        linkedList.insertAtEnd("Last Node");
        String expected = "First Node,Almost Last Node,Last Node";
        String actual = linkedList.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void insertAfterTest01(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Second");
        linkedList.insertAtEnd("Fourth");
        Boolean actual = linkedList.insertAfter("Second", "Third");
        String expectedString = "First,Second,Third,Fourth";
        String actualString = linkedList.toString();
        Assertions.assertTrue(actual);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void insertAfterTest02(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Fourth");
        Boolean actual = linkedList.insertAfter("Second", "Third");
        String expectedString = "First,Fourth";
        String actualString = linkedList.toString();
        Assertions.assertFalse(actual);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void deleteTest01(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Delete Me");
        Boolean actual = linkedList.delete("Delete Me");
        String expectedString = "First";
        String actualString = linkedList.toString();
        Assertions.assertTrue(actual);
        Assertions.assertEquals(expectedString, actualString);
    }


    @Test
    public void deleteTest02(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        Boolean actual = linkedList.delete("Delete Me");
        String expectedString = "First";
        String actualString = linkedList.toString();
        Assertions.assertFalse(actual);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void deleteTest03(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Delete Me");
        Boolean actual = linkedList.delete("First");
        String expectedString = "Delete Me";
        String actualString = linkedList.toString();
        Assertions.assertTrue(actual);
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void deleteAtHead(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Second");
        String expected = "Second";
        linkedList.deleteAtHead();
        String actual = linkedList.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void containsTest01(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Second");
        Boolean actual = linkedList.contains("Second");
        Assertions.assertTrue(actual);
    }

    @Test
    public void containsTest02(){
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtHead("First");
        linkedList.insertAtEnd("Second");
        Boolean actual = linkedList.contains("Third");
        Assertions.assertFalse(actual);
    }
}

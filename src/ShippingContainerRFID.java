/**
 * ShippingContainerRFID subclass epresents a shipping container with RFID scanned contents.
 *
 * @author Lehem Temesgen
 * @version 08/13/2024
 */
import java.util.LinkedList;

public class ShippingContainerRFID extends ShipContainer {
    LinkedList<Integer> count = new LinkedList<>();
    LinkedList<String> contents = new LinkedList<>();

    /**
     * Default constructor initializing the container with a specified ID.
     *
     * @param newID
     */
    public ShippingContainerRFID(int newID) {
        this.containerID = newID;
    }

    /**
     * Sets the contents of the container using RFID scans.
     *
     * @param contents
     */
    @Override
    public void setContents(String contents) {
        int index = searchItems(contents);
        if (index != -1) {
            // if the item exists increment its count
            count.set(index, count.get(index) + 1);
        } else {
            // if the item does not exist add it to the linkedlist
            this.contents.add(contents);
            count.add(1);
        }
    }

    /**
     * Provides a string representation of the list of contents in the container.
     *
     * @return a string of the contents
     */
    @Override
    public String containerContentList() {
        StringBuilder contentList = new StringBuilder();
        // iterate over each iem in contents linkedlist
        for (int i = 0; i < contents.size(); i++) {
            // append the quantity and name of the item to the linkedlist
            contentList.append(count.get(i));
            contentList.append(" ");
            contentList.append(contents.get(i));

            // append a comma & a space if the item isn't the last in the linkedlist
            if (i < contents.size() - 1) {
                contentList.append(", ");
            }
        }
        // convert to string and return
        return contentList.toString();
    }

    /**
     * Searches for an item in the contents list.
     *
     * @param s
     * @return the index or -1
     */
    private int searchItems(String s) {
        // search for the item in contents linkedlist
        for (int i = 0; i < contents.size(); i++) {
            if (contents.get(i).equalsIgnoreCase(s)) {
                return i; // return the item if it's found
            }
        }
        return -1; // if item is not found
    }

}

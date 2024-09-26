/**
 * ShipContainer abstract class represents a shipping container with an ID and contents.
 * Contains methods to set and print the contents of a container.
 *
 * @author Lehem Temesgen
 * @version 08/13/2024
 */
public abstract class ShipContainer {
    protected int containerID;

    /**
     * Default constructor initializing the container's ID to a default value.
     */
    public ShipContainer() {
        containerID = 0;
    }

    /**
     * Sets the container's ID to a given value.
     *
     * @param containerID
     */
    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    /**
     * Gets the container's ID.
     *
     * @return container's ID
     */
    public int getContainerID() {
        return containerID;
    }

    /**
     * Abstract method that sets the contents of the container.
     *
     * @param contents
     */
    public abstract void setContents(String contents);

    /**
     * Provides a list of the contents in the container.
     *
     * @return a string of the contents
     */
    public String containerContentList() {
        return "";
    }

    /**
     * Prints the ID and contents of the container.
     */
    public void printContent() {
        System.out.println("Container " + containerID + " contains " + containerContentList());
    }
}

/**
 * ManualContentList subclass represents a shipping container with manually entered contents.
 *
 * @author Lehem Temesgen
 * @version 08/13/2024
 */
public class ManualContentList extends ShipContainer {
    private String contents;

    /**
     * Default constructor initializing the contents to a default value.
     */
    public ManualContentList() {
        contents = null;
    }

    /**
     * Overload constructor initializing the container with a specified ID.
     */
    public ManualContentList(int newID) {
        this.containerID = newID;
    }

    /**
     * Sets the contents of the container.
     *
     * @param contents
     */
    @Override
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Provides a string representation of the contents in the container.
     *
     * @return a string of the contents
     */
    @Override
    public String containerContentList() {
        return contents;
    }
}

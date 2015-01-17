package ie.gmit.computing;

/**
 * This class is to set attributes of a node
 * @author Ethan
 *
 */
public class NodeResource {
	protected String parentId;
	protected String title;
	protected String value;
	protected int iconId;
	protected String curId;

	/**
	 * Constructor with parameters
	 * @param title
	 * @param value
	 * @param parentId
	 * @param curId
	 * @param iconId
	 */
	public NodeResource(String title,String value, String parentId,String curId, int iconId) {
		super();
		this.parentId = parentId;
		this.title = title;
		this.value = value;
		this.iconId = iconId;
		this.curId = curId;
	}
	/**
	 * Constructor with parameters
	 * @param title
	 * @param value
	 * @param parentId
	 * @param curId
	 * @param iconId
	 */
	public NodeResource(String parentId, String curId, String title,
			String value) {
		super();
		this.parentId = parentId;
		this.title = title;
		this.value = value;
		this.curId = curId;
	}
	public String getParentId() {
		return parentId;
	}

	public String getTitle() {
		return title;
	}

	public String getValue() {
		return value;
	}

	public int getIconId() {
		return iconId;
	}

	public String getCurId() {
		return curId;
	}

}

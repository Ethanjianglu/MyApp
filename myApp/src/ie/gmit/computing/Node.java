package ie.gmit.computing;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






/**
 * This is an enitty class of node
 * @author Ethan
 *
 */
public class Node implements Serializable{
	private Node parent = null; //  father node
	private List<Node> childrens = new ArrayList<Node>();//child node
	public static HashMap<String, Node> map=new HashMap<String,Node>();
	public static List<String> childrensName = new ArrayList<String>();
	
	private int icon = -1; //icon(R.drawable的id)
	private boolean isChecked = false; //selected or not
	private boolean isExpand = true;//expanded or not
	private boolean hasCheckBox = true;//if has check box
	
	private boolean isVisiable = true;

	protected String parentId;
	protected String title;
	protected String value;
	protected int iconId;
	protected String curId;
		/**
		 * set int node
		 * 
		 * @param parentId
		 *            TODO
		 * @param curId
		 *            TODO
		 */
	public Node(String title,String value, String parentId,String curId, int iconId) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.value = value;
		this.parentId = parentId;
		this.icon = iconId;
		this.curId = curId;
	}
	
	public Node(Node parent, String title, String value, int iconId,
				String curId) {
			super();
			this.parent = parent;
			this.title = title;
			this.value = value;
			this.iconId = iconId;
			this.curId = curId;
		}

	public Node(String name,Node parent){
		super();
		this.title=name;
		this.parent=parent;
	}
	/**
	 * get father node
	 * @return
	 *
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * set father node
	 * @param parent
	 *
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	/**
	 * get child node
	 * @return
	 *
	 */
	public List<Node> getChildrens() {
		return childrens;
	}
	/**
	 * is root
	 * @return
	 *
	 */
	public boolean isRoot(){
		return parent ==null?true:false;
	}
	/**
	 * if has image
	 * @return
	 *
	 */
	public int getIcon() {
		return icon;
	}
	/**
	 * set icon
	 * @param icon
	 *
	 */
	public void setIcon(int icon) {
		this.icon = icon;
	}
	/**
	 * selected or not
	 * @return
	 *
	 */
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	/**
	 * if expanded
	 * @return
	 *
	 */
	public boolean isExplaned() {
		return isExpand;
	}
	/**
	 * set as expanded state
	 * @param isExplaned
	 *
	 */
	public void setExplaned(boolean isExplaned) {
		this.isExpand = isExplaned;
	}
	/**
	 * if has check box
	 * @return
	 *
	 */
	public boolean hasCheckBox() {
		return hasCheckBox;
	}
	/**
	 * set check box
	 * @param hasCheckBox
	 *
	 */
	public void setHasCheckBox(boolean hasCheckBox) {
		this.hasCheckBox = hasCheckBox;
	}
	/**
	 * get node title
	 * @return
	 *
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * set node title
	 * @param title
	 *
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * get node value
	 * @return
	 *
	 */
	public String getValue() {
		return value;
	}
	/**
	 * set node value
	 * @param value
	 *
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * add a child node
	 * @param node
	 *
	 */
	public void addNode(Node node){
		if(!childrens.contains(node)&&!map.containsKey(node.getTitle())&&!childrensName.contains(node)){
			childrens.add(node);
			childrensName.add(node.getTitle());
			map.put(node.getTitle(), node);
		}
	}
	/**
	 * remove a child node
	 * @param node
	 *
	 */
	public void removeNode(Node node){
		if(childrens.contains(node))
			childrens.remove(node);
	}
	/**
	 * remove a specific child node
	 * @param location
	 *
	 */
	public void removeNode(int location){
		childrens.remove(location);
	}
	/**
	 * clear all nodes
	 *
	 */
	public void clears(){
		childrens.clear();
	}
	/**
	 * if the node is the parent node of current node
	 * @param node
	 * @return
	 *
	 */
	public boolean isParent(Node node){
		if(parent == null)return false;
		if(parent.equals(node))return true;
		return parent.isParent(node);
	}
	/**
	 * get the current level
	 * @return
	 *
	 */
	public int getLevel(){
		return parent ==null?0:parent.getLevel()+1;
	}
	/**
	 * if the parent node is foldable
	 * @return
	 *
	 */
	public boolean isParentCollapsed(){
		if(parent ==null)return false;
		if(!parent.isExplaned())return true;
		return parent.isParentCollapsed();
	}
	/**
	 * is leaf or not
	       * @return
	       *
	 */
	public boolean isLeaf(){
	       return childrens.size()<1?true:false;
	}
	 /**
	  * return current id
	 * @return
	 **/
	public String getCurId() {
		// TODO Auto-generated method stub
		return curId;
	}
	/**
	 * return the id of parent node
	* @return
	**/
	public String getParentId() {
		// TODO Auto-generated method stub
		return parentId;
	}
	}
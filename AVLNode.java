
// Basic node stored in AVL trees

class AVLNode {
	
	Tank t;				// The data in the node
	AVLNode parent;		// The parent
	AVLNode left;       // Left child
	AVLNode right;      // Right child
	int height = -1;       	// Height

	/**
	 * A standard constructor, sets all pointers to null.
	 * 
	 * @param t - the data of the node.
	 */
    AVLNode(Tank t) {
    	 parent = null;
    	 left = null;
         right = null;
         this.t = t;
         this.height = 0; 
    }
    
    /**
     * A standard constructor
     * 
     * @param t - the data of the node.
     * @param left - the left child.
     * @param right - the right child.
     * @param parent - the parent.
     */
    AVLNode(Tank t, AVLNode left, AVLNode right, AVLNode parent){
    	this.t = t;
    	this.left = left;
    	this.right = right;
    	this.parent = parent; 
    	this.height = Math.max(right.height, left.height)+1;
    }
}
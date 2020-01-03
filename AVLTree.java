

public class AVLTree {

    AVLNode root; 	// The tree root.
    int size;		// The size of the tree.
    private static int index;
    /**
     * Construct an empty tree.
     */
    public AVLTree() {
    	root = null;
    	size=0;
    }
    /**
     * Insert into the tree; You may assume that every tank is unique.
     * That is, no tank will appear twice.
     * 
     * @param t the tank to insert.
     */
    public void insert(Tank t) {
    	 if (root == null) {
    		 root =  new AVLNode(t);
    		 size++;
    	 }
    	 else { 
    		 root = insert(t, root);
    	 }
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
        return (t == null) ? -1 : t.height;
    }
    /* Function to insert tank recursively */
   private AVLNode insert(Tank x, AVLNode t)
   {
        if (t.t == null) {
            t = new AVLNode(x);
            size++;
            return t;
            }
         if (x.compareTo(t.t) < 0){
            if (t.left != null) {
            	t.left = insert( x, t.left );
            }else {
            	t.left = new AVLNode(x);
            	size++;
            }
            if( height( t.left ) - height( t.right ) == 2 )
                if(x.compareTo(t.left.t) < 0)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else  if(x.compareTo(t.t) > 0)
        {
             if (t.right!=null) {
                 	t.right = insert( x, t.right );
             }else {
            	 t.right = new AVLNode(x);
            	 size++;
             }
            if( height( t.right ) - height( t.left ) == 2 )
                if( x.compareTo(t.right.t) > 0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        t.height = Math.max(height(t.left), height(t.right) + 1);
        return t;
    }
    
    /* Rotate binary tree node with left child */     
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left) , height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left),height(k2) ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left) , height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left),height(k1) ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
   
    /**
     * Search for a tank in the tree.
     * 
     * @param t the tank to search for.
     * @return the matching tank or null if not found.
     */
    public Tank search(Tank t) {
    	return search(root, t);
    }
    
    public Tank search(AVLNode root, Tank t) {
    	if (root == null) return null;
    	if (t.compareTo(root.t) == 0) return root.t;
    	if ((t.compareTo(root.t) < 0) && (root.left != null)){
    			return search(root.left,t);
    	}
    	if ((t.compareTo(root.t) > 0) && (root.right != null)){
        		return search(root.right,t);
    	}
    	return null;
    }
    /**
     * Traverse the contents of this tree in an 'inorder' manner and return and array
     * containing the traversal of the tree.
     * 
     * @return a sorted array of the tree's content.
     */
    Tank[] inorder(){
    	index = 0;
    	Tank[] tanks = new Tank[size];
        inorder(root, tanks);
        return tanks;
        }

    public void inorder(AVLNode node, Tank[] tanks){

        if(node.left != null) {
           		inorder(node.left, tanks);
        }
        tanks[index++] = node.t;
        if(node.right != null) {
        	inorder(node.right, tanks);
        }
    }
 }
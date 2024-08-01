package assignments;
//Binary Search Tree
public class Assignment14 {

    public void driver() {
        BST BSTobj = new BST();

        System.out.println("Tree Empty: " + BSTobj.IsEmpty() + "\n");

        BSTobj.INSERT(30);
        BSTobj.INSERT(15);
        BSTobj.INSERT(10);
        BSTobj.INSERT(150);
        BSTobj.INSERT(20);
        BSTobj.INSERT(200);

        System.out.println("Tree:");
        BSTobj.postorder(); // if root is a private var (we need to create an extra func for traversing)
        // BSTobj.inorderRec(BSTobj.root); //but if root is not a private var then we
        // can directly callinorderrec func
        System.out.println("");
        BSTobj.inorder();

        System.out.println("\nTree Empty: " + BSTobj.IsEmpty());

        System.out.println("\nSearched nodes: " + BSTobj.search(200) + " and " + BSTobj.search(30));

       // BSTobj.Delete(0);
        // BSTobj.Delete(30);   // if root is private var.
       // BSTobj.root=BSTobj.deleteNode(BSTobj.root, 30); // if root is not private

        System.out.println("Tree:");
        BSTobj.postorder();

        System.out.println("");
        BSTobj.inorder();

        System.out.println("");
        BSTobj.INSERT(9);
        BSTobj.INSERT(12);
        BSTobj.inorder();
        BSTobj.Delete(15);
        System.out.println("\nAfter deletion");
        BSTobj.inorder();

        
    }

}

class BST {

    private Node root;

    public class Node {

        int item;
        Node left;
        Node right;

    }

    public boolean IsEmpty() {
        return root == null;
    }


    public void INSERT(int data) {
        Node N = new Node();
        N.item = data;
        N.left = null;
        N.right = null;

        if (IsEmpty() == true) {
            root = N;
        } else {
            Node ptr; // for traversing
            ptr = root;

            while (N.item != ptr.item) {
                if (ptr.item > N.item) { // left
                    if (ptr.left == null) {
                        ptr.left = N;
                        break;
                    } else {
                        ptr = ptr.left;
                    }

                } else { // right
                    if (ptr.right == null) {
                        ptr.right = N;
                        break;
                    } else {
                        ptr = ptr.right;
                    }
                }
            }
        }

    }

    public void Insert(int data) {
        Node n = new Node();
        n.item = data;
        n.left = null;
        n.right = null;

        if (IsEmpty() == true) {
            root = n;
        } else {
            Node ptr; // for traversing
            ptr = root;

            while (n.item != ptr.item) {

                if (ptr.item > n.item) { // insertion in left subtree
                    if (ptr.left == null) {
                        ptr.left = n;
                        break;
                    } else {
                        ptr = ptr.left;
                    }
                } else { // insertion in right subtree
                    if (ptr.right == null) {
                        ptr.right = n;
                        break;
                    } else {
                        ptr = ptr.right;
                    }
                }

            }

        }

    }

    public Node search(int data) {
        Node ptr;
        ptr = root;
        while (ptr != null) {

            if (ptr.item == data)
                return ptr;

            else if (data > ptr.item) {
                ptr = ptr.right;
            } else {
                ptr = ptr.left;
            }

        }
        System.out.println("Search got failed: No such item found");
        return null;

    }

    public Node SEARCH(int data) {
        Node ptr;
        ptr = root;
        while (ptr != null) {
            if (ptr.item == data) {
                return ptr;
            } else if (ptr.item > data) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        System.out.println("Search got failed: No such item found");
        return null;
    }

    public void postorder() {
        postorderRec(root);
    }

    public void postorderRec(Node ptr) {

        if (ptr != null) {

            postorderRec(ptr.left);
            postorderRec(ptr.right);
            System.out.print(" " + ptr.item);

        }

    }

    public void preorder() {
        preorderRec(root);
    }

    public void preorderRec(Node ptr) {

        if (ptr != null) {
            System.out.print(" " + ptr.item);
            preorderRec(ptr.left);
            preorderRec(ptr.right);

        }

    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node ptr) {

        if (ptr != null) {

            inorderRec(ptr.left);
            System.out.print(" " + ptr.item);
            inorderRec(ptr.right);

        }

    }



    public Node deleteNode(Node n, int data){
        if(n==null){
        System.out.println("Deletion failed: No such item found");
        return n;//i.e return null
        }
        if(data<n.item){     //search left tree      
            n.left=deleteNode(n.left, data);

            // if(ptr.item==data){
            //     if(ptr.left==null && ptr.right==null)
            //     n.left=null;
            //     else if((ptr.left==null && ptr.right!=null)||(ptr.right==null &&ptr.left!=null))
            //     n=n.left;
            //     else 
          }

          else if(data>n.item){  //search right treee
            n.right=deleteNode(n.right, data);     
        }

        else{ //i.e if data==n.item (so no needd to search in left or right now)

        if(n.left==null && n.right==null){   //req node has no child
        return null;
        }

        else if(n.left==null || n.right==null){  //req node has one child
            Node ptr;//child     
            if(n.left==null){
            ptr=n.right;
        }else{
            ptr=n.left;
        }
        return ptr;        
        }

        else // i.e if required node has two childs
        {
            Node ParentOfPred=n;
             Node Pred=n.left;
             while(Pred.right!=null){
                ParentOfPred=Pred;
                Pred=Pred.right;
             }
             n.item=Pred.item;

             if (ParentOfPred.right==Pred){
                System.out.println(" (So Predecessor is from right of the leftsubtree)");
                ParentOfPred.right=deleteNode(Pred, Pred.item); //After transfering it's item(predecessor) that node will be deleted.
                
             }else if(Pred==ParentOfPred.left){
                System.out.println(" (So Predecessor is from left node)");
                ParentOfPred.left=deleteNode(Pred,Pred.item);
             }
             

        } 
                 
    }

return n;

        }

    // {
    // Node ptr;
    // ptr=n.right;
    // if(ptr.item==data){
    // if(ptr.left==null && ptr.right==null)
    // n.left=null;
    // else if((ptr.left==null && ptr.right!=null)||(ptr.right==null
    // &&ptr.left!=null))
    // n=ptr;
    // else
    // }

    // }

    public void Delete(int data) {

        root = deleteNode(root, data);

    }

}

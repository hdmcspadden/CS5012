public class TestTree<T> implements Callback<T> {

    private static TestTree<String> callB = new TestTree<String>();

    public static void main(String args[]) {
	BinaryTree<String> tree = new ArrayBasedBinaryTree<String>();
	BinaryTree<String> t1 = new ArrayBasedBinaryTree<String>();
	BinaryTree<String> t2 = new ArrayBasedBinaryTree<String>();
	//BinaryTree<String> tree = new LinkedBinaryTree<String>();
	//BinaryTree<String> t1 = new LinkedBinaryTree<String>();
	//BinaryTree<String> t2 = new LinkedBinaryTree<String>();

	// Print an empty tree
	System.out.println( "Empty tree" );
	callB.dumpState( tree );
	System.out.println( "----");

	// Make this tree
	//
	//            f
	//      b            h
	//  a       d     g
	//       c     e
	// Add a root to the tree
	tree.insertLeft( "f" );
	callB.dumpState( tree );

	// Add left and right children
	tree.toRoot();
	tree.insertLeft( "b" );
	callB.dumpState( tree );

	tree.toLeftChild();
	tree.insertLeft( "a" );
	tree.insertRight( "d" );
	callB.dumpState( tree );

	tree.toRightChild();
	tree.insertLeft( "c" );
	tree.insertRight( "e" );
	callB.dumpState( tree );

	tree.toRoot();
	tree.insertRight( "h" );
	callB.dumpState( tree );

	tree.toRightChild();
	tree.insertLeft( "g" );
	callB.dumpState( tree );

	callB.doTraversals( tree );

	System.out.println( tree );

	System.out.println( "Find check..." );
	String nodes = "abcdefghi";
	for ( int i =0; i < nodes.length(); i++ ) {
	    String cur = nodes.substring( i, i+ 1 );
	    
	    tree.find( cur );
	    System.out.print( cur + "-->" );

	    if ( tree.isValid() ) {
		System.out.println( tree.get() );
	    }
	    else {
		System.out.println( "INVALID" );
	    }
	}

	System.out.println( "Check toParent..." );

	for ( tree.find( "e"); tree.isValid(); tree.toParent() ) {
	    System.out.println( tree.get() );
	}

	System.out.println( "Check equals..." );

	System.out.println( "t1==t2 --> " + t1.equals( t2 ) );
	System.out.println( "tree==t1 --> " + tree.equals( t1 ) );
	System.out.println( "t1==tree --> " + t1.equals( tree ) );

	t1.insertLeft( "root" );
	t2.insertLeft( "root" );

	t1.toRoot();
	t1.insertLeft( "l1" );
	t1.insertRight( "l2" );
	t1.toLeftChild();
	t1.insertLeft( "l3" );
	t1.toLeftChild();
	t1.insertLeft( "l4");

	t2.toRoot();
	t2.insertLeft( "l1" );
	t2.insertRight( "l2" );
	t2.toLeftChild();
	t2.insertLeft( "l3" );
	t2.toLeftChild();
	t2.insertLeft( "l4");

	System.out.println( "t1==t2 --> " + t1.equals( t2 ) );

	System.out.println( "Prune check..." );

	for ( tree.find( "e"); tree.isValid(); tree.toParent() ) {
	    tree.prune();
	    System.out.println( "-----" );
	    System.out.println( tree );
	}

    }

    public void doTraversals( BinaryTree<String> tree ) {
	System.out.print( "Inorder:  " );
	tree.inOrder( callB );
	System.out.println();

	System.out.print( "Preorder:  " );
	tree.preOrder( callB );
	System.out.println();

	System.out.print( "Postorder:  " );
	tree.postOrder( callB );
	System.out.println();
    }

    public void visit( T data ) {
	System.out.print( data.toString() );
    }

    public void dumpState(BinaryTree<T> bt) {
	System.out.println( "------" );
	System.out.println( bt );
	System.out.print("height=" + bt.height());
	System.out.print(", size=" + bt.size());
	System.out.print(", isValid=" + bt.isValid());
	if (bt.isValid()){
	    System.out.print("--> " + bt.get());
	}
	System.out.println();
	System.out.println( "------" );
    }
}


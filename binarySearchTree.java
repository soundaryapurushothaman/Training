class Node
{
	int data;
	Node left;
	Node right;

	Node(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}


class BinaryTree
{
	Node root;

	Node insert(Node root, int key)
	{
		if(root==null)
		{
			return new Node(key);
		}

		if(key<root.data)
		{
			root.left=insert(root.left,key);
		}
		else
		{
			root.right= insert(root.right,key);
		}
		return root;
	}

	void inorderDisp(Node root)
	{
		if(root!=null)
		{
			inorderDisp(root.left);
			System.out.print(root.data+" ");
			inorderDisp(root.right);
		}

	}

	void preorderDisp(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+" ");
			preorderDisp(root.left);
			preorderDisp(root.right);
		}

	}


	void postorderDisp(Node root)
	{
		if(root!=null)
		{
			postorderDisp(root.left);
			postorderDisp(root.right);
			System.out.print(root.data+" ");
		}
	}


	Node delete(Node root, int key)
	{
		if(root==null)
			return null;

		if(key<root.data)
		{
			root.left=delete(root.left,key);
		}
		else if(key>root.data)
		{
			root.right=delete(root.right,key);
		}

		else
		{
			if(root.left==null&&root.right==null)
			{
				return null;
			}

			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;


			Node temp=findNext(root.right);

			root.data=temp.data;
			root.right=delete(root.right,temp.data);
		}
		return root;
	}

	Node findNext(Node root)
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		return root;
	}
}
class Main {
	public static void main(String[] args)
	{
		BinaryTree t=new BinaryTree();

		t.root = t.insert(t.root, 50);
		t.root = t.insert(t.root, 20);
		t.root = t.insert(t.root, 60);

		t.postorderDisp(t.root);

		t.root=t.delete(t.root,60);
		t.inorderDisp(t.root);
	}
}






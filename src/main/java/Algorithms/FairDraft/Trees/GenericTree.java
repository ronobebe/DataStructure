package Algorithms.FairDraft.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenericTree {

  /** A tree which can have N number of childNodes. There is no restrictions to insert a data */
  private Node root;

  private int size;

    private static class Node {
        int data;
        List<Node> child = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }
    }


    public int getSize() {
    return this.size;
  }

  public int childSize(Node node)
  {
      return node==null?0:node.child.size();
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean add(int data) {
    Node head = this.root;
    Node newNode= new Node(data);
    if (head == null) this.root =newNode;
    else {head.child.add(newNode);
    //head.child.get(size-1).child.add(newNode);
        }

    ++this.size;
    return true;
  }

  public  boolean getData(int data)
  {
      if(this.root==null)
          return false;

      int val=this.getData(this.root,data);
      return val==data;
  }


  private int getData(Node node,int maxVal) {


      Queue<Node> q=new LinkedList<>();
      q.add(node);

      while(!q.isEmpty())
      {
          int n=q.size();

          while(n>0)
          {

              Node main=q.peek();
              q.remove();

              if(main.data==(maxVal))
                  return  maxVal;

              for(int i=0; i<main.child.size(); i++)
              {
                  q.add(main.child.get(i));
              }
              n--;
          }

      }


return -1;
  }
  public int maxData()
  {
      if(this.root==null)
          return -1;
      return maxData(this.root, this.root.data);
  }

  public  int maxData(Node node,int maxVal)
  {

      if(node.data>maxVal)
          maxVal=node.data;

          for(int i=0; i<node.child.size(); i++)
          {
                 maxVal= maxData(node.child.get(i),maxVal);

          }

      return maxVal;
  }

  public static void main(String[] args) {
      //

      GenericTree genericTree=new GenericTree();
      genericTree.add(1);
      genericTree.add(2);
      genericTree.add(4);
      genericTree.add(3);
      System.out.println("Max value is : "+ genericTree.maxData());
      System.out.println("Get value is : "+ genericTree.getData(3));

  }
}

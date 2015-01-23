//*******************************************************************
//  MagazineList.java       Author: Pedro Garate
//
//  Represents a collection of magazines.
//*******************************************************************

public class MagazineList
{
   private MagazineNode list;

   //----------------------------------------------------------------
   //  Sets up an initially empty list of magazines.
   //----------------------------------------------------------------
   public MagazineList()
   {
      list = null;
   }

   //----------------------------------------------------------------
   //  Creates a new MagazineNode object and adds it to the end of
   //  the linked list.
   //----------------------------------------------------------------
   public void add (Magazine mag)
   {
      MagazineNode node = new MagazineNode (mag);
      MagazineNode current;

      if (list == null)
         list = node;
      else
      {
         current = list;
         while (current.next != null)
            current = current.next;
         current.next = node;
      }
   }

   //Inserts to front of list
   public void insert(Magazine mag)
   {
	   MagazineNode node = new MagazineNode(mag);
	   	   
	   if (list == null)
		   list = node;
	   else
	   {
		   node.next = list;
		   list = node;
	   }
   }
   
   // Deletes the whole list
   public void deleteAll()
   {
	   if (list != null)
	   {
		   list = null;
	   }
   }
   
   //Deletes one node of the list
   public void delete(Magazine mag)
   {
	   if( list.magazine.toString().equals(mag.toString()) )
       {
           list = list.next;
           return;
       }

       MagazineNode cur  = list;
       MagazineNode prev = null;

       while(cur != null && !cur.magazine.toString().equals(mag.toString()) )
       {
           prev = cur;
           cur = cur.next;
       }

       prev.next = cur.next;
   }

   //----------------------------------------------------------------
   //  Returns this list of magazines as a string.
   //----------------------------------------------------------------
   public String toString ()
   {
      String result = "";

      MagazineNode current = list;

      while (current != null)
      {
         result += current.magazine + "\n";
         current = current.next;
      }

      return result;
   }

   //*****************************************************************
   //  An inner class that represents a node in the magazine list.
   //  The public variables are accessed by the MagazineList class.
   //*****************************************************************
   private class MagazineNode
   {
      public Magazine magazine;
      public MagazineNode next;

      //--------------------------------------------------------------
      //  Sets up the node
      //--------------------------------------------------------------
      public MagazineNode (Magazine mag)
      {
         magazine = mag;
         next = null;
      }
   }
}

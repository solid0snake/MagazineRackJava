//*******************************************************************
//  MagazineView.java       Author: Pedro Garate
//
//  Driver to exercise the MagazineList collection.
//*******************************************************************
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MagazineView extends Applet
{
	private final int APPLET_WIDTH = 440;
    private final int APPLET_HEIGHT = 400;
	String text;
	MagazineList rack = new MagazineList();
	Button del = new Button("Delete All"),
		  show = new Button("List Magazines"),
	     reset = new Button("Reset");
	Label label1 = new Label("Add Magazine:"),
			label2 = new Label("Delete Magazine:");
	TextField magAdd = new TextField("",20),
			magDel = new TextField("",20);
	TextArea magList = new TextArea(text,20,50);
	
   //----------------------------------------------------------------
   //  Creates a MagazineList object, adds several magazines to the
   //  list, then prints it.
   //----------------------------------------------------------------
   public void init()
   {
	  setSize(APPLET_WIDTH, APPLET_HEIGHT);
	  
	  magAdd.addActionListener(new magAddHandler());
	  show.addActionListener(new showHandler());
	  magDel.addActionListener(new magDelHandler());
	  del.addActionListener(new delHandler());
	  reset.addActionListener(new resetHandler());
      magList.setEditable(false);
	  
      this.add(label1);
      add(magAdd);
      add(show);
      add(magList);
      add(label2);
      add(magDel);
      add(del);
      add(reset);
   }
   
   class magAddHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   if (!magAdd.getText().equals(""))
		   {
			   text = magAdd.getText();
			   rack.insert(new Magazine(text));
			   magAdd.setText("");
			   magList.setText(" ");
			   magList.insert(rack.toString(),0);
		   }
	   }
   }
   
   class showHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   magList.setText(" ");
		   magList.insert(rack.toString(),0);
	   }
   }
   
   class magDelHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   text = magDel.getText();
		   rack.delete(new Magazine(text));
		   magDel.setText("");
		   magList.setText(" ");
		   magList.insert(rack.toString(),0);
	   }
   }
   
   class delHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   rack.deleteAll();
		   magList.setText(" ");
	   }
   }
   
   class resetHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   magList.setText(" ");
	   }
   }
      
   public void paint(Graphics page)
   {}
}

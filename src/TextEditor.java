import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TextEditor implements ActionListener
{
    JFrame frame;
    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem newFile,openFile,saveFile,cut,copy,paste,selectAll,close;
    JTextArea textArea;
    TextEditor()
    {
        frame=new JFrame();
        menuBar=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");

        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open File");
        saveFile=new JMenuItem("Save File");

        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");
        close=new JMenuItem("Close");

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        textArea=new JTextArea();
        menuBar.add(file);
        menuBar.add(edit);
        frame.add(textArea);
        frame.setJMenuBar(menuBar);
        frame.setBounds(100,100,400,400);
        frame.setTitle("CPad");
        frame.setVisible(true);

    }
    public static void main(String[] args)
    {
        TextEditor cp=new TextEditor();

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==newFile)
        {

        }
        if(e.getSource()==openFile)
        {

        }
        if(e.getSource()==saveFile)
        {

        }
        if(e.getSource()==cut)
        {
            textArea.cut();
        }
        if(e.getSource()==copy)
        {
            textArea.copy();
        }
        if(e.getSource()==paste)
        {
            textArea.paste();
        }
        if(e.getSource()==selectAll)
        {
            textArea.selectAll();
        }
        if(e.getSource()==close)
        {
            System.exit(0);
        }
    }
}
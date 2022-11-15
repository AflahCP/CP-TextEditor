import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
            TextEditor newTextEditor=new TextEditor();
        }
        if(e.getSource()==openFile)
        {
            JFileChooser fileChooser=new JFileChooser("C:");
            int chooseOption=fileChooser.showOpenDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION)
            {
                File file=fileChooser.getSelectedFile();
                String filePath=file.getPath();
                try
                {
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
                    String intermediate="",output="";
                    while((intermediate=bufferedReader.readLine())!=null)
                    {
                        output+=intermediate+"\n";
                    }
                    textArea.setText(output);
                }
                catch(Exception exception)
                {
                    System.out.println(exception);
                }
            }
        }
        if(e.getSource()==saveFile)
        {
            JFileChooser fileChooser=new JFileChooser("C:");
            fileChooser.setApproveButtonText("Save");
            int chooseOption=fileChooser.showSaveDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                String filePath=file.getPath();
                try
                {
                    BufferedWriter outFile=null;
                    outFile=new BufferedWriter(new FileWriter(file));
                    textArea.write(outFile);
                    outFile.close();
                }
                catch(Exception exception)
                {
                    System.out.println(exception);
                }
            }
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
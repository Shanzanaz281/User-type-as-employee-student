import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.*;
import javax.print.*;
import javax.swing.JOptionPane;
public class PrintManager implements Printable,Pageable
{
PageFormat pf=new PageFormat();
int numberOfPages=0;
double xscale=1.0,pageHeight=1.0;
Component printComponent=null;
static Font fnt=new Font("Arial",Font.PLAIN,12);
static String jobName=System.getProperty("user.name"+"Printing");
PrinterJob pj=PrinterJob.getPrinterJob();
public PrintManager(Component c,String job){
printComponent=c;
if(job!=null && !job.equals(""))
jobName=job;
}
public void measureSizes(){
pageHeight=pf.getImageableHeight();
numberOfPages=(int)Math.ceil((double)printComponent.getHeight()/pageHeight);
pf.setOrientation(PageFormat.PORTRAIT);
Paper paper=new Paper();
paper.setSize(595, 842);
paper.setImageableArea(50,25,printComponent.getHeight(),printComponent.getWidth());
pf.setPaper(paper);
}
public void showPageSetup(){
pf=PrinterJob.getPrinterJob().pageDialog(pf);
}
public void doPrinting(){
try{
pj=PrinterJob.getPrinterJob();
measureSizes();
pj.setPageable(this);
pj.setJobName(jobName);
pj.print();
}

catch(Exception ex){
JOptionPane.showMessageDialog(null,ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
}
}
public void doPrint(){
try{
pj=PrinterJob.getPrinterJob();
measureSizes();
pj.setPageable(this);
pj.setJobName(jobName);
pj.print();
}
catch(Exception ex){
JOptionPane.showMessageDialog(null,ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
}
}
public int getNumberOfPages(){
return numberOfPages;
}
public PageFormat getPageFormat(int index){
return pf;
}
public Printable getPrintable(int index){
return this;
}
public int print(Graphics g,PageFormat pageFormat,int pageindex){
if(pageindex>0)
return NO_SUCH_PAGE;
Graphics2D g2D=(Graphics2D)g;
double scalex=pageFormat.getImageableWidth()/printComponent.getWidth();
double scaley=pageFormat.getImageableHeight()/printComponent.getHeight();
double scale=Math.min(scalex,scaley);
g2D.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
g2D.scale(scale,scale);
printComponent.print(g2D);
return PAGE_EXISTS;    }}

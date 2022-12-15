import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PrintPreview extends JFrame implements ItemListener
{
GridBagLayout gb = new GridBagLayout();
GridBagConstraints gbc = new GridBagConstraints();
java.awt.print.Pageable page=null;
java.awt.print.PageFormat pf=new java.awt.print.PageFormat();
PreviewPanel pp=new PreviewPanel();
JComboBox jcb=new JComboBox();
void addcomp(int row, int col, int wide, int high, Component com)
{
gbc.gridx = col;
gbc.gridy = row;
gbc.gridwidth = wide;
gbc.gridheight = high;
gbc.weightx = 1.0;
gbc.weighty = 1.0;
gbc.fill =GridBagConstraints.BOTH;
gbc.insets = new Insets(2,2,2,2);
gb.setConstraints(com, gbc);
add(com);
if (com instanceof Checkbox)
{
Checkbox cxb=(Checkbox) com;
cxb.addItemListener(this);
}
}
public PrintPreview()
{
super("Print Preview");
setLayout(gb);
jcb.setBorder(BorderFactory.createTitledBorder("Page"));
JPanel p=new JPanel(new FlowLayout());
p.add(jcb);
JScrollPane jsp = new JScrollPane(pp);
addcomp(1,0,1,1,jsp);
this.setSize(getToolkit().getScreenSize());
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
public void showPreview(java.awt.print.Pageable p)
{
page=p;
jcb.removeAllItems();
for(int i=0,n=p.getNumberOfPages();i<n;i++)
jcb.addItem(" "+(i+1));
this.setVisible(true);
pp.repaint();
}
public void itemStateChanged(ItemEvent ie)
{
pf=page.getPageFormat(jcb.getSelectedIndex());
if(pf.getOrientation()==java.awt.print.PageFormat.LANDSCAPE){
pp.setSize((int)pf.getHeight(),(int)pf.getWidth());
pp.setPreferredSize(this.getSize());
}
else
{
pp.setSize((int)pf.getWidth(),(int)pf.getHeight());
pp.setPreferredSize(this.getSize());
}
pp.validate();
pp.repaint();
}
class PreviewPanel extends JPanel implements Scrollable
{
public void paint(Graphics gr)
{
int index=jcb.getSelectedIndex();
Graphics2D g=(Graphics2D)gr;
this.setSize(842,595);
this.setPreferredSize(this.getSize());
g.translate(0.0,getHeight());
g.rotate(3.0*Math.PI/2.0,0.0,0.0);
Color prev=g.getColor();
g.setColor(Color.white);
g.fillRect(0,0,(int)pf.getWidth(),(int)pf.getHeight());
g.setColor(prev);
try{
page.getPrintable(index).print(g,pf,index);
}catch(Exception ex){
JOptionPane.showMessageDialog(null, ex.toString(), "Errot", JOptionPane.ERROR_MESSAGE);}
}
public java.awt.Dimension getPreferredScrollableViewportSize()
{
return this.getPreferredSize();
}
public int getScrollableBlockIncrement(java.awt.Rectangle r,int x, int y)
{
return 25;
}
public boolean getScrollableTracksViewportHeight()
{
return false;
}
public boolean getScrollableTracksViewportWidth()
{
return false;
}
public int getScrollableUnitIncrement(java.awt.Rectangle r,int x,int y)
{
return 10;
}
}
}
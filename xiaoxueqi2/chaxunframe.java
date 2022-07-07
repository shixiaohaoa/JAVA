package xiaoxueqi.xiaoxueqi2;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class chaxunframe extends JFrame {
    private JScrollPane scpDemo;//滚动面板
    private JTableHeader jth;//表头
    private JTable tabDemo;//表格
    private JButton btnShow;//按钮
    private JLabel jlb;//面板
    private JTextField jtf;//输入学号
    private String xuehao;

   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    chaxunframe frame = new chaxunframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//运行chaxunframe方法
    }*/

    public chaxunframe() {
       this.setTitle("学生信息表");  //标题名称
        this.setSize(660, 600);        //控制窗体大小
        this.setLayout(null);        //自定义布局
        this.setLocationRelativeTo(null);//点击运行以后，窗体在屏幕的位置
        this.scpDemo = new JScrollPane();
        this.btnShow = new JButton("显示数据");
        this.jlb=new JLabel("请输入学号:");
        this.jtf=new JTextField();
        this.scpDemo.setBounds(10, 50, 580, 400);    //设置滚动框大小
        this.btnShow.setBounds(10, 10, 120, 30);    //设置按钮
        this.jlb.setBounds(150,10,80,30);
        this.jtf.setBounds(225,10,160,30);
        this.btnShow.addActionListener(      new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow_ActionPerformed(ae);
            }
        });
        /******* 将组件加入到窗体中******/
        add(this.scpDemo);//向jframe里面添加滚动面板
        add(this.btnShow);//王jframe里面添加显示按钮
        add(this.jlb);//添加一个面板
        add(this.jtf);//添加一个用于输入学号的文本域
       // Monitor m = new Monitor();
        //jtf.addActionListener(m);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口只能关闭这个部分
    }

    /*class Monitor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           jtf = (JTextField) e.getSource();
           // jtf = (JTextField) e.getActionCommand
            xuehao=jtf.getText();
        }
    }*/

    /***连接数据库并显示到表格中***/

    public void btnShow_ActionPerformed(ActionEvent ae) {
            xuehao=jtf.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xiaoxueqi";
            String username = "root";
            String passwords = "123456";
            Connection conn = DriverManager.getConnection(url, username, passwords);//链接数据库
            String sql = "select * from student where Sno=?";//sql查询语言

            PreparedStatement pstm = conn.prepareStatement(sql);//执行sql语言,preparedStatement是数据库方法里面的一个对象

            pstm.setString(1,xuehao);//第一个参数是该参数在语句中的索引。参数标记具有从 1 开始的编号。 通常指的是第一个“？”,第二个参数是要对第一个参数设置的值

            ResultSet rs = pstm.executeQuery();//用于查询返回结果集

            // 将查询获得的记录数据，转换成适合生成JTable的数据形式

            Object[][]a = new Object[1][4];//相当于一个二维数组

            String[] title = {"学号", "姓名", " 性别", "出生年月"};//设置表头
            while (rs.next()) {
                a[0][0] = rs.getString("Sno");//获取对应位置对应表里面数据
                a[0][1] = rs.getString("Sname");
                a[0][2] = rs.getString("Ssex");
                a[0][3] = rs.getString("Birth");
            }//rs.next 就是你要取的下一条数据 从0开始的 判断还有数据 就是true 如果有数据 那么可以把当前的这条数据取出来 显示到页面上 如果没有数据了 就是false 那么循环结束 其实就是一个循环把rs里面的数据读出来的过程
            // 创建JTable
            this.tabDemo = new JTable(a, title);//以title为表头，a为数据创建表格。
            // 显示表头
            this.jth = this.tabDemo.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo.getViewport().add(tabDemo);
            this.tabDemo.getTableHeader().setReorderingAllowed(false);//设置表头不可移动
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}

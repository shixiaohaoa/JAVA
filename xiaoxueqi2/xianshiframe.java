package xiaoxueqi.xiaoxueqi2;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class xianshiframe extends JFrame {
    private JScrollPane scpDemo;//滚动面板
    private JTableHeader jth;//表头
    private JTable tabDemo;//表格
    private JButton btnShow;//按钮
    public xianshiframe() {
        this.setTitle("学生信息表");//标题名称
        this.setSize(660, 600);        //控制窗体大小
        this.setLayout(null);        //自定义布局
        this.setLocationRelativeTo(null);//点击运行以后，窗体在屏幕的位置
        this.scpDemo = new JScrollPane();
        this.btnShow = new JButton("显示数据");
        this.scpDemo.setBounds(10, 50, 580, 400);    //设置滚动框大小
        this.btnShow.setBounds(10, 10, 120, 30);    //设置按钮
        this.btnShow.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow_ActionPerformed(ae);
            }
        });

        /******* 将组件加入到窗体中******/
        add(this.scpDemo);//向jframe里面添加滚动面板
        add(this.btnShow);//王jframe里面添加显示按钮
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口只能关闭这个部分
    }
    /***连接数据库并显示到表格中***/
    public void btnShow_ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/xiaoxueqi";
            String username = "root";
            String passwords = "123456";
            Connection conn = DriverManager.getConnection(url, username, passwords);//链接数据库
            String sql = "select * from student";//sql查询语言
            PreparedStatement pstm = conn.prepareStatement(sql);//调用sql语言查询
            ResultSet rs = pstm.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
            }//rs.next()就是遍历数据 如果还有数据就为true 继续执行，给个i++来取数据的总个数。
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][]a = new Object[i][4];//相当于一个二维数组
            String[] title = {"学号", "姓名", " 性别", "出生年月"};//设置表头
            i = 0;
            while (rs.next()) {
                a[i][0] = rs.getString("Sno");//获取对应位置对应表里面数据
                a[i][1] = rs.getString("Sname");
                a[i][2] = rs.getString("Ssex");
                a[i][3] = rs.getString("Birth");
                i++;
            }
            // 创建JTable
            this.tabDemo = new JTable(a, title);//以title为表头，a为数据创建表格。
            // 显示表头
            this.jth = this.tabDemo.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo.getViewport().add(tabDemo);//添加在滚动面板表头自动显示在最上方
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



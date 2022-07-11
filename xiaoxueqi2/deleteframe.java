package xiaoxueqi.xiaoxueqi2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class deleteframe extends JFrame {
    private  String xuehao;

    public static void main(String[] args) {
        deleteframe frame=new deleteframe();
        frame.setVisible(true);
    }
    public deleteframe(){
        this.setSize(450,240);//设置窗口大小
        this.setLayout(null);//设置为自定义布局
        this.setLocationRelativeTo(null);//点击运行以后，窗体在屏幕的位置
        JLabel jl1=new JLabel("请输入要删除的学生的学号");//标签组件
        final JTextField jtf1=new JTextField();//文本域
        JButton jb1=new JButton("确认删除");
        jl1.setBounds(40,60,150,40);
        jtf1.setBounds(200,60,180,40);
        jb1.setBounds(160,120,100,40);
        add(jl1);
        add(jtf1);//向jframe里面添加
        add(jb1);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuehao=jtf1.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/xiaoxueqi";    //JDBC的URL
                    Connection conn = DriverManager.getConnection(url,"root","123456");//链接数据库

                    String sql = "delete from student where Sno=?";   //删除数据的代码
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1,xuehao);
                   int count= pst.executeUpdate();
                   if(count>0){
                       JOptionPane.showMessageDialog(null, "删除成功", "成功", JOptionPane.ERROR_MESSAGE);
                   }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    //处理classfor错误
                    JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    //处理jdbc错误
                    JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }
}

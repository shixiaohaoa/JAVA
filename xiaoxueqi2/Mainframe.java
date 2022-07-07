package xiaoxueqi.xiaoxueqi2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
public class Mainframe extends JFrame {

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainframe frame = new Mainframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });//运行Mainframe方法
    }*/

    public Mainframe() {
        setResizable(false); // 设置大小不可改变
        setTitle("学生管理系统");// 设置标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 由于这是主页面，所有当主页面关闭的时候，程序就直接退出
        setBounds(100, 100, 450, 420);//设置窗口的初始位置高度和宽度
        setLocationRelativeTo(null); // 设置窗口相对于 c 的位置，当 c 为空或者 null 时，默认为是相对于屏幕中央
        JPanel jp = new JPanel(); // 实例化一个 pane
        jp.setBorder(new EmptyBorder(5, 5, 5, 5));//设置边框相当于html的padding 上下左右内边距为5
        add(jp);//向jframe里面添加面板
        jp.setLayout(null);//设置自定义布局

        JLabel lblNewLabel = new JLabel("学生管理系统");//创建一个标签组件实例
        lblNewLabel.setForeground(Color.RED);//设置文字颜色
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));//设置字体，加粗，字体大小
        lblNewLabel.setBounds(140, 10, 163, 44);//设置面板位置和宽高
        jp.add(lblNewLabel);//向面板里面添加一个标签组件

        JButton checkButton = new JButton("显示信息");//创建一个按钮
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xianshiframe jf =new xianshiframe();
                jf.setVisible(true);
            }
        });//添加事件监听器，点击后触发重写的方法。
        checkButton.setFont(new Font("宋体", Font.PLAIN, 18));//设置字体和字体大小
        checkButton.setBounds(167, 64, 114, 37);//设置面板位置和宽高
        jp.add(checkButton);//向面板添加按钮

        JButton addButton = new JButton("添加学生");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.setFont(new Font("宋体", Font.PLAIN, 18));
        addButton.setBounds(167, 121, 114, 37);
        jp.add(addButton);

        JButton changeButton = new JButton("修改学生");
        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        changeButton.setFont(new Font("宋体", Font.PLAIN, 18));
        changeButton.setBounds(167, 180, 114, 37);
        jp.add(changeButton);

        JButton deleteButton = new JButton("删除学生");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });
        deleteButton.setFont(new Font("宋体", Font.PLAIN, 18));
        deleteButton.setBounds(167, 240, 114, 37);
        jp.add(deleteButton);


        JButton queryButton = new JButton("查询信息");
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chaxunframe jfc=new chaxunframe();
                jfc.setVisible(true);
            }
        });
        queryButton.setFont(new Font("宋体", Font.PLAIN, 18));
        queryButton.setBounds(167, 300, 114, 37);
        jp.add(queryButton);
    }
}

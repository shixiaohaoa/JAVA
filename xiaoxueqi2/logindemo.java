package xiaoxueqi.xiaoxueqi2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class logindemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("学生系统登录");        // 创建 JFrame 实例

        frame.setSize(350, 200);//设置窗口高宽

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口按钮

        JPanel panel = new JPanel();  //创建面板

        frame.add(panel);    // 添加面板

        frame.setLocationRelativeTo(null);//居中显示

        frame.setVisible(true);  // 设置界面可见

        panel.setLayout(null);//设置为自定义布局

        JLabel userLabel = new JLabel("用户名:");   // 创建 用户JLabel相当于一个容器

        userLabel.setBounds(10,20,80,25);//设置位置，宽高。

        panel.add(userLabel);//把用Jlabel放在面板里面

        /*
         * 创建文本域用于用户输入用户名
         */
        final JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //创建密码Jlabel
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */

        final JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(140, 80, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userText.getText().equals("root") &&
                        new String(passwordText.getPassword()).equals("123456")){
                    Mainframe frame=new Mainframe();
                    frame.setVisible(true);
                }else {
                    System.exit(0);
                }
             }
        });//添加事件监听器，重写方法，点击后触发。
        //用户名错误点击登录退出系统，在用户名正确后点击登录密码错误也会直接退出程序，只有2个都正确才能进入主界面。
    }
}
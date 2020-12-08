import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ssh.JschSessionPool;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.File;


public class sshTest {
    public static void main(String[] args) {
        sftpTest();
    }

    public static void sftpTest(){
        Session session = getSession("192.168.222.171", 22, "root", "123456");
        Sftp sftp = JschUtil.createSftp(session);
        sftp.download("/home/1.txt", FileUtil.file("C:\\learning\\java\\ Examination_System\\download\\1.txt"));
    }

    public static Session getSession(String sshHost, int sshPort, String sshUser, String sshPass) {
        return JschSessionPool.INSTANCE.getSession(sshHost, sshPort, sshUser, sshPass);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atomicgit;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Scott
 */
public class Batch {

    private String gitEmail="";
    private String gitUsername="";
    private String pcRepo="";
    private String pcUser="%HOMEDRIVE%%HOMEPATH%";
    private String gitDir="C:\\Program Files (x86)\\Git";
    private String cmdDir="C:\\Windows\\SysWOW64\\cmd.exe";
    public String CallGit()
    {
        String str = "@echo off\n";
        str += cmdDir + " /c \"\"" + gitDir + "\bin\\sh.exe\" --login -i -c \"%1%\"\"";
        return str;
    }

    public String CreateRepo()
    {
        String str = "echo Enter local repository folder name:";
        str += "read repoName";
        str += "echo Enter git repository name:";
        str += "read gitRepoName";
        str += "mkdir " + pcRepo + "/$repoName";
        str += "cd " + pcRepo + "/$repoName";
        str += "git init";
        str += "touch README";
        str += "git add README";
        str += "git commit -m 'Added README file'";
        str += "git remote add origin git@github.com:" + gitUsername + "/$gitRepoName.git";
        str += "git push -u origin master";
        str += "echo ...Complete...";
        str += "read";
        return str;
    }

    String SetupSsh()
    {
        String str = "gitEmail='" + gitEmail +"'";
        str += "cd " + pcUser + "/.ssh";
        str += "mkdir key_backup";     //Backup old RSA keys
        str += "cp id_rsa* key_backup";
        str += "rm id_rsa*";
        str += "ssh-keygen -t rsa -C $gitEmail";
        str += "start https://github.com/account/ssh";
        str += "echo ... Press Enter...";
        str += "echo Testing connection";
        str += "ssh git@github.com";
        str += "echo Complete";
        str += "read";
        return str;
    }

    private void AddToClipboard(String str)
    {
        StringSelection data = new StringSelection(str);
        Clipboard clipboard =
        Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(data, data);
    }

}

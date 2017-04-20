package br.com.gaboso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Carvalho - <gabrielsantiago2@gmail.com>
 * @since 19/04/2017
 * <p>
 * br.com.gaboso.Scriptum
 */
public class Scriptum {

    private static final String CMD_EXE = "cmd.exe";
    private static final String SLASH_C = "/c";
    private static final String DIRETORIO = "\r\n\r\nDiretorio: ";

    public static void main(String[] args) {
        if (args.length > 0) {
            Scriptum scriptum = new Scriptum();
            List<File> folders = scriptum.getFoldersFromWorkspace(args[0]);

            for (File file : folders) {
                scriptum.analyzeFolders(file);
            }
        }
    }

    private void executeCMD(String cmd) {
        ProcessBuilder builder = new ProcessBuilder(CMD_EXE, SLASH_C, cmd);
        builder.redirectErrorStream(true);

        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while (true) {
                line = r.readLine();
                if (line == null)
                    break;

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<File> getFoldersFromWorkspace(String path) {
        File fileInitial = new File(path);
        File[] listFiles = fileInitial.listFiles();
        List<File> folders = new ArrayList<>();

        if (listFiles != null) {
            System.out.println("| LISTA DE DIRETORIOS DO WORKSPACE |");
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    folders.add(file);
                    System.out.println("| "+file.getName()+" |");
                }
            }
        }

        return folders;
    }

    private void analyzeFolders(File file) {
        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            for (File fileFromList : listFiles) {

                if (fileFromList.isDirectory() && fileFromList.getName().contains(".git")) {
                    System.out.println(DIRETORIO + file.getName() + " | Atualizando GIT");
                    executeCMD("cd " + file.getPath() + "\\ && git fetch && git pull origin");
                }

                if ("pom.xml".equals(fileFromList.getName())) {
                    System.out.println(DIRETORIO + file.getName() + " | Atualizando MAVEN");
                    executeCMD("cd " + file.getPath() + "\\ && mvn clean install -DskipTests=true");
                }

                if ("package.json".equals(fileFromList.getName())) {
                    System.out.println(DIRETORIO + file.getName() + " | Atualizando NPM");
                    executeCMD("cd " + file.getPath() + "\\ && npm install && npm update");
                }

                if ("bower.json".equals(fileFromList.getName())) {
                    System.out.println(DIRETORIO + file.getName() + " | Atualizando BOWER");
                    executeCMD("cd " + file.getPath() + "\\ && bower install && bower update");
                }
            }
        }
    }

}
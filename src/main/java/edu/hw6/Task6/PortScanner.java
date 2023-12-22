package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public final class PortScanner {

    private final static Integer START_PORT = 0;
    private final static Integer END_PORT = 49151;
    private final static Logger LOGGER = LogManager.getLogger();
    private static final Map<Integer, String> KNOWN_PORTS = new HashMap<>() {{
        put(135, "EPMAP");
        put(137, "NetBIOS Name Service");
        put(138, "NetBIOS Datagram Service");
        put(139, "NetBIOS Session Service");
        put(445, "Microsoft-DS Active Directory");
        put(843, "Adobe Flash");
        put(1900, "Simple Service Discovery Protocol (SSDP)");
        put(3702, "Dynamic Web Services Discovery");
        put(23, "Telnet");
        put(110, "POP3");
        put(5353, "Multicast DNS");
        put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        put(143, "IMAP ");
        put(3306, "MySQL");
        put(1521, "Oracle database server");
        put(17500, "Dropbox");
        put(443, "VMware vSphere Client");
        put(27017, "MongoDB");
        put(5900, "Virtual Network Computing for remote access");
    }};

    private PortScanner() {}

    public static void regTCP() {
        for (int port = START_PORT; port <= END_PORT; port++) {
            try {
                ServerSocket connect = new ServerSocket(port);
                connect.close();
            } catch (IOException e) {
                if (KNOWN_PORTS.containsKey(port)) {
                    LOGGER.info("TCP" + "\t" + port + "\t" + KNOWN_PORTS.get(port));
                }
            }
        }
    }

    public static void regUDP() {
        for (int port = START_PORT; port <= END_PORT; port++) {
            try {
                DatagramSocket connect = new DatagramSocket(port);
                connect.close();
            } catch (SocketException e) {
                if (KNOWN_PORTS.containsKey(port)) {
                    LOGGER.info("UDP" + "\t" + port + "\t" + KNOWN_PORTS.get(port));
                }
            }
        }
    }
}

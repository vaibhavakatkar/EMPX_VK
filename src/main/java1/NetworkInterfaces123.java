import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
public class NetworkInterfaces123 {
	public static void main(String[] args) throws PcapNativeException, UnknownHostException, EOFException, TimeoutException, NotOpenException {
		InetAddress addr = InetAddress.getByName("vaibhav");
		
		//InetAddress addr = InetAddress.getLocalHost();
		
		PcapNetworkInterface nif = Pcaps.getDevByAddress(addr);
		
		int snapLen = 65536;
		PromiscuousMode mode = PromiscuousMode.PROMISCUOUS;
		int timeout = 10;
		PcapHandle handle = nif.openLive(snapLen, mode, timeout);
		
		Packet packet = handle.getNextPacketEx();
		handle.close();
		
	}
}
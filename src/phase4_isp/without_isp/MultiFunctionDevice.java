package phase4_isp.without_isp;
//WITHOUT ISP — fat interface forcing everyone to implement everything
public interface MultiFunctionDevice {
	
	void print(String document);
	void fax(String document);
	void scan(String document);
	void staple(String docuement);

}

package java_core_bai13;

import java.time.LocalDate;

public class Certificate {
	private String certificateID;
	private String certificateName;
	private String certificateRank;
	private LocalDate certificatedDate;

	public Certificate(String certificateID, String certificateName, String certificateRank,
			LocalDate certificatedDate) {
		super();
		this.certificateID = certificateID;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificatedDate = certificatedDate;
	}

	public String getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(String certificateID) {
		this.certificateID = certificateID;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateRank() {
		return certificateRank;
	}

	public void setCertificateRank(String certificateRank) {
		this.certificateRank = certificateRank;
	}

	public LocalDate getCertificatedDate() {
		return certificatedDate;
	}

	public void setCertificatedDate(LocalDate certificatedDate) {
		this.certificatedDate = certificatedDate;
	}
	
	public void showInfor() {
		String output = String.format("Certificate ID: %-7s | Certificate Name: %-15s | Certificate Rank: %-7s | Certificated Date: %s",
	            certificateID, certificateName, certificateRank, certificatedDate);
	    System.out.println(output);
	}
}

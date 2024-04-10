package ait.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Builder;

@Entity
@Table(name = "resumes")

public class ResumeFile {
	 @Id
	    @GeneratedValue(generator = "uuid")
	    private Long id;

	    private String fileName;

	    private String fileType;
	    
	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "candidate_id")
	    private Candidate candidate;

	    public Candidate getCandidate() {
			return candidate;
		}

		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}

		@Lob
	    private byte[] data;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public ResumeFile(Long id, String fileName, String fileType, byte[] data) {
			super();
			this.id = id;
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public ResumeFile() {
			super();
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public ResumeFile(String fileName, String fileType, byte[] data,Candidate candidate) {
			super();
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
			this.candidate = candidate;
		}
		public ResumeFile(String fileName, String fileType, byte[] data) {
			super();
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}
		
		

}

package ait.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonComponent
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApplyRequest{
	private Long jobId;
    private Long candidateId;
    private Long vendorId;
    private Long hiringManagerId;
    
	
    

}

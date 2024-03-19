package com.tatva.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllIdsRequestDto {
	//academicId AND yearTypeId AND semesterId AND programId
	
	private Integer academicId;
	

	private Integer yearTypeId;
	
	
	private Integer semesterId;
	
	private Integer programId;
}

package com.proj.mgmt.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
public class ProjectKey  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="PROJ_ID")
	private String projId;
	
	@Column(name="DEPART_ID")
	private String depart;

}

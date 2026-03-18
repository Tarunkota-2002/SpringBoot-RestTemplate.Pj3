package com.springboot.restapi.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRestTemplatedto {
	private String name;
	private String mailid;

}

package com.dollop.app.entity.payload;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionsAccess {

	// Employee section Permission Access;

	Map<String, Boolean> permission = new HashMap<>();

	

}

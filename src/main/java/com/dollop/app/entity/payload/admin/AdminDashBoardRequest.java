package com.dollop.app.entity.payload.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDashBoardRequest {
   private Long totalProjects;
   private Long totalClients;
   private Long totalTasks;
   private Long totalEmployees;
   
  
}

package com.dollop.app.entity.payload.admin;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDashBoardResponse {
	private Long totalProjects;
	private Long totalClients;
	private Long totalTasks;
	private Long totalEmployees;

	private List<Object[]> staticsOfCompany;
	private List<Double> netProfit = new ArrayList<>();
	private List<Double> revenue = new ArrayList<>();
	private List<Integer> years = new ArrayList<>();
	private List<Double> allMonthStatics = new ArrayList<>();
}

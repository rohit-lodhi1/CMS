package com.dollop.app.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dollop.app.repository.GoalListRepository;

@Component
public class GoalListSchedular {

	@Autowired
	public GoalListRepository goalListRepository;

	
	

    @Scheduled(cron = "0 0 0 * * ?") // Run daily at midnight
    public void updateProgress() {
     this.goalListRepository.updateProgressOfGoalList();
    }

    public Double calculateProgress(Date startDate,Date endDate) {
        if (startDate == null || endDate == null) {
            // Handle the case where start date or end date is not set
            return 0.0;
        }

        LocalDate currentDate = LocalDate.now();

        // Ensure the current date is within the goal's start and end date
        if (currentDate.isBefore(startDate.toLocalDate())) {
            return 0.0; // The goal has not started yet
        } else if (currentDate.isAfter(endDate.toLocalDate())) {
            return 100.0; // The goal has already ended
        }

        // Calculate the progress based on the current date relative to start and end dates
        long totalDays = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
        long daysPassed = ChronoUnit.DAYS.between(startDate.toLocalDate(), currentDate);

//        return (double) (daysPassed / totalDays * 100);
        BigDecimal result = new BigDecimal(((double) daysPassed / totalDays * 100));
        return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}

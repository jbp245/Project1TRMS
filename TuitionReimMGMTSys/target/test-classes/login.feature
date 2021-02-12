Feature: login feature works

	Scenario Outline: login works
		Given login page
		When user types in "<username>" and "<password>" and submits 
		Then broght to dashboard's "<title>"
		
	Examples:
        |username   |password   |title           |
        |amartin    |pass       |TRMS - Dashboard|
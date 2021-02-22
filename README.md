# Tuition Reimbursement Management System (Project 1)
by James Patten

## Project Description
The Tuition Reimbursement Management System is a workflow management system that enables organization members to submit reimbursement requests for continued learning, courses, and trainings. Submitted forms must be approved by direct superiors, department heads, and the benefits coordinator, before getting reviewed for a passing grade. Assuming all the prerequisites are met, the employee will recieve the reimbursement. Employees may claim up to $1000 in education related reimbursements per calendar year.

## Technologies Used
* Java - version 15
    * JRE - version 1.8
* Oracle Database - version 19c
    * Hosted on AWS RDS
* HTML/CSS/JS - Bootstrap version 4
* Apache Tomcat - version 9
* Cucumber - version 4.2.0
* Selenium - version 4.0
    * WebDriver (Chrome) - version 88.0.4324.96
* Junit - version 4

## Features
* Employee information (name, id, role, supervisor name, etc.) populated based on the current logged in user.
* Dynamic tables for user's pending forms and those requiring user's approval.
    * User can reject or approve subordinate requests, ending the request or forwarding higher in the chain of command
    * Benefits Coordinator can override and approve any requests, leading directly to reimbursment.
* Reimbursement form is prepopulated with given employee information; input disabled to ensure accuracy.
* Input validation handled in front-end HTML.

### To-do list:
* Perform date validation and setting forms within 2 weeks of expiry to urgent.
* Allow users to submit final grades.
* Allow approvals and rejections to optionally attach a message.
* Handle attachment uploads as BLOBs in the database; do not exclusively set to null.
* Convert db primary keys to their string value pair in "requires approval" table

## Getting Started
1. Clone from Github
2. Request DB snapshot from james.patten@revature.net
3. Set JDBC credentials in connections file (currently set to environment variables)
4. Run as application and access index.html

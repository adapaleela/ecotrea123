Feature: Ecoterra site testing as an employee
Scenario Outline: Ecoterra Login testing as an employee
Given launch site
When click on dropdown and select customer from dropdown
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
And close site
Examples:
|         uid       |uid criteria|  pwd   |pwd criteria|
|         kj        | valid      |pass@123|valid       |
|                   | uid_blank  |pass@123|valid       |
|         kj        | valid      |        |pwd_blank   |
|   admin@admon.cim |invalid     |pass@123|valid       |
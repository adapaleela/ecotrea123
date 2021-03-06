Feature: Ecoterra site testing as an admin
Scenario Outline: Ecoterra Login testing as admin
Given launch site
When click on dropdown and select admin from dropdown
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
And close site
Examples:
|         uid       |uid criteria|  pwd   |pwd criteria|
|    admin@admin.com | valid      |pass@123|valid       |
|                    | uid_blank  |pass@123|valid       |
|   admin@admin.com  | valid      |        |pwd_blank   |
|   admin@admon.cim  |invalid     |pass@123|valid       |



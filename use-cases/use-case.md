# USE CASE: 4 Produce a Report on the Salary of Employees of a Given Role

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Stakeholders* I want *to report on population information* so that *I can support financial reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

<<<<<<<<< Temporary merge branch 1  
We know the role.  Database contains current world population data.
=========
We know the information. Database contains current world population data.
>>>>>>>>> Temporary merge branch 2

### Success End Condition

A report is available for Stakeholders to provide to organization.

### Failed End Condition

No report is produced.

### Primary Actor

Stakeholders.

### Trigger

A request for world population information is sent to Stakeholder.

## MAIN SUCCESS SCENARIO

<<<<<<<<< Temporary merge branch 1
1. Finance request salary information for a given role.
2. HR advisor captures name of the role to get salary information for.
3. HR advisor extracts current salary information of all employees of the given role.
4. HR advisor provides report to finance.
=========
1. Organization request world population information for a given role.
2. Stakeholders capture name to get population information for.
3. Stakeholders extract current population information of world, continents, regions, countries, district and cities of the given role.
4. Stakeholders provide report to organization.
>>>>>>>>> Temporary merge branch 2

## EXTENSIONS

3. **Role does not exist**:
<<<<<<<<< Temporary merge branch 1
    1. HR advisor informs finance no role exists.
=========
    1. Stakeholders inform organization no role exists.
>>>>>>>>> Temporary merge branch 2

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

# USE CASE: 4 Produce a Report on the Salary of Employees of a Given Role

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Stakeholders* I want *to report on population information* so that *I can support financial reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the information. Database contains current world population data.

### Success End Condition

A report is available for Stakeholders to provide to organization.

### Failed End Condition

No report is produced.

### Primary Actor

Stakeholders.

### Trigger

A request for world population information is sent to Stakeholder.

## MAIN SUCCESS SCENARIO

1. Organization request world population information for a given role.
2. Stakeholders capture name to get population information for.
3. Stakeholders extract current population information of world, continents, regions, countries, district and cities of the given role.
4. Stakeholders provide report to organization.

## EXTENSIONS

3. **Role does not exist**:
    1. Stakeholders inform organization no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

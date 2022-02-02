# Continuous Integration
Continuous Integration (CI) is the most fundemental step in creating an autonomous development pipeline. CI is achieved by the practice of consistently merging code into a central repository. More importantly, CI benefits greatly from the inclusion of rigorous testing as part of your CI process. Particularly important are unit and integration testing. 

### Unit & Integration Testing
Unit testing is the process of testing individual software units, like methods or functions. The idea is to test each component in isolation to make sure it behaves as expected. 
  
Integration testing is the process of testing modules of software, composed of many units. Modules are combined and tested to make sure they behave as expected.

### Testing Offers Feedback
DevOps is about automating and streamlining the parts of software development that get the developers feedback. CI married with testing is the first step to fully realizing an autonomous development pipeline. Each time a developer completes some amout of work and merges that work with the repository, each unit of that new code is tested, and then that new code is integrated and tested with the rest of the code. If testing methodology is done well, this should provide rapid feedback about bugs and failures as each module develops.

  
    
![CI Circle](https://github.com/LiquidPlummer/DevOpsDayLessonPlan/blob/main/continuous-integration-circle.png?raw=true)

Continuous Integration establishes the foundation for an automated DevOps pipeline, because it provides the following benefits:

 - Ensures the entire team works on the most up to date code
    - Frequently pushing code allows developers to account for changes performed by other team members quickly.
 - Detects broken builds quickly
   - If problems arise, version control software can help detect the root cause or rollback changes when necessary.
 - Code can be tested easily by creating separate, test or development branches based on the mainline code.
 - Reduces risk in development when a large codebase has already been established.
 - Reduces the overall amount of bugs in a project


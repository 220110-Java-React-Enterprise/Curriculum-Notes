# DevOps-Demo

This demo is an example of how to create a devops pipeline using Amazon's services to deploy our project on the web.

We are using CodePipeline, & CodeBuild to do the build, we are using E3 for storage, Elastic Beanstalk for orchestration, EC2 for hosting.

We are going to have CodePipeline monitor our github repos, and initiate a build whenever the source code in some branch is updated. You could have it monitor the "main" branch, but I would suggest using a special branch, like "DevOps" for this purpose.

With that devops branch I would suggest setting up workflows for merging, specifically set it up to require some reviews. Reviews are when a pull request (that's how we merge our code into the codebase) are made it will notify some reviewers (that's you folks) that you need to look at and sign off on the pull request before it can be completed.

We need to create a CodeBuild "job".
We need to create an EBS "environment".
We need to create a CodePipeline that uses the above EBS env and CodeBuild job.
We need to set up storage in an S3 bucket to hold secure stuff (like application.properties)


We need to apply the path fix for tomcat webservers.
We need a buildspec.yml - this is the series of instructions in yml format that codebuild uses to complete the job. This is called "Infrastructure as Code", which means that the instructions to do the operation are not only automated, but part of the codebase. 

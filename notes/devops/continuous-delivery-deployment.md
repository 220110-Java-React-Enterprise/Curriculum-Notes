# Continuous Delivery
Continuous Delivery (Not 'CD', that's Deployment) is a paradigm in which the building, management and testing of produced software is automated such that deployments can be performed at the push of a button.  
  
![Continuous Delivery](https://github.com/LiquidPlummer/DevOpsDayLessonPlan/blob/main/continuous-delivery.png?raw=true)  
  
Continuous Delivery seeks to automate every possible step up to but not including deployment. Continuous delivery is achieved when every change is proven, by automated process, to be deployable at any time. Continuous Delivery depends on CI and is a stepping stone on the way to CD (a fully automated development pipeline). Since we don't include deploying the product we can still preform final user testing, and/or leave the production deployment to a regular schedule.  
  
# Continuous Deployment
Continuous Deployment(CD) advances continuous delivery by also automating the deployment of software to production environments. CD refers to the entire automated development pipeline including merging of code, testing, staging, and finally deployment. As changes are merged into the central repository, they are already on their way to the users.  
  
![Continuous Deployment](https://github.com/LiquidPlummer/DevOpsDayLessonPlan/blob/main/continuous-deployment.png?raw=true)  
  
Benefits of CD:
 - Rapid development process
 - Rapid feedback
 - Smaller and less risky releases
 - Regular updates offering users improvements
  
Costs:
 - Requires substantial initial investment
   - Money
   - Time
   - Major paradigm shift
 - Requires continuous investment for maintaining pipeline
 - Documentation, communication, coordination become even more important
